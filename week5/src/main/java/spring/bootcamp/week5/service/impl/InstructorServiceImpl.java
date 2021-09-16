package spring.bootcamp.week5.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import spring.bootcamp.week5.dto.InstructorDto;
import spring.bootcamp.week5.enums.InstructorType;
import spring.bootcamp.week5.enums.TransactionType;
import spring.bootcamp.week5.exceptions.InstructorIsAlreadyExistException;
import spring.bootcamp.week5.exceptions.ResourceNotFoundException;
import spring.bootcamp.week5.mapper.InstructorMapper;
import spring.bootcamp.week5.model.Instructor;
import spring.bootcamp.week5.model.InstructorTransactionLogger;
import spring.bootcamp.week5.model.abstracts.InstructorSalary;
import spring.bootcamp.week5.repository.InstructorRepository;
import spring.bootcamp.week5.repository.InstructorTransactionLoggerRepository;
import spring.bootcamp.week5.service.InstructorService;
import spring.bootcamp.week5.util.ClientRequestInfo;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class InstructorServiceImpl implements InstructorService {

    private final InstructorMapper instructorMapper;
    private final InstructorRepository instructorRepository;
    private final ClientRequestInfo clientRequestInfo;
    private final InstructorTransactionLoggerRepository loggerRepository;


    @Override
    public InstructorDto save(InstructorDto instructorDto) {
        Instructor instructor = instructorMapper.instructorDtoToInstructor(instructorDto);
        if (instructorRepository.existsByPhoneNumber(instructor.getPhoneNumber()))
            throw new InstructorIsAlreadyExistException("Phone Number with " + instructor.getPhoneNumber() + " is already exist.");
        instructorRepository.save(instructor);
        return instructorMapper.instructorToInstructorDto(instructor);
    }

    @Override
    public void update(InstructorDto instructorDto) {
        Instructor instructor = instructorMapper.instructorDtoToInstructor(instructorDto);
        if (!instructorRepository.existsById(instructor.getId()))
            throw new ResourceNotFoundException("Instructor Id with " + instructor.getId() + " not found.");
        if (instructorRepository.existsByPhoneNumber(instructor.getPhoneNumber()))
            throw new InstructorIsAlreadyExistException("Phone Number with " + instructor.getPhoneNumber() + " is already exist.");
        instructorRepository.save(instructor);
    }

    @Override
    public void delete(long id) {
        if (!instructorRepository.existsById(id))
            throw new ResourceNotFoundException("Instructor Id with " + id + " not found.");
        instructorRepository.deleteById(id);
    }

    @Override
    public List<InstructorDto> findAll() {
        List<Instructor> instructors = instructorRepository.findAll();
        return instructorMapper.mapFromInstructorsToInstructorDto(instructors);
    }

    @Override
    public void salaryTransaction(long id, TransactionType transactionType, double rate) {
        if (!instructorRepository.existsById(id))
            throw new ResourceNotFoundException("Instructor Id with " + id + " not found.");
        InstructorSalary instructorSalary = instructorRepository.getSalaryAndType(id);
        InstructorTransactionLogger transactionLogger = new InstructorTransactionLogger();
        transactionLogger.setInstructorId(id);
        transactionLogger.setSalaryBefore(instructorSalary.getSalary());
        if(transactionType.equals(TransactionType.DECREMENT)){
            transactionLogger.setSalaryAfter(instructorSalary.getSalary() - instructorSalary.getSalary()*rate/100);
        } else {
            transactionLogger.setSalaryAfter(instructorSalary.getSalary() + instructorSalary.getSalary()*rate/100);
        }
        transactionLogger.setTransactionRate(rate);
        transactionLogger.setTransactionType(transactionType);
        transactionLogger.setTransactionDateTime(LocalDate.now());
        transactionLogger.setClientIpAddress(clientRequestInfo.getClientIpAdress());
        transactionLogger.setClientUrl(clientRequestInfo.getClientUrl());
        transactionLogger.setSessionActivityId(clientRequestInfo.getSessionActivityId());

        loggerRepository.save(transactionLogger);

        if(instructorSalary.getType().equals(InstructorType.PERMANENT_INSTRUCTOR)){
            instructorRepository.updatePermanentInstructor(transactionLogger.getSalaryAfter(), id);
        }else {
            instructorRepository.updateVisitingResearcher(transactionLogger.getSalaryAfter(), id);
        }

    }
}
