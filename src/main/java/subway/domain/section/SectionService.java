package subway.domain.section;

import subway.common.ErrorMessage;
import subway.domain.line.Line;
import subway.domain.line.LineRepository;
import subway.domain.station.Station;
import subway.domain.station.StationRepository;

public class SectionService {

    private static final int MIN_STATION_COUNT_IN_LINE = 2;

    void add(final String lineName, final String stationName, final int sequence) {
        Line line = LineRepository.findByName(lineName);
        Station station = StationRepository.findByName(stationName);
        Section section = SectionRepository.findByLine(line);
        section.addStation(station, sequence);
    }

    void delete(final String lineName, final String stationName) {
        Line line = LineRepository.findByName(lineName);
        Station station = StationRepository.findByName(stationName);
        Section section = SectionRepository.findByLine(line);
        checkCanDelete(section);
        section.deleteStation(station);
    }

    private void checkCanDelete(Section section) {
        if (section.getStationCount() <= MIN_STATION_COUNT_IN_LINE) {
            throw new IllegalArgumentException(ErrorMessage.UNAUTHORIZED_DELETE_SECTION.getMessage());
        }
    }
}
