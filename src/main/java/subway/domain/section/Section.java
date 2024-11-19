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
        validateStation(station);
        stations.add(station, sequence);
    }

    private void validateStation(final Station station) {
        if (stations.isContain(station)) {
            throw new IllegalArgumentException(ErrorMessage.CONFLICT_SECTION.getMessage());
        }
    }
}
