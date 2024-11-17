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
        initSectionOfStation();
        initSectionOfLine();
    }

    private void initStation() {
        StationRepository.addStations(INITIAL_STATIONS);
    }

    private void initLine() {
        LineRepository.addLines(INITIAL_LINES);
    }

    private void initSectionOfStation() {
        for (Station station : INITIAL_STATIONS) {
            if (station.getName().equals("교대역") || station.getName().equals("강남역") || station.getName().equals("역삼역")) {
                station.addLine(findLineByName("2호선"));
                continue;
            }
            if (station.getName().equals("강남역") || station.getName().equals("양재역") || station.getName()
                    .equals("양재시민의숲역")) {
                station.addLine(findLineByName("신분당선"));
                continue;
            }
            station.addLine(findLineByName("3호선"));
        }
    }

    private void initSectionOfLine() {
        for (Line line : INITIAL_LINES) {
            if (line.getName().equals("2호선")) {
                line.addStation(findStationByName("교대역"), 0);
                line.addStation(findStationByName("강남역"), 1);
                line.addStation(findStationByName("역삼역"), 2);
                continue;
            }
            if (line.getName().equals("3호선")) {
                line.addStation(findStationByName("교대역"), 0);
                line.addStation(findStationByName("남부터미널역"), 1);
                line.addStation(findStationByName("양재역"), 2);
                line.addStation(findStationByName("매봉역"), 3);
                continue;
            }
            line.addStation(findStationByName("강남역"), 0);
            line.addStation(findStationByName("양재역"), 1);
            line.addStation(findStationByName("양재시민의숲역"), 2);
        }
    }

    private Line findLineByName(final String name) {
        return LineRepository.findLineByName(name);
    }

    private Station findStationByName(final String name) {
        return StationRepository.findStationByName(name);
    }
}
