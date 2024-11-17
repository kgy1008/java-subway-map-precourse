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

public class StationController {

    private final StationService stationService;
    private final InputView inputView;
    private final OutputView outputView;

    public StationController(final StationService stationService, final InputView inputView,
                             final OutputView outputView) {
        this.stationService = stationService;
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
        String stationName = inputView.inputNewStationName();
        stationService.addStation(stationName);
        outputView.printInfoMessage(REGISTER_STATION.getMessage());
    }

    private void executeDelete() {
        String stationName = inputView.inputDeletedStationName();
        stationService.deleteStation(stationName);
        outputView.printInfoMessage(DELETE_STATION.getMessage());
    }

    private void executeDisplay() {
        outputView.printStations(stationService.findAllStations());
    }
}
