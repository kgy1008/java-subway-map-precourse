package subway.dto;

import java.util.List;
import subway.domain.station.Station;

public record StationInfo(
        List<String> stationNames
) {
    public static StationInfo of(final List<Station> stations) {
        return new StationInfo(stations.stream().map(Station::getName).toList());
    }
}
