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

    public void addStation(final String name) {
        Station station = new Station(name);
        StationRepository.addStation(station);
    }

    public void deleteStation(final String name) {
        checkDeleteStation(name);
        StationRepository.deleteStation(name);
    }

    private void checkDeleteStation(final String name) {
        Station station = StationRepository.findStationByName(name);
        if (station.isExistInLine()) {
            throw new IllegalArgumentException(CAN_NOT_DELETE.getMessage());
        }
    }
}
