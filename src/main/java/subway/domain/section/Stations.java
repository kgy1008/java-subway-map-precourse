package subway.domain.section;

import java.util.Collections;
import java.util.List;
import subway.common.ErrorMessage;
import subway.domain.station.Station;

public class Stations {

    private final List<Station> stations;

    public Stations(final List<Station> stations) {
        this.stations = stations;
    }

    boolean isContain(final Station station) {
        return stations.contains(station);
    }

    int getSize() {
        return stations.size();
    }

    void add(final Station station, final int sequence) {
        int index = sequence - 1;
        validateIndex(index);
        stations.add(index, station);
    }

    void delete(final Station station) {
        stations.remove(station);
    }

    List<Station> getStations() {
        return Collections.unmodifiableList(stations);
    }

    private void validateIndex(int index) {
        if (index > stations.size()) {
            throw new IllegalArgumentException(ErrorMessage.OUT_OF_RANGE.getMessage());
        }
    }
}
