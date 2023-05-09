package no.nav.promStatusProxy.dtos.Prometheus;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * CommonAnnotationsDto
 */
public class CommonAnnotationsDto {

    private AlertSeverityDto severity = null;

    public static String[] readOnlyFields() {
        return new String[] {
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
     * Get severity
     * @return severity
     */
    public AlertSeverityDto getSeverity() {
        return severity;
    }

    public void setSeverity(AlertSeverityDto severity) {
        this.severity = severity;
    }

    public CommonAnnotationsDto severity(AlertSeverityDto severity) {
        this.severity = severity;
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
        CommonAnnotationsDto commonAnnotations = (CommonAnnotationsDto) o;
        return Objects.equals(this.getSeverity(), commonAnnotations.getSeverity());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getSeverity());
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class CommonAnnotationsDto {\n");
        sb.append("    severity: ").append(toIndentedString(getSeverity())).append("\n");
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

