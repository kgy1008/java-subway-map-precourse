package subway.service;

import static subway.common.ErrorMessage.CAN_NOT_DELETE;

import java.util.List;
import subway.domain.Station;
import subway.dto.StationResponse;
import subway.repository.StationRepository;

public class StationService {

    public void addStation(final String name) {
        Station station = new Station(name);
        StationRepository.addStation(station);
    }

    public void deleteStation(final String name) {
        checkDeleteStation(name);
        StationRepository.deleteStation(name);
    }

    public StationResponse findAllStations() {
        List<String> stations = StationRepository.stations().stream()
                .map(Station::getName)
                .toList();
        return new StationResponse(stations);
    }

    private void checkDeleteStation(final String name) {
        Station station = StationRepository.findStationByName(name);
        if (station.isExistInLine()) {
            throw new IllegalArgumentException(CAN_NOT_DELETE.getMessage());
        }
    }
}
