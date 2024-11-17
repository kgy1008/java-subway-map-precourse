package subway.service;

import static subway.common.ErrorMessage.CAN_NOT_DELETE;

import subway.config.Initializer;
import subway.domain.Station;
import subway.repository.StationRepository;

public class SubwayService {

    public SubwayService() {
        init();
    }

    public void init() {
        Initializer initializer = new Initializer();
        initializer.init();
    }

    public void deleteStation(final String stationName) {
        checkDeleteStation(stationName);
        StationRepository.deleteStation(stationName);
    }

    private void checkDeleteStation(final String stationName) {
        Station station = StationRepository.findStationByName(stationName);
        if (station.isExistInLine()) {
            throw new IllegalArgumentException(CAN_NOT_DELETE.getMessage());
        }
    }
}
