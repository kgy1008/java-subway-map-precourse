package subway.domain.line;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

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

    public static boolean deleteLineByName(final String name) {
        return lines.removeIf(line -> Objects.equals(line.getName(), name));
    }

    public static boolean existsByName(final String name) {
        return lines.stream().anyMatch(line -> line.getName().equals(name));
    }
}
