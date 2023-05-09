package no.nav.promStatusProxy.dtos.Prometheus;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

public class AlertManagerNotificationDto {

    private String version;
    private String groupKey;
    private int truncatedAlerts;
    private AlertStatusDto status;
    private String receiver;
    private Map<String, String> groupLabels;
    private Map<String, String> commonLabels;
    private Map<String, String> commonAnnotations;
    private String externalURL;
    private List<Alert> alerts;

    // getters and setters

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getGroupKey() {
        return groupKey;
    }

    public void setGroupKey(String groupKey) {
        this.groupKey = groupKey;
    }

    public int getTruncatedAlerts() {
        return truncatedAlerts;
    }

    public void setTruncatedAlerts(int truncatedAlerts) {
        this.truncatedAlerts = truncatedAlerts;
    }

    public AlertStatusDto getStatus() {
        return status;
    }

    public void setStatus(AlertStatusDto status) {
        this.status = status;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public Map<String, String> getGroupLabels() {
        return groupLabels;
    }

    public void setGroupLabels(Map<String, String> groupLabels) {
        this.groupLabels = groupLabels;
    }

    public Map<String, String> getCommonLabels() {
        return commonLabels;
    }

    public void setCommonLabels(Map<String, String> commonLabels) {
        this.commonLabels = commonLabels;
    }

    public Map<String, String> getCommonAnnotations() {
        return commonAnnotations;
    }

    public void setCommonAnnotations(Map<String, String> commonAnnotations) {
        this.commonAnnotations = commonAnnotations;
    }

    public String getExternalURL() {
        return externalURL;
    }

    public void setExternalURL(String externalURL) {
        this.externalURL = externalURL;
    }

    public List<Alert> getAlerts() {
        return alerts;
    }

    public void setAlerts(List<Alert> alerts) {
        this.alerts = alerts;
    }

    // inner class for Alert objects
    public static class Alert {
        private String status;
        private Map<String, String> labels;
        private Map<String, String> annotations;
        private LocalDateTime startsAt;
        private LocalDateTime endsAt;
        private String generatorURL;
        private String fingerprint;

        // getters and setters
        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public Map<String, String> getLabels() {
            return labels;
        }

        public void setLabels(Map<String, String> labels) {
            this.labels = labels;
        }

        public Map<String, String> getAnnotations() {
            return annotations;
        }

        public void setAnnotations(Map<String, String> annotations) {
            this.annotations = annotations;
        }

        public LocalDateTime getStartsAt() {
            return startsAt;
        }

        public void setStartsAt(LocalDateTime startsAt) {
            this.startsAt = startsAt;
        }

        public LocalDateTime getEndsAt() {
            return endsAt;
        }

        public void setEndsAt(LocalDateTime endsAt) {
            this.endsAt = endsAt;
        }

        public String getGeneratorURL() {
            return generatorURL;
        }

        public void setGeneratorURL(String generatorURL) {
            this.generatorURL = generatorURL;
        }

        public String getFingerprint() {
            return fingerprint;
        }

        public void setFingerprint(String fingerprint) {
            this.fingerprint = fingerprint;
        }

        @Override
        public String toString() {
            return "Alert{" +
                    "status='" + status + '\'' +
                    ", labels=" + labels +
                    ", annotations=" + annotations +
                    ", startsAt='" + startsAt + '\'' +
                    ", endsAt='" + endsAt + '\'' +
                    ", generatorURL='" + generatorURL + '\'' +
                    ", fingerprint='" + fingerprint + '\'' +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "AlertManagerNotificationDto{" +
                "version='" + version + '\'' +
                ", groupKey='" + groupKey + '\'' +
                ", truncatedAlerts=" + truncatedAlerts +
                ", status=" + status +
                ", receiver='" + receiver + '\'' +
                ", groupLabels=" + groupLabels +
                ", commonLabels=" + commonLabels +
                ", commonAnnotations=" + commonAnnotations +
                ", externalURL='" + externalURL + '\'' +
                ", alerts=" + alerts +
                '}';
    }
}

