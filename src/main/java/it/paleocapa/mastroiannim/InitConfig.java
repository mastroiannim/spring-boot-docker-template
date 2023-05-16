package it.paleocapa.mastroiannim;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class InitConfig {
    
    @Value("${telegram.username}")
    private String botUsername;
    
    @Value("${telegram.token}")
    private String botToken;
    
    public String getBotUsername() {
        return botUsername;
    }

    public String getBotToken() {
        return botToken;
    }

}
