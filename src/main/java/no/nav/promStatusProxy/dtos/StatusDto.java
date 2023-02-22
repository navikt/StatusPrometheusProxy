package no.nav.promStatusProxy.dtos;

import java.util.Arrays;
import java.util.List;


/**
 * Gets or Sets Status
 */
public enum StatusDto {

    OK("OK"),
    ISSUE("ISSUE"),
    DOWN("DOWN");

    private String value;

    StatusDto(String value) {
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
                "OK",
                "ISSUE",
                "DOWN",
        });
    }

    public static StatusDto fromValue(String text) {
        for (StatusDto b : StatusDto.values()) {
            if (String.valueOf(b.value).equals(text)) {
                return b;
            }
        }
        throw new IllegalArgumentException("Unexpected value '" + text + "' (should be one of " + getValues() + ")");
    }
}

