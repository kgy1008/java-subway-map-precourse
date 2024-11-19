package subway.domain.line;

import java.util.List;
import subway.common.ErrorMessage;
import subway.domain.section.Section;
import subway.domain.section.SectionRepository;
import subway.domain.station.Station;
import subway.domain.station.StationRepository;

public class LineService {

    void add(final String name, final String startStationName, final String endStationName) {
        Line line = new Line(name);
        LineRepository.addLine(line);
        Station startStation = StationRepository.findByName(startStationName);
        Station endStation = StationRepository.findByName(endStationName);
        List<Station> stations = List.of(startStation, endStation);
        Section section = new Section(line, stations);
        SectionRepository.addSection(section);
    }

    void delete(final String name) {
        Line line = LineRepository.findByName(name);
        checkCanDelete(line);
        LineRepository.deleteLine(line);
    }

    private void checkCanDelete(final Line line) {
        if (SectionRepository.isExistLine(line)) {
            throw new IllegalArgumentException(ErrorMessage.UNAUTHORIZED_DELETE_LINE.getMessage());
        }
    }

    List<Line> findAll() {
        return LineRepository.lines();
    }
}
