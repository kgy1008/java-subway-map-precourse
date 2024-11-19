package subway.domain.section;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SectionRepository {
    private static final List<Section> sections = new ArrayList<>();

    public static List<Section> sections() {
        return Collections.unmodifiableList(sections);
    }

    public static void addSections(final List<Section> inputSections) {
        sections.addAll(inputSections);
    }
}
