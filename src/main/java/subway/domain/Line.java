package subway.domain;

import static subway.common.ErrorMessage.CONFLICT_LINE;
import static subway.common.ErrorMessage.INVALID_FORMAT;
import static subway.common.ErrorMessage.INVALID_LENGTH;

import subway.repository.LineRepository;

public class Line {
    private static final int MIN_LENGTH = 2;
    private static final String ESSENTIAL_SUFFIX = "호선";
    private final String name;

    public Line(final String name) {
        validate(name);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    private void validate(final String name) {
        validateName(name);
        validateDuplicated(name);
        validateFormat(name);
    }

    private void validateName(final String name) {
        if (name.length() < MIN_LENGTH) {
            throw new IllegalArgumentException(INVALID_LENGTH.getMessage());
        }
    }

    private void validateDuplicated(final String name) {
        if (LineRepository.isExistLineByName(name)) {
            throw new IllegalArgumentException(CONFLICT_LINE.getMessage());
        }
    }

    private void validateFormat(final String name) {
        if (!name.contains("ESSENTIAL_SUFFIX")) {
            throw new IllegalArgumentException(INVALID_FORMAT.getMessage());
        }
    }
}
