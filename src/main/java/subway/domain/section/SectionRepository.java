package subway.domain.section;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import subway.domain.line.Line;
import subway.domain.station.Station;

public class SectionRepository {
    private static final Set<Section> sections = new HashSet<>();

    public static Set<Section> sections() {
        return Collections.unmodifiableSet(sections);
    }

    public static void addSections(final Set<Section> inputSections) {
        sections.addAll(inputSections);
    }

    public static void addSection(final Section section) {
        sections.add(section);
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
