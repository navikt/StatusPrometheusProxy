package no.nav.promStatusProxy.controller;

import com.nimbusds.jose.shaded.gson.JsonObject;
import no.nav.promStatusProxy.dtos.AlertDto;
import no.nav.promStatusProxy.dtos.AlertStatusDto;
import no.nav.promStatusProxy.util.OauthUtil;
import org.springframework.web.bind.annotation.*;

@RestController
public class Controller {
    AlertDto dto;

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

    @RequestMapping(value = "/alert", method = RequestMethod.POST, consumes = "application/json")
    public void postAlert(@RequestBody AlertDto alertDto){
        this.dto = alertDto;
        System.out.println("Recived alert: " + alertDto);
    }


    @RequestMapping(value = "/value", method = RequestMethod.POST, consumes = "application/json")
    public void postJson(AlertStatusDto value){
        System.out.println("Recived Json: " + value);
    }
}
