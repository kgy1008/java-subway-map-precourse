package subway.config;

import subway.controller.SubwayController;
import subway.view.InputView;
import subway.view.OutputView;

public class AppConfig {

    public SubwayController subwayController() {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        return new SubwayController(inputView, outputView);
    }
}
