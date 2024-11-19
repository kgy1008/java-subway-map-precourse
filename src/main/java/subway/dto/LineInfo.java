package subway.dto;

import java.util.List;
import subway.domain.line.Line;

public record LineInfo(
        List<String> lineNames
) {
    public static LineInfo of(final List<Line> lines) {
        return new LineInfo(lines.stream().map(Line::getName).toList());
    }
}
