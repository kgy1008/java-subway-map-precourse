package subway.domain.line;

import subway.common.ErrorMessage;

public class Line {

    private static final int MIN_LENGTH = 2;
    private static final char LINE_LAST_NAME = '선';

    private final String name;

    public Line(final String name) {
        validate(name);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    private void validate(final String name) {
        validateFormat(name);
        validateNameLength(name);
        validateDuplicate(name);
    }

    private void validateFormat(final String name) {
        if (findLastName(name) == LINE_LAST_NAME) {
            return;
        }
        throw new IllegalArgumentException(ErrorMessage.INVALID_LINE_NAME_FORMAT.getMessage());
    }

    private char findLastName(final String name) {
        return name.charAt(name.length() - 1);
    }

    private void validateNameLength(final String name) {
        if (name.length() > MIN_LENGTH) {
            return;
        }
        throw new IllegalArgumentException(ErrorMessage.INVALID_LINE_NAME_LENGTH.getMessage());
    }

    private void validateDuplicate(final String name) {
        if (LineRepository.existsByName(name)) {
            throw new IllegalArgumentException(ErrorMessage.CONFLICT_LINE.getMessage());
        }
    }
}
