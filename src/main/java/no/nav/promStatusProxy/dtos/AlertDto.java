package no.nav.promStatusProxy.dtos;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;


/**
 * AlertDto
 */
public class AlertDto {

    private String receiver = null;

    private AlertStatusDto status = null;

    private List<Object> alerts = null;

    private Object groupLabels = null;

    private CommonLabelsDto commonLabels = null;

    private CommonAnnotationsDto commonAnnotations = null;

    private String externalURL = null;

    private String version = null;

    private String groupKey = null;

    public static String[] readOnlyFields() {
        return new String[] {
                "receiver",
                "alerts",
                "groupLabels",
                "externalURL",
                "version",
                "groupKey",
        };
    }

    public static String[] writeOnlyFields() {
        return new String[] {
        };
    }

    public static String[] requiredFields() {
        return new String[] {
        };
    }

    public List<String> missingRequiredFields() {
        List<String> result = new ArrayList<>();
        return result;
    }

    public void readOnlyFieldsWithValue(List<String> result) {
        if (!isMissing(getReceiver())) {
            result.add("AlertDto.receiver");
        }
        if (!isMissing(getAlerts()) && !getAlerts().isEmpty()) {
            result.add("AlertDto.alerts");
        }
        if (!isMissing(getGroupLabels())) {
            result.add("AlertDto.groupLabels");
        }
        if (commonLabels != null) {
            commonLabels.readOnlyFieldsWithValue(result);
        }
        if (commonAnnotations != null) {
            commonAnnotations.readOnlyFieldsWithValue(result);
        }
        if (!isMissing(getExternalURL())) {
            result.add("AlertDto.externalURL");
        }
        if (!isMissing(getVersion())) {
            result.add("AlertDto.version");
        }
        if (!isMissing(getGroupKey())) {
            result.add("AlertDto.groupKey");
        }
    }

    private boolean isMissing(String s) {
        return s == null || s.isEmpty();
    }

    private boolean isMissing(List<?> list) {
        return list == null;
    }

    private boolean isMissing(Object s) {
        return s == null;
    }


    /**
     * Get receiver
     * read only
     * @return receiver
     */
    public String getReceiver() {
        return receiver;
    }

    /** <strong>read only</strong> */
    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public AlertDto receiver(String receiver) {
        this.receiver = receiver;
        return this;
    }

    /**
     * Get status
     * @return status
     */
    public AlertStatusDto getStatus() {
        return status;
    }

    public void setStatus(AlertStatusDto status) {
        this.status = status;
    }

    public AlertDto status(AlertStatusDto status) {
        this.status = status;
        return this;
    }

    public <T> AlertDto alerts(Collection<T> items, Function<T, Object> mapper) {
        return alerts(items.stream().map(mapper).collect(Collectors.toList()));
    }

    public <T> List<T> getAlerts(Function<Object, T> mapper) {
        return getAlerts().stream().map(mapper).collect(Collectors.toList());
    }

    public AlertDto addAlertsItem(Object alertsItem) {
        if (this.alerts == null) {
            this.alerts = new ArrayList<>();
        }
        this.alerts.add(alertsItem);
        return this;
    }

    /**
     * Get alerts
     * read only
     * @return alerts
     */
    public List<Object> getAlerts() {
        return alerts;
    }

    /** <strong>read only</strong> */
    public void setAlerts(List<Object> alerts) {
        this.alerts = alerts;
    }

    public AlertDto alerts(List<Object> alerts) {
        this.alerts = alerts;
        return this;
    }

    /**
     * Get groupLabels
     * read only
     * @return groupLabels
     */
    public Object getGroupLabels() {
        return groupLabels;
    }

    /** <strong>read only</strong> */
    public void setGroupLabels(Object groupLabels) {
        this.groupLabels = groupLabels;
    }

    public AlertDto groupLabels(Object groupLabels) {
        this.groupLabels = groupLabels;
        return this;
    }

    /**
     * Get commonLabels
     * @return commonLabels
     */
    public CommonLabelsDto getCommonLabels() {
        return commonLabels;
    }

    public void setCommonLabels(CommonLabelsDto commonLabels) {
        this.commonLabels = commonLabels;
    }

    public AlertDto commonLabels(CommonLabelsDto commonLabels) {
        this.commonLabels = commonLabels;
        return this;
    }

    /**
     * Get commonAnnotations
     * @return commonAnnotations
     */
    public CommonAnnotationsDto getCommonAnnotations() {
        return commonAnnotations;
    }

    public void setCommonAnnotations(CommonAnnotationsDto commonAnnotations) {
        this.commonAnnotations = commonAnnotations;
    }

    public AlertDto commonAnnotations(CommonAnnotationsDto commonAnnotations) {
        this.commonAnnotations = commonAnnotations;
        return this;
    }

    /**
     * Get externalURL
     * read only
     * @return externalURL
     */
    public String getExternalURL() {
        return externalURL;
    }

    /** <strong>read only</strong> */
    public void setExternalURL(String externalURL) {
        this.externalURL = externalURL;
    }

    public AlertDto externalURL(String externalURL) {
        this.externalURL = externalURL;
        return this;
    }

    /**
     * Get version
     * read only
     * @return version
     */
    public String getVersion() {
        return version;
    }

    /** <strong>read only</strong> */
    public void setVersion(String version) {
        this.version = version;
    }

    public AlertDto version(String version) {
        this.version = version;
        return this;
    }

    /**
     * Get groupKey
     * read only
     * @return groupKey
     */
    public String getGroupKey() {
        return groupKey;
    }

    /** <strong>read only</strong> */
    public void setGroupKey(String groupKey) {
        this.groupKey = groupKey;
    }

    public AlertDto groupKey(String groupKey) {
        this.groupKey = groupKey;
        return this;
    }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        AlertDto alert = (AlertDto) o;
        return Objects.equals(this.getReceiver(), alert.getReceiver()) &&
                Objects.equals(this.getStatus(), alert.getStatus()) &&
                Objects.equals(this.getAlerts(), alert.getAlerts()) &&
                Objects.equals(this.getGroupLabels(), alert.getGroupLabels()) &&
                Objects.equals(this.getCommonLabels(), alert.getCommonLabels()) &&
                Objects.equals(this.getCommonAnnotations(), alert.getCommonAnnotations()) &&
                Objects.equals(this.getExternalURL(), alert.getExternalURL()) &&
                Objects.equals(this.getVersion(), alert.getVersion()) &&
                Objects.equals(this.getGroupKey(), alert.getGroupKey());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getReceiver(), getStatus(), getAlerts(), getGroupLabels(), getCommonLabels(), getCommonAnnotations(), getExternalURL(), getVersion(), getGroupKey());
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class AlertDto {\n");
        sb.append("    receiver: ").append(toIndentedString(getReceiver())).append("\n");
        sb.append("    status: ").append(toIndentedString(getStatus())).append("\n");
        sb.append("    alerts: ").append(toIndentedString(getAlerts())).append("\n");
        sb.append("    groupLabels: ").append(toIndentedString(getGroupLabels())).append("\n");
        sb.append("    commonLabels: ").append(toIndentedString(getCommonLabels())).append("\n");
        sb.append("    commonAnnotations: ").append(toIndentedString(getCommonAnnotations())).append("\n");
        sb.append("    externalURL: ").append(toIndentedString(getExternalURL())).append("\n");
        sb.append("    version: ").append(toIndentedString(getVersion())).append("\n");
        sb.append("    groupKey: ").append(toIndentedString(getGroupKey())).append("\n");
        sb.append("}");
        return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    private String toIndentedString(java.lang.Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }
}

