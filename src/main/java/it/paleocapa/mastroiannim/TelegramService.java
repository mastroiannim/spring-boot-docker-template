package it.paleocapa.mastroiannim;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class TelegramService {

    @Value("${telegram.token}")
    private String botToken;

    @Value("${telegram.username}")
    private String botUsername;

    @Bean
    public WebClient getWebClient(){
        final String uri = "https://api.telegram.org/bot" + botToken;
        return WebClient.builder().baseUrl(uri).build();
    }
}
