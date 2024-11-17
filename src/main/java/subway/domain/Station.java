package subway.domain;

import static subway.common.ErrorMessage.CONFLICT_STATION;
import static subway.common.ErrorMessage.INVALID_FORMAT;
import static subway.common.ErrorMessage.INVALID_STATION_NAME_LENGTH;

import subway.repository.StationRepository;

public class Station {
    private static final int MIN_LENGTH = 2;
    private static final String ESSENTIAL_SUFFIX = "역";
    private static final String NO_LINE = "";

    private final String name;
    private final Line line;

    public Station(final String name) {
        validate(name);
        this.name = name;
        this.line = new Line(NO_LINE);
    }

    public boolean isExistInLine() {
        return !line.getName().equals(NO_LINE);
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
            throw new IllegalArgumentException(INVALID_STATION_NAME_LENGTH.getMessage());
        }
    }

    private void validateDuplicated(final String name) {
        if (StationRepository.isExistStationByName(name)) {
            throw new IllegalArgumentException(CONFLICT_STATION.getMessage());
        }
    }

    private void validateFormat(final String name) {
        if (!name.contains(ESSENTIAL_SUFFIX)) {
            throw new IllegalArgumentException(INVALID_FORMAT.getMessage());
        }
    }
}
