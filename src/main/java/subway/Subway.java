package subway;

import subway.config.Initializer;
import subway.controller.ControllerFactory;
import subway.controller.SubwayController;
import subway.domain.response.MenuResponse;
import subway.util.RetryTemplate;
import subway.view.InputView;
import subway.view.OutputView;

public class Subway {

    private final InputView inputView;
    private final OutputView outputView;
    private boolean isRunning;

    public Subway(final InputView inputView, final OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
        isRunning = true;
    }

    public void run() {
        SubwayController controller;
        init();
        while (isRunning) {
            MenuResponse menuResponse = displayMainMenuAndGetResponse();
            if (menuResponse == MenuResponse.QUIT) {
                isRunning = false;
                break;
            }
            controller = ControllerFactory.getController(menuResponse);
            controller.run();
        }
    }

    private void init() {
        Initializer initializer = new Initializer();
        initializer.init();
    }

    private MenuResponse displayMainMenuAndGetResponse() {
        outputView.printMainMenu();
        return RetryTemplate.retryTemplate(inputView::inputMainMenuFeature);
    }
}
