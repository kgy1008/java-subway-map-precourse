package subway.domain.section;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import subway.domain.line.Line;
import subway.domain.station.Station;

public class SectionRepository {
    private static final List<Section> sections = new ArrayList<>();

    public static List<Section> sections() {
        return Collections.unmodifiableList(sections);
    }

    public static void addSections(final List<Section> inputSections) {
        sections.addAll(inputSections);
    }

    public static boolean isExistStation(final Station station) {
        return sections.stream()
                .anyMatch(section -> section.isContainStation(station));
    }

    public static boolean isExistLine(final Line line) {
        return sections().stream()
                .anyMatch(section -> section.isContainLine(line));
    }
}
