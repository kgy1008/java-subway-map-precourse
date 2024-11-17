package subway.config;

import subway.controller.SubwayController;
import subway.view.InputView;
import subway.view.OutputView;

public class AppConfig {

    public SubwayController subwayController() {
        return new SubwayController(inputView(), outputView());
    }

    private InputView inputView() {
        return new InputView();
    }

    private OutputView outputView() {
        return new OutputView();
    }
}
