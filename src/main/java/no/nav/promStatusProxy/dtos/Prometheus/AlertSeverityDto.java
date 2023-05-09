package no.nav.promStatusProxy.dtos.Prometheus;

import java.util.Arrays;
import java.util.List;

/**
 * Gets or Sets AlertSeverity
 */
public enum AlertSeverityDto {

    GOOD("good"),
    WARNING("warning"),
    DANGER("danger");

    private String value;

    AlertSeverityDto(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }

    public static List<String> getValues() {
        return Arrays.asList(new String[] {
                "good",
                "warning",
                "danger",
        });
    }

    public static AlertSeverityDto fromValue(String text) {
        for (AlertSeverityDto b : AlertSeverityDto.values()) {
            if (String.valueOf(b.value).equals(text)) {
                return b;
            }
        }
        throw new IllegalArgumentException("Unexpected value '" + text + "' (should be one of " + getValues() + ")");
    }
}

