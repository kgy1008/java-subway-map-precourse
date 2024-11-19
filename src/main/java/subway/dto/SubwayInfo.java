package subway.dto;

import java.util.List;

public record SubwayInfo(
        String lines,
        List<String> stationNames
) {
}
