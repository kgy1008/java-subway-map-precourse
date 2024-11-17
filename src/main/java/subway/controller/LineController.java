package subway.controller;

import static subway.common.InfoMessage.DELETE_LINE;
import static subway.common.InfoMessage.REGISTER_LINE;
import static subway.domain.user.ManagementResponse.ONE;
import static subway.domain.user.ManagementResponse.THREE;
import static subway.domain.user.ManagementResponse.TWO;

import subway.controller.util.RetryTemplate;
import subway.domain.user.ManagementResponse;
import subway.service.LineService;
import subway.view.InputView;
import subway.view.OutputView;

public class LineController implements Controller {

    private final LineService lineService;
    private final InputView inputView;
    private final OutputView outputView;
    private final RetryTemplate retryTemplate = new RetryTemplate();

    public LineController(final InputView inputView, final OutputView outputView) {
        this.lineService = new LineService();
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        retryTemplate.retryTemplate(() -> {
            outputView.printLineMenu();
            ManagementResponse managementResponse = inputView.inputManagement();
            if (managementResponse == ONE) {
                executeEnroll();
            }
            if (managementResponse == TWO) {
                executeDelete();
            }
            if (managementResponse == THREE) {
                executeDisplay();
            }
        });
    }

    private void executeEnroll() {
        String name = inputView.inputNewLineName();
        String startStationName = inputView.inputStartStationName();
        String endStationName = inputView.inputEndStationName();
        lineService.addLine(name, startStationName, endStationName);
        outputView.printInfoMessage(REGISTER_LINE.getMessage());

    }

    private void executeDelete() {
        String name = inputView.inputDeletedLINEName();
        lineService.deleteLine(name);
        outputView.printInfoMessage(DELETE_LINE.getMessage());

    }

    private void executeDisplay() {
        outputView.printLines(lineService.findAllLines());
    }
}
