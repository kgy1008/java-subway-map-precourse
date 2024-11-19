package subway.domain.station;

import subway.common.ErrorMessage;

public class Station {

    private static final int MIN_LENGTH = 2;
    private static final char STATION_LAST_NAME = '역';
    private static final String HANGUL_REGEX = "^[가-힣]+$";

    private final String name;

    public Station(final String name) {
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
        if (name.matches(HANGUL_REGEX) && findLastName(name) == STATION_LAST_NAME) {
            return;
        }
        throw new IllegalArgumentException(ErrorMessage.INVALID_STATION_NAME_FORMAT.getMessage());
    }

    private char findLastName(final String name) {
        return name.charAt(name.length() - 1);
    }

    private void validateNameLength(final String name) {
        if (name.length() > MIN_LENGTH) {
            return;
        }
        throw new IllegalArgumentException(ErrorMessage.INVALID_STATION_NAME_LENGTH.getMessage());
    }

    private void validateDuplicate(final String name) {
        if (StationRepository.existsByname(name)) {
            throw new IllegalArgumentException(ErrorMessage.CONFLICT_STATION.getMessage());
        }
    }
}
