package spring.bootcamp.week5.util;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Data
@NoArgsConstructor
@Component
@SessionScope
public class ClientRequestInfo {

    private String clientIpAdress;
    private String clientUrl;
    private String sessionActivityId;

}
