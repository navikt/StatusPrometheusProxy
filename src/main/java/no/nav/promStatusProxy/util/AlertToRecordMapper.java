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
    private RecordDto generateServiceStatusFromAlert(AlertDto alertDto){

        if(AlertStatusDto.resolved.equals(alertDto.getStatus())){
            return new RecordDto()
                    .serviceId(alertDto.getCommonLabels().getAlertname())
                    .status(StatusDto.OK)
                    .description("Resolved alert from prometheus");
        }
        if(AlertSeverityDto.GOOD.equals(alertDto.getCommonAnnotations().getSeverity())){
            return new RecordDto()
                    .serviceId(alertDto.getCommonLabels().getAlertname())
                    .status(StatusDto.OK)
                    .description("Received alert from prometheus, with status ok");

        }
        if(AlertSeverityDto.WARNING.equals(alertDto.getCommonAnnotations().getSeverity())){
            return new RecordDto()
                    .serviceId(alertDto.getCommonLabels().getAlertname())
                    .status(StatusDto.ISSUE)
                    .description("Received alert from prometheus, with status warning");

        }
        if(AlertSeverityDto.DANGER.equals(alertDto.getCommonAnnotations().getSeverity())){
            return new RecordDto()
                    .serviceId(alertDto.getCommonLabels().getAlertname())
                    .status(StatusDto.DOWN)
                    .description("Received alert from prometheus, with status danger");

        }
        else throw new IllegalArgumentException("Malformed alert received");

    }

    public  static  RecordDto mapToRecordDto(AlertManagerNotificationDto amnDto){
            RecordDto recordDto = new RecordDto();
            recordDto.serviceId(UUID.fromString(amnDto.getCommonLabels().get("serviceId")));
            recordDto.status(StatusDto.fromValue(amnDto.getCommonLabels().get("navstatus").toUpperCase(Locale.ROOT)));
            recordDto.setLogLink(amnDto.getCommonLabels().get("logglink"));
            recordDto.timestamp(OffsetDateTime.now());
            recordDto.description(amnDto.getCommonAnnotations().get("description"));
            return recordDto;
    }
}
