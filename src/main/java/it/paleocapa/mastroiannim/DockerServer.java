package it.paleocapa.mastroiannim;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.reactive.function.client.WebClient;
import org.telegram.telegrambots.meta.api.methods.GetMe;
import org.telegram.telegrambots.meta.api.objects.User;
import org.telegram.telegrambots.meta.exceptions.TelegramApiRequestException;

import reactor.core.publisher.Mono;



@SpringBootApplication(scanBasePackages={"it.paleocapa.mastroiannim"})
@EnableJpaRepositories(basePackages = {"it.paleocapa.mastroiannim.repository"})
public class DockerServer {

	private static final Logger LOG = LoggerFactory.getLogger(DockerServer.class);

    @Autowired
    private WebClient client;
    
    public static void main(String[] args) {
        SpringApplication.run(DockerServer.class, args);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void applicationReady() {
        
        LOG.info("hello world, I have just started up");
        
        final String METHOD = "/getMe";
        Mono<String> response = client.get()
            .uri(METHOD)
            .retrieve()
            .bodyToMono(String.class);

        response.subscribe(this::extracted);
        

    }

    private void extracted(String s){
        try{
            User u = new GetMe().deserializeResponse(s);
            LOG.info(u.toString());
        }catch(TelegramApiRequestException e){
            throw new RuntimeException(e);
        }
    }



}
