package subway.controller;

import subway.view.InputView;
import subway.view.OutputView;

public class SubwayController {
    protected final OutputView outputView;
    protected final InputView inputView;

    public SubwayController() {
        this.outputView = new OutputView();
        this.inputView = new InputView();
    }

    public void run() {

    }
}

