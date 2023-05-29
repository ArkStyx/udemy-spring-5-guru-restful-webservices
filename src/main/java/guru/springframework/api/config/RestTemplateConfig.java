package guru.springframework.api.config;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
public class RestTemplateConfig {

	// TODO FIXME ENLEVE LES MESSAGES D'ERREUR MAIS FAIT PLANTER LE SERVEUR ????
//    @Bean
//    public RestTemplateBuilder restTemplateBuilder() {
//    	log.info("Creation de bean - restTemplateBuilder");
//    	return new RestTemplateBuilder();
//    }
	
    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
    	log.info("Creation de bean - restTemplate");
        return builder.build();
    }
    
}
