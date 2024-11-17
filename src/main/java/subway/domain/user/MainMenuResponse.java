package subway.domain.user;

import static subway.common.ErrorMessage.INVALID_INPUT;

import java.util.Arrays;

public enum MainMenuResponse {
    ONE("1"),
    TWO("2"),
    THREE("3"),
    FOUR("4"),
    EXIT("Q");

    private final String description;

    MainMenuResponse(final String description) {
        this.description = description;
    }

    public static MainMenuResponse from(final String description) {
        return Arrays.stream(values())
                .filter(response -> response.description.equals(description))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(INVALID_INPUT.getMessage()));
    }
}
