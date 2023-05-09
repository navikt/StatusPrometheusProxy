package no.nav.promStatusProxy.util;

import no.nav.promStatusProxy.dtos.*;
import no.nav.promStatusProxy.dtos.Prometheus.AlertDto;
import no.nav.promStatusProxy.dtos.Prometheus.AlertManagerNotificationDto;
import no.nav.promStatusProxy.dtos.Prometheus.AlertSeverityDto;
import no.nav.promStatusProxy.dtos.Prometheus.AlertStatusDto;

import java.time.OffsetDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Locale;
import java.util.UUID;

public class AlertToRecordMapper {

    public  static  RecordDto mapToRecordDto(AlertDto alertDto){

            RecordDto recordDto = new RecordDto();
            recordDto.serviceId(UUID.fromString(alertDto.getLabels().get("serviceId")));
            recordDto.status(getStatus(alertDto));
            recordDto.setLogLink(alertDto.getLabels().get("loglink"));
            recordDto.timestamp(OffsetDateTime.now());
            recordDto.description(alertDto.getAnnotations().get("description"));
            return recordDto;
    }
    private static StatusDto getStatus(AlertDto alertDto){
        if(alertDto.getStatus().equals("resolved")){
            return StatusDto.OK;
        }
        else {
            return StatusDto.fromValue(alertDto.getLabels().get("navstatus").toUpperCase(Locale.ROOT));
        }
    }
}
