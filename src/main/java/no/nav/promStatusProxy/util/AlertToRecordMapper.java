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
            recordDto.status(StatusDto.fromValue(alertDto.getLabels().get("navstatus").toUpperCase(Locale.ROOT)));
            recordDto.setLogLink(alertDto.getLabels().get("logglink"));
            recordDto.timestamp(OffsetDateTime.now());
            recordDto.description(alertDto.getAnnotations().get("description"));
            return recordDto;
    }
}
