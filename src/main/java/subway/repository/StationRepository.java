package subway.repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import subway.domain.Station;

public class StationRepository {
    private static final List<Station> stations = new ArrayList<>();

    public static List<Station> stations() {
        return Collections.unmodifiableList(stations);
    }

    public static void addStation(final Station station) {
        stations.add(station);
    }

    public static void addStations(final List<Station> subwayStations) {
        stations.addAll(subwayStations);
    }

    public static boolean deleteStation(final String name) {
        return stations.removeIf(station -> Objects.equals(station.getName(), name));
    }

    public static boolean isExistStationByName(final String name) {
        return stations().stream().anyMatch(line -> Objects.equals(line.getName(), name));
    }
}
