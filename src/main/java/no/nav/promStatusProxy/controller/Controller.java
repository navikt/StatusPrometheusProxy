package no.nav.promStatusProxy.controller;

import no.nav.promStatusProxy.util.OauthUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @GetMapping("/")
    public String testToken(){
        try {
            return OauthUtil.getAccessTokenForPortal().toJSONString();
        }
        catch (Exception e){
            return e.getStackTrace().toString();
        }
    }
}
