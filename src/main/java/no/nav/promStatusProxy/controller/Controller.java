package no.nav.promStatusProxy.controller;

import no.nav.promStatusProxy.dtos.Prometheus.AlertManagerNotificationDto;
import no.nav.promStatusProxy.dtos.Prometheus.AlertStatusDto;
import no.nav.promStatusProxy.dtos.RecordDto;
import no.nav.promStatusProxy.util.AlertToRecordMapper;
import no.nav.promStatusProxy.util.OauthUtil;
import org.springframework.web.bind.annotation.*;

@RestController
public class Controller {
    AlertManagerNotificationDto dto;
    RecordDto recordDto;

    @GetMapping("/accessToken")
    public String testToken(){
        try {
            return OauthUtil.getAccessTokenForPortal();
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

    @GetMapping("/record")
    public String record(){
        if(recordDto != null){
            return recordDto.toString();

        }
        return "no record";
    }

    @RequestMapping(value = "/alert", method = RequestMethod.POST, consumes = "application/json")
    public void postAlert(@RequestBody AlertManagerNotificationDto alertDto){
        this.dto = alertDto;
        RecordDto recordDto1 = AlertToRecordMapper.mapToRecordDto(alertDto);
        recordDto = recordDto1;
        System.out.println("Recived alert: " + alertDto);
    }


    @RequestMapping(value = "/value", method = RequestMethod.POST, consumes = "application/json")
    public void postJson(AlertStatusDto value){
        System.out.println("Recived Json: " + value);
    }
}
