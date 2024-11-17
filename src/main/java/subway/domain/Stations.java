package subway.domain;

import static subway.common.ErrorMessage.CONFLICT_ERROR;

import java.util.ArrayList;
import java.util.List;
import subway.repository.StationRepository;

public class Stations {
    private static final List<Station> NO_STATION = new ArrayList<>();
    private final List<Station> stations;

    public Stations() {
        stations = NO_STATION;
    }

    int getSize() {
        return stations.size();
    }

    void registerStations(final String startStationName, final String endStationName) {
        Station startStation = findStation(startStationName);
        Station endStation = findStation(endStationName);
        validate(startStation, endStation);
        stations.addFirst(startStation);
        stations.addLast(endStation);
    }


    private Station findStation(final String stationName) {
        return StationRepository.findStationByName(stationName);
    }

    private void validate(final Station startStation, final Station endStation) {
        if (stations.contains(startStation) || stations.contains(endStation)) {
            throw new IllegalArgumentException(CONFLICT_ERROR.getMessage());
        }
    }
}
