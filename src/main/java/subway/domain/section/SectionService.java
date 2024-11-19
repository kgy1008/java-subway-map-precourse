package subway.domain.section;

import subway.domain.line.Line;
import subway.domain.line.LineRepository;
import subway.domain.station.Station;
import subway.domain.station.StationRepository;

public class SectionService {

    void add(final String lineName, final String stationName, final int sequence) {
        Line line = LineRepository.findByName(lineName);
        Station station = StationRepository.findByName(stationName);
        Section section = SectionRepository.findByLine(line);
        section.addStation(station, sequence);
    }
}
