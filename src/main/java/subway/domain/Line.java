package subway.domain;

import static subway.common.ErrorMessage.CONFLICT_LINE;
import static subway.common.ErrorMessage.INVALID_FORMAT;
import static subway.common.ErrorMessage.INVALID_LINE_NAME_LENGTH;

import subway.repository.LineRepository;

public class Line {
    private static final int MIN_LENGTH = 2;
    private static final String ESSENTIAL_SUFFIX = "호선";
    private final String name;
    private final Stations stations;

    public Line(final String name) {
        validate(name);
        this.name = name;
        this.stations = new Stations();
    }

    public boolean isExistStations() {
        return stations.getSize() != 0;
    }

    public boolean hasStation(final Station station) {
        return stations.hasStation(station);
    }

    public void registerLine(final String startStation, final String endStation) {
        stations.registerStations(startStation, endStation);
    }

    public void addStation(final Station station, final int sequence) {
        stations.add(station, sequence);
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
            throw new IllegalArgumentException(INVALID_LINE_NAME_LENGTH.getMessage());
        }
    }

    private void validateDuplicated(final String name) {
        if (LineRepository.isExistLineByName(name)) {
            throw new IllegalArgumentException(CONFLICT_LINE.getMessage());
        }
    }

    private void validateFormat(final String name) {
        if (!name.contains(ESSENTIAL_SUFFIX)) {
            throw new IllegalArgumentException(INVALID_FORMAT.getMessage());
        }
    }
}
