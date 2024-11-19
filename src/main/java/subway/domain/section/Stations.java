package subway.domain.section;

import java.util.List;
import subway.domain.station.Station;

public class Stations {

    private final List<Station> stations;

    public Stations(final List<Station> stations) {
        this.stations = stations;
    }
}
