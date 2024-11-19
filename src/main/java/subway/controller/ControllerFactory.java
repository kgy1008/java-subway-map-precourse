package subway.controller;

import subway.domain.line.LineController;
import subway.domain.line.LineService;
import subway.domain.response.MenuResponse;
import subway.domain.section.SectionController;
import subway.domain.section.SectionService;
import subway.domain.station.StationController;
import subway.domain.station.StationService;

public class ControllerFactory {

    public static SubwayController getController(final MenuResponse response) {
        if (response == MenuResponse.ONE) {
            return new StationController(new StationService());
        }
        if (response == MenuResponse.TWO) {
            return new LineController(new LineService());
        }
        if (response == MenuResponse.THREE) {
            return new SectionController(new SectionService());
        }
        return null;
    }
}
