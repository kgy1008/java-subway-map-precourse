package subway.domain.line;

import java.util.List;
import subway.common.InfoMessage;
import subway.domain.response.ManageResponse;
import subway.domain.station.Station;
import subway.dto.StationInfo;
import subway.util.RetryTemplate;
import subway.view.InputView;
import subway.view.OutputView;

public class LineController {

    private final OutputView outputView;
    private final InputView inputView;
    private final LineService lineService;

    public LineController(final OutputView outputView, final InputView inputView, final LineService lineService) {
        this.outputView = outputView;
        this.inputView = inputView;
        this.lineService = lineService;
    }

    public void run() {
        RetryTemplate.retryTemplate(() -> {
            displayMenu();
            ManageResponse response = getUserInput();
            execute(response);
        });
    }

    private void displayMenu() {
        outputView.printLineMenu();
    }

    private ManageResponse getUserInput() {
        return RetryTemplate.retryTemplate(inputView::inputManageFeature);
    }

    private void execute(ManageResponse response) {
        if (response == ManageResponse.ONE) {
            enrollLine();
        }
        if (response == ManageResponse.TWO) {
            deleteLine();
        }
        if (response == ManageResponse.THREE) {
            displayLines();
        }
    }

    private void enrollLine() {
        String name = inputView.inputStationName();
        lineService.add(name);
        outputView.printMessage(InfoMessage.CREATE_STATION.getMessage());
    }

    private void deleteLine() {
        String name = inputView.inputDeletedStationName();
        lineService.delete(name);
        outputView.printMessage(InfoMessage.DELETE_STATION.getMessage());
    }

    private void displayLines() {
        List<Station> stations = lineService.findAll();
        outputView.printStations(StationInfo.of(stations));
    }
}
