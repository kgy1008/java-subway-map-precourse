package subway.domain;

import java.util.HashSet;
import java.util.Set;

public class Lines {
    private static final Set<Line> NO_LINE = new HashSet<>();
    private final Set<Line> lines;

    public Lines() {
        this.lines = NO_LINE;
    }

    int getSize() {
        return lines.size();
    }

    void add(final Line line) {
        lines.add(line);
    }
}
