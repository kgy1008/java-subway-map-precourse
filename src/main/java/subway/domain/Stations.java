package subway.domain;

import java.util.HashSet;
import java.util.Set;

public class Stations {
    private static final Set<Line> NO_STATION = new HashSet<>();
    private final Set<Station> stations;

    public Stations() {
        stations = new HashSet<>();
    }
}
