package subway.domain.section;

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

    void add(final Station station, final int sequence) {
        try {
            int index = sequence - 1;
            validateIndex(index);
            stations.add(index, station);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void validateIndex(int index) {
        if (index > stations.size()) {
            throw new IllegalArgumentException(ErrorMessage.OUT_OF_RANGE.getMessage());
        }
    }
}
