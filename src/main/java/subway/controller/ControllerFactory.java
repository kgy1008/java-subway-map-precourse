package subway.controller;

import subway.domain.line.LineController;
import subway.domain.line.LineService;
import subway.domain.response.MenuResponse;
import subway.domain.section.SectionController;
import subway.domain.section.SectionService;
import subway.domain.station.StationController;
import subway.domain.station.StationService;
import subway.view.InputView;
import subway.view.OutputView;

public class ControllerFactory {

    private ControllerFactory() {
    }

    public static SubwayController getController(final MenuResponse response, final InputView inputView,
                                                 final OutputView outputView) {
        if (response == MenuResponse.ONE) {
            return new StationController(outputView, inputView, new StationService());
        }
        if (response == MenuResponse.TWO) {
            return new LineController(outputView, inputView, new LineService());
        }
        if (response == MenuResponse.THREE) {
            return new SectionController(outputView, inputView, new SectionService());
        }
        return new SubwayController(outputView, inputView);
    }
}
