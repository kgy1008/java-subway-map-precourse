package subway.controller;

import subway.view.InputView;
import subway.view.OutputView;

public class SubwayController {

    private final InputView inputView;
    private final OutputView outputView;

    public SubwayController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        displayMainMenu();
    }

    private void displayMainMenu() {
        outputView.printMainMenu();
    }
}
