package subway.repository;

import static subway.common.ErrorMessage.NOT_LINE_FOUND;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import subway.domain.Line;

public class LineRepository {
    private static final List<Line> lines = new ArrayList<>();

    public static List<Line> lines() {
        return Collections.unmodifiableList(lines);
    }

    public static void addLine(final Line line) {
        lines.add(line);
    }

    public static void addLines(final List<Line> subwayLines) {
        lines.addAll(subwayLines);
    }

    public static boolean deleteLineByName(final String name) {
        return lines.removeIf(line -> Objects.equals(line.getName(), name));
    }

    public static boolean isExistLineByName(final String name) {
        return lines.stream().anyMatch(line -> Objects.equals(line.getName(), name));
    }

    public static Line findLineByName(final String name) {
        return lines.stream()
                .filter(line -> Objects.equals(line.getName(), name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(NOT_LINE_FOUND.getMessage()));
    }
}
