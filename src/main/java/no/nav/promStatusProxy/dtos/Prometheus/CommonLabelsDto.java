package no.nav.promStatusProxy.dtos.Prometheus;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

/**
 * CommonLabelsDto
 */
public class CommonLabelsDto {

    private UUID alertname = null;

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
     * Get alertname
     * @return alertname
     */
    public UUID getAlertname() {
        return alertname;
    }

    public void setAlertname(UUID alertname) {
        this.alertname = alertname;
    }

    public CommonLabelsDto alertname(UUID alertname) {
        this.alertname = alertname;
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
        CommonLabelsDto commonLabels = (CommonLabelsDto) o;
        return Objects.equals(this.getAlertname(), commonLabels.getAlertname());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getAlertname());
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class CommonLabelsDto {\n");
        sb.append("    alertname: ").append(toIndentedString(getAlertname())).append("\n");
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

