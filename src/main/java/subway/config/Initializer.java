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
            new Station("양재시민의숲역"),
            new Station("매봉역")
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

    private void initSection() {
        for (Station station : INITIAL_STATIONS) {
            if (station.getName().equals("교대역") || station.getName().equals("강남역") || station.getName().equals("역삼역")) {
                station.addLine(findByName("2호선"));
                continue;
            }
            if (station.getName().equals("강남역") || station.getName().equals("양재역") || station.getName()
                    .equals("양재시민의숲역")) {
                station.addLine(findByName("신분당선"));
                continue;
            }
            station.addLine(findByName("3호선"));
        }
    }

    private Line findByName(final String name) {
        return LineRepository.findLineByName(name);
    }
}
