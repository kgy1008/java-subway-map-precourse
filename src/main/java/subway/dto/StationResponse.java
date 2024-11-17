package subway.dto;

import java.util.List;

public record StationResponse(
        List<String> stations
) {
}
