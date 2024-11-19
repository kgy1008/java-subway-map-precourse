package subway.domain.station;

public class StationService {

    void add(final String name) {
        Station station = new Station(name);
        StationRepository.addStation(station);
    }
}
