package subway.domain;

import static subway.common.ErrorMessage.INVALID_INPUT;

import java.util.Arrays;

public enum ManagementResponse {
    ONE("1"),
    TWO("2"),
    THREE("3"),
    BACK("B");

    private final String description;

    ManagementResponse(final String description) {
        this.description = description;
    }

    public static ManagementResponse from(final String description) {
        return Arrays.stream(values())
                .filter(response -> response.description.equals(description))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(INVALID_INPUT.getMessage()));
    }
}
