package subway.domain.response;

import java.util.Arrays;
import subway.common.ErrorMessage;

public enum ManageResponse {
    ONE("1"),
    TWO("2"),
    THREE("3"),
    BACK("B");

    private final String description;

    ManageResponse(final String description) {
        this.description = description;
    }

    public static ManageResponse of(final String description) {
        return Arrays.stream(values())
                .filter(d -> d.isEqual(description))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(ErrorMessage.INVALID_INPUT.getMessage()));
    }

    private boolean isEqual(final String description) {
        return this.description.equals(description);
    }
}
