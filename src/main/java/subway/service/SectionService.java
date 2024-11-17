package subway.service;

import static subway.common.ErrorMessage.CONFLICT_ERROR;

import subway.domain.Line;
import subway.domain.Station;
import subway.repository.LineRepository;
import subway.repository.StationRepository;

public class SectionService {

    public void enrollSection(final String lineName, final String stationName, final int sequence) {
        Line line = findLineByName(lineName);
        Station station = findStationByName(stationName);
        validate(line, station);
        station.addLine(line);
        line.addStation(station, sequence);
    }

    private Line findLineByName(final String lineName) {
        return LineRepository.findLineByName(lineName);
    }

    private Station findStationByName(final String stationName) {
        return StationRepository.findStationByName(stationName);
    }

    private void validate(final Line line, final Station station) {
        if (line.hasStation(station)) {
            throw new IllegalArgumentException(CONFLICT_ERROR.getMessage());
        }
    }
}
