package subway.domain.section;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import subway.common.ErrorMessage;
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

    public static boolean isExistByLine(final Line line) {
        return sections().stream()
                .anyMatch(section -> section.isEqualLine(line));
    }

    public static Section findByLine(final Line line) {
        return sections().stream()
                .filter(section -> section.isEqualLine(line))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(ErrorMessage.NOT_FOUND_SECTION.getMessage()));
    }
}
