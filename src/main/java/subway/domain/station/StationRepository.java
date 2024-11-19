package subway.domain.station;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import subway.common.ErrorMessage;

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

    public static void deleteStation(final Station station) {
        stations.remove(station);
    }

    public static boolean existsByName(final String name) {
        return stations.stream()
                .anyMatch(station -> station.getName().equals(name));
    }

    public static Station findByName(final String name) {
        return stations.stream()
                .filter(station -> station.getName().equals(name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(ErrorMessage.NOT_FOUND_STATION.getMessage()));
    }
}
