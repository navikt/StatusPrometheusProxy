package no.nav.promStatusProxy.controller;

import com.nimbusds.jose.shaded.gson.JsonObject;
import no.nav.promStatusProxy.dtos.AlertDto;
import no.nav.promStatusProxy.util.OauthUtil;
import org.springframework.web.bind.annotation.*;

@RestController
public class Controller {
    AlertDto dto;
    JsonObject jsonObject;

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
    public void postAlert(AlertDto alertDto){
        this.dto = alertDto;
        System.out.println("Recived alert: " + alertDto);
    }

    @RequestMapping(value = "/test", method = RequestMethod.POST, consumes = "application/json")
    public void postJson(JsonObject jsonObject){
        this.jsonObject = jsonObject;
        System.out.println("Recived Json: " + jsonObject);
    }
}
