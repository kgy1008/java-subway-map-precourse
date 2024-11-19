package subway.domain.station;

import subway.common.InfoMessage;
import subway.domain.response.ManageResponse;
import subway.util.RetryTemplate;
import subway.view.InputView;
import subway.view.OutputView;

public class StationController {
    private final OutputView outputView;
    private final InputView inputView;
    private final StationService stationService;

    public StationController(final OutputView outputView, final InputView inputView,
                             final StationService stationService) {
        this.outputView = outputView;
        this.inputView = inputView;
        this.stationService = stationService;
    }

    public void run() {
        RetryTemplate.retryTemplate(() -> {
            displayMenu();
            ManageResponse response = getUserInput();
            execute(response);
        });
    }

    private void displayMenu() {
        outputView.printStationMenu();
    }

    private ManageResponse getUserInput() {
        return RetryTemplate.retryTemplate(inputView::inputStationManageFeature);
    }

    private void execute(ManageResponse response) {
        if (response == ManageResponse.ONE) {
            enrollStation();
        }
    }

    private void enrollStation() {
        String name = inputView.inputStationName();
        stationService.add(name);
        outputView.printMessage(InfoMessage.CREATE_STATION.getMessage());
    }
}
