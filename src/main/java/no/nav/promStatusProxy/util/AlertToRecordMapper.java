package no.nav.promStatusProxy.util;

import no.nav.promStatusProxy.dtos.*;

public class AlertToRecordMapper {
    private RecordDto generateServiceStatusFromAlert(AlertDto alertDto){

        if(AlertStatusDto.RESOLVED.equals(alertDto.getStatus())){
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
}
