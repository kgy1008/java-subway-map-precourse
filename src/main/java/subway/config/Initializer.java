package subway.config;

import java.util.List;
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
    private static final List<Section> INITIAL_SECTION = List.of(
            new Section(new Line("2호선"), List.of(new Station("교대역"), new Station("강남역"), new Station("역삼역"))),
            new Section(new Line("3호선"),
                    List.of(new Station("교대역"), new Station("남부터미널역"), new Station("양재역"), new Station("매봉역"))),
            new Section(new Line("신분당선"), List.of(new Station("강남역"), new Station("양재역"), new Station("양재시민의숲역")))
    );

    public static void init() {
        initStation();
        initLine();
        initSection();
    }

    private static void initStation() {
        StationRepository.addStations(INITIAL_STATION);
    }

    private static void initLine() {
        LineRepository.addLines(INITIAL_LINE);
    }

    private static void initSection() {
        SectionRepository.addSections(INITIAL_SECTION);
    }
}