package subway.domain.line;

import java.util.List;
import subway.common.InfoMessage;
import subway.controller.SubwayController;
import subway.domain.response.ManageResponse;
import subway.dto.LineInfo;
import subway.util.RetryTemplate;
import subway.view.InputView;
import subway.view.OutputView;

public class LineController extends SubwayController {

    private final LineService lineService;

    public LineController(final OutputView outputView, final InputView inputView,
                          final LineService lineService) {
        super(outputView, inputView);
        this.lineService = lineService;
    }

    @Override
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
        String name = inputView.inputLineName();
        String startStationName = inputView.inputStartStationName();
        String endStationName = inputView.inputEndStationName();
        lineService.add(name, startStationName, endStationName);
        outputView.printMessage(InfoMessage.CREATE_LINE.getMessage());
    }

    private void deleteLine() {
        String name = inputView.inputDeletedLineName();
        lineService.delete(name);
        outputView.printMessage(InfoMessage.DELETE_LINE.getMessage());
    }

    private void displayLines() {
        List<Line> lines = lineService.findAll();
        outputView.printLines(LineInfo.of(lines));
    }
}
