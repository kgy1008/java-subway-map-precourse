package subway.dto;

import java.util.List;
import subway.domain.Line;
import subway.domain.Station;
import subway.domain.Stations;

public record SubwayResponse(
        String line,
        List<String> stations
) {
    public static SubwayResponse of(Line line, Stations stations) {
        List<String> stationNames = stations.getStations().stream()
                .map(Station::getName)
                .toList();
        return new SubwayResponse(line.getName(), stationNames);
    }
}
