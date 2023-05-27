package guru.springframework.api.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.server.ServerWebExchange;

import guru.springframework.api.services.ApiService;
import lombok.extern.slf4j.Slf4j;

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

//        model.addAttribute("users", apiService.getUsersApiFaketoryProduction(limit));
        model.addAttribute("users", apiService.getUsersApiFaketoryMockServer(limit));
        
        log.debug("formPost - End");
        return "userlist";
    }
    
    
    
    /*
    TODO FIXME
    
    Sun May 28 00:16:45 CEST 2023
[398f6323-5] There was an unexpected error (type=Not Found, status=404).
org.springframework.web.server.ResponseStatusException: 404 NOT_FOUND
	at org.springframework.web.reactive.resource.ResourceWebHandler.lambda$handle$1(ResourceWebHandler.java:406)
	Suppressed: The stacktrace has been enhanced by Reactor, refer to additional information below: 
Error has been observed at the following site(s):
	*__checkpoint ⇢ HTTP POST "/users/" [ExceptionHandlingWebHandler]
Original Stack Trace:
    */
}
