package no.nav.promStatusProxy.controller;

import no.nav.promStatusProxy.dtos.Prometheus.AlertDto;
import no.nav.promStatusProxy.dtos.Prometheus.AlertManagerNotificationDto;
import no.nav.promStatusProxy.dtos.Prometheus.AlertStatusDto;
import no.nav.promStatusProxy.dtos.RecordDto;
import no.nav.promStatusProxy.util.AlertToRecordMapper;
import no.nav.promStatusProxy.util.OauthUtil;
import no.nav.promStatusProxy.util.PortalserverKlient;
import org.springframework.web.bind.annotation.*;

import java.util.Comparator;
import java.util.Optional;

@RestController
public class Controller {
    AlertManagerNotificationDto dto;
    AlertDto alertDto;
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

    @GetMapping("/alert")
    public String alertDto(){
        if(dto != null){
            return alertDto.toString();

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
        Optional<AlertDto> alert = alertDto
                .getAlerts()
                .stream()
                .max(Comparator.comparing(AlertDto::getStartsAt));
        this.alertDto = alert.get();


        try{
            RecordDto recordDto1 = AlertToRecordMapper.mapToRecordDto(alert.get());
            recordDto = recordDto1;
            PortalserverKlient.postStatus(recordDto1);

        }
        catch (Exception e){
            System.out.println(e.toString());
            recordDto = null;
        }
        System.out.println("Recived alert: " + alertDto);
    }


    @RequestMapping(value = "/value", method = RequestMethod.POST, consumes = "application/json")
    public void postJson(AlertStatusDto value){
        System.out.println("Recived Json: " + value);
    }
}
