package subway.controller;

import static subway.common.InfoMessage.DELETE_STATION;
import static subway.common.InfoMessage.REGISTER_STATION;
import static subway.domain.user.ManagementResponse.ONE;
import static subway.domain.user.ManagementResponse.THREE;
import static subway.domain.user.ManagementResponse.TWO;

import subway.domain.user.ManagementResponse;
import subway.service.StationService;
import subway.view.InputView;
import subway.view.OutputView;

public class StationController implements Controller {

    private final StationService stationService;
    private final InputView inputView;
    private final OutputView outputView;

    public StationController(final InputView inputView,
                             final OutputView outputView) {
        this.stationService = new StationService();
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
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
    }

    private void executeEnroll() {
        String name = inputView.inputNewStationName();
        stationService.addStation(name);
        outputView.printInfoMessage(REGISTER_STATION.getMessage());
    }

    private void executeDelete() {
        String name = inputView.inputDeletedStationName();
        stationService.deleteStation(name);
        outputView.printInfoMessage(DELETE_STATION.getMessage());
    }

    private void executeDisplay() {
        outputView.printStations(stationService.findAllStations());
    }
}
