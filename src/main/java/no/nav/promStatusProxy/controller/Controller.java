package no.nav.promStatusProxy.controller;

import no.nav.promStatusProxy.dtos.AlertDto;
import no.nav.promStatusProxy.util.OauthUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    Object dto;

    @GetMapping("/accessToken")
    public String testToken(){
        try {
            return OauthUtil.getAccessTokenForPortal().toJSONString();
        }
        catch (Exception e){
            return e.getStackTrace().toString();
        }
    }

    @GetMapping("/dto")
    public String testDto(){
        if(dto != null){
            return dto.toString();

        }
        return "no alert";
    }

    @PostMapping("/")
    public void postAlert(Object dto){
        this.dto = dto;
        System.out.println("Recived alert: " + dto);


    }
}
