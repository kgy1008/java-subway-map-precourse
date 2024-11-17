package subway.service;

import static subway.common.ErrorMessage.CAN_NOT_DELETE;
import static subway.common.ErrorMessage.CONFLICT_ERROR;
import static subway.common.ErrorMessage.NO_STATION_FOUND;

import subway.domain.Line;
import subway.domain.Station;
import subway.repository.LineRepository;
import subway.repository.StationRepository;

public class SectionService {

    public void enrollSection(final String lineName, final String stationName, final int sequence) {
        Line line = findLineByName(lineName);
        Station station = findStationByName(stationName);
        validateEnroll(line, station);
        station.addLine(line);
        line.addStation(station, sequence);
    }

    public void deleteSection(final String lineName, final String stationName) {
        Line line = findLineByName(lineName);
        Station station = findStationByName(stationName);
        validateInput(line, station);
        checkCanDelete(line);
        line.removeStation(station);
        station.removeLine(line);
    }

    private Line findLineByName(final String lineName) {
        return LineRepository.findLineByName(lineName);
    }

    private Station findStationByName(final String stationName) {
        return StationRepository.findStationByName(stationName);
    }

    private void validateEnroll(final Line line, final Station station) {
        if (line.hasStation(station)) {
            throw new IllegalArgumentException(CONFLICT_ERROR.getMessage());
        }
    }

    private void validateInput(final Line line, final Station station) {
        if (!line.hasStation(station)) {
            throw new IllegalArgumentException(NO_STATION_FOUND.getMessage());
        }
    }

    private void checkCanDelete(final Line line) {
        if (line.hasLessThanTwoStation()) {
            throw new IllegalArgumentException(CAN_NOT_DELETE.getMessage());
        }
    }
}
