package guru.springframework.api.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.server.ServerWebExchange;

import guru.springframework.api.domain.User;
import guru.springframework.api.services.ApiService;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;

@Slf4j
@Controller
public class UserController {

	private static final int VALEUR_PAR_DEFAUT = 10;
	
    private ApiService apiService;

    public UserController(ApiService apiService) {
        this.apiService = apiService;
    }

    @GetMapping({"", "/", "/index"})
    public String index(){
        return "index";
    }

    // TODO A VERIFIER
    @PostMapping("/users")
    public String formPost(Model model, ServerWebExchange serverWebExchange){
    	log.debug("formPost - Start");
    	
        MultiValueMap<String, String> map = serverWebExchange.getFormData().block();

        String limitString = (map.get("limit").get(0));
        log.debug("limitString : " + limitString);
        
        Integer limit = Integer.valueOf(limitString);
        log.debug("limit : " + limit);
        
        if (limit == null || limit == 0) {
            limit = VALEUR_PAR_DEFAUT;
        }

        model.addAttribute("users", apiService.getUsers(limit));
        
        log.debug("formPost - End");
        return "userlist";
    }
    
    // TODO A VERIFIER
    @PostMapping("/users_flux")
    public String formPostFlux(Model model, ServerWebExchange serverWebExchange) {
    	log.debug("formPost - Start");
    	
    	Flux<User> fluxUser = apiService.getUsers(serverWebExchange.getFormData().map(data -> {
				String limitString = data.getFirst("limit");
				return Integer.valueOf(limitString);
			})
		);
    	
        model.addAttribute("users", fluxUser);

        log.debug("formPost - End");
        return "userlist";
    }
    
}
