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



    @RequestMapping(value = "/alert", method = RequestMethod.POST, consumes = "application/json")
    public void postAlert(@RequestBody AlertManagerNotificationDto alertDto){

        Optional<AlertDto> alert = alertDto
                .getAlerts()
                .stream()
                .max(Comparator.comparing(AlertDto::getStartsAt));



        try{
            RecordDto recordDto1 = AlertToRecordMapper.mapToRecordDto(alert.get());
            PortalserverKlient.postStatus(recordDto1);

        }
        catch (Exception e){
            System.out.println(e);
        }
        System.out.println("Recived alert: " + alertDto);
    }

}
