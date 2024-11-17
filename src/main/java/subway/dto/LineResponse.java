package subway.dto;

import java.util.List;

public record LineResponse(
        List<String> lines
) {
}
