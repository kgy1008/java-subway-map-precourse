package subway.controller;

import subway.view.InputView;
import subway.view.OutputView;

public class SubwayController {
    protected final OutputView outputView;
    protected final InputView inputView;

    public SubwayController(final OutputView outputView, final InputView inputView) {
        this.outputView = outputView;
        this.inputView = inputView;
    }

    public void run() {

    }
}

