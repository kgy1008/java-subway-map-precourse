package subway.domain.line;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import subway.common.ErrorMessage;

public class LineRepository {
    private static final List<Line> lines = new ArrayList<>();

    public static List<Line> lines() {
        return Collections.unmodifiableList(lines);
    }

    public static void addLine(final Line line) {
        lines.add(line);
    }

    public static void addLines(final List<Line> inputLines) {
        lines.addAll(inputLines);
    }

    public static void deleteLine(final Line line) {
        lines.remove(line);
    }

    public static boolean existsByName(final String name) {
        return lines.stream()
                .anyMatch(line -> line.getName().equals(name));
    }

    public static Line findByName(final String name) {
        return lines.stream()
                .filter(line -> line.getName().equals(name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(ErrorMessage.NOT_FOUND_LINE.getMessage()));
    }
}
