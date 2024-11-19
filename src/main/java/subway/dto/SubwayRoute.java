package subway.dto;

import java.util.List;

public record SubwayRoute(
        List<SubwayInfo> subwayInfos
) {
}
