package subway.view;

import static subway.view.MenuTemplate.MAIN_MENU;
import static subway.view.MenuTemplate.STATION_MENU;

import subway.dto.StationInfo;

public class OutputView {
    private static final String NEW_LINE = System.lineSeparator();
    private static final String STATION_DISPLAY_MESSAGE = "## 역 목록";
    private static final String INFO_HEADER = "[INFO] ";

    public void printMainMenu() {
        System.out.println(MAIN_MENU);
        System.out.print(NEW_LINE);
    }

    public void printStationMenu() {
        System.out.println(STATION_MENU);
    }

    public void printMessage(final String message) {
        System.out.println(NEW_LINE + message);
        System.out.print(NEW_LINE);
    }

    public void printStations(final StationInfo stationInfo) {
        System.out.println(NEW_LINE + STATION_DISPLAY_MESSAGE);
        stationInfo.stationNames().forEach(station -> System.out.println(INFO_HEADER + station));
        System.out.print(NEW_LINE);
    }
}
