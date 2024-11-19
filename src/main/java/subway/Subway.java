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

    public Subway(final InputView inputView, final OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        init();
        while (true) {
            MenuResponse menuResponse = displayMainMenuAndGetResponse();
            if (menuResponse == MenuResponse.QUIT) {
                break;
            }
            final SubwayController controller = ControllerFactory.getController(menuResponse, inputView, outputView);
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