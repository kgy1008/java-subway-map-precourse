package subway.config;

import java.util.List;
import subway.domain.Line;
import subway.domain.Station;
import subway.repository.LineRepository;
import subway.repository.StationRepository;

public class Initializer {

    private static final List<Line> INITIAL_LINES = List.of(
            new Line("2호선"),
            new Line("3호선"),
            new Line("신분당선")
    );
    private static final List<Station> INITIAL_STATIONS = List.of(
            new Station("교대역"),
            new Station("강남역"),
            new Station("역삼역"),
            new Station("남부터미널역"),
            new Station("양재역"),
            new Station("매봉역"),
            new Station("양재시민의숲역")
    );

    public void init() {
        initStation();
        initLine();
    }

    private void initStation() {
        StationRepository.addStations(INITIAL_STATIONS);
    }

    private void initLine() {
        LineRepository.addLines(INITIAL_LINES);
    }
}
