package subway.domain.station;

import subway.common.ErrorMessage;
import subway.domain.section.SectionRepository;

public class StationService {

    void add(final String name) {
        Station station = new Station(name);
        StationRepository.addStation(station);
    }

    void delete(final String name) {
        Station station = StationRepository.findByName(name);
        checkCanDelete(station);
        StationRepository.deleteStation(station);
    }

    private void checkCanDelete(final Station station) {
        if (SectionRepository.isExistStation(station)) {
            throw new IllegalArgumentException(ErrorMessage.UNAUTHORIZED_DELETE.getMessage());
        }
    }
}
