package subway.config;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import subway.domain.line.Line;
import subway.domain.line.LineRepository;
import subway.domain.section.Section;
import subway.domain.section.SectionRepository;
import subway.domain.station.Station;
import subway.domain.station.StationRepository;

public class Initializer {

    private static final List<Station> INITIAL_STATION = List.of(
            new Station("교대역"),
            new Station("강남역"),
            new Station("역삼역"),
            new Station("남부터미널역"),
            new Station("양재역"),
            new Station("양재시민의숲역"),
            new Station("매봉역")
    );

    private static final List<Line> INITIAL_LINE = List.of(
            new Line("2호선"),
            new Line("3호선"),
            new Line("신분당선")
    );

    private static final Set<Section> INITIAL_SECTION = Set.of(
            new Section(new Line("2호선"),
                    new ArrayList<>(List.of(new Station("교대역"), new Station("강남역"), new Station("역삼역")))),
            new Section(new Line("3호선"),
                    new ArrayList<>(List.of(new Station("교대역"), new Station("남부터미널역"), new Station("양재역"),
                            new Station("매봉역")))),
            new Section(new Line("신분당선"),
                    new ArrayList<>(List.of(new Station("강남역"), new Station("양재역"), new Station("양재시민의숲역"))))
    );

    public void init() {
        initStation();
        initLine();
        initSection();
    }

    private void initStation() {
        StationRepository.addStations(INITIAL_STATION);
    }

    private void initLine() {
        LineRepository.addLines(INITIAL_LINE);
    }

    private void initSection() {
        SectionRepository.addSections(INITIAL_SECTION);
    }
}
