package subway.domain.section;

import java.util.List;
import subway.common.ErrorMessage;
import subway.domain.line.Line;
import subway.domain.station.Station;

public class Section {

    private final Line line;
    private final Stations stations;

    public Section(final Line line, final List<Station> stations) {
        this.line = line;
        this.stations = new Stations(stations);
    }

    boolean isContainStation(final Station station) {
        return stations.isContain(station);
    }

    boolean isEqualLine(final Line line) {
        return this.line.equals(line);
    }

    void addStation(final Station station, final int sequence) {
        validateAddStation(station);
        stations.add(station, sequence);
    }

    void deleteStation(final Station station) {
        validateDeleteStation(station);
        stations.delete(station);
    }

    int getStationCount() {
        return stations.getSize();
    }

    private void validateAddStation(final Station station) {
        if (stations.isContain(station)) {
            throw new IllegalArgumentException(ErrorMessage.CONFLICT_SECTION.getMessage());
        }
    }

    private void validateDeleteStation(final Station station) {
        if (!stations.isContain(station)) {
            throw new IllegalArgumentException(ErrorMessage.NOT_FOUND_STATION_IN_SECTION.getMessage());
        }
    }
}
