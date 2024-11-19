package subway.domain.station;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class StationRepository {
    private static final List<Station> stations = new ArrayList<>();

    public static List<Station> stations() {
        return Collections.unmodifiableList(stations);
    }

    public static void addStation(final Station station) {
        stations.add(station);
    }

    public static void addStations(final List<Station> inputStations) {
        stations.addAll(inputStations);
    }

    public static boolean deleteStation(final String name) {
        return stations.removeIf(station -> Objects.equals(station.getName(), name));
    }

    public static boolean existsByName(final String name) {
        return stations.stream().anyMatch(station -> station.getName().equals(name));
    }
}
