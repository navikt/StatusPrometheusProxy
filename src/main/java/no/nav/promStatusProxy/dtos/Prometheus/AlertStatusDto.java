package no.nav.promStatusProxy.dtos.Prometheus;

import java.util.Arrays;
import java.util.List;


/**
 * Gets or Sets AlertStatus
 */
public enum AlertStatusDto {

    firing("firing"),
    resolved("resolved");

    private String value;

    AlertStatusDto(String value) {
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
                "firing",
                "resolved",
        });
    }

    public static AlertStatusDto fromValue(String text) {
        for (AlertStatusDto b : AlertStatusDto.values()) {
            if (String.valueOf(b.value).equals(text)) {
                return b;
            }
        }
        throw new IllegalArgumentException("Unexpected value '" + text + "' (should be one of " + getValues() + ")");
    }
}

