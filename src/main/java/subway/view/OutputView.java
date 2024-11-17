package subway.view;

import static subway.view.Menu.LINE_MENU;
import static subway.view.Menu.MAIN_MENU;
import static subway.view.Menu.SECTION_MENU;
import static subway.view.Menu.STATION_MENU;

import subway.dto.LineResponse;
import subway.dto.StationResponse;
import subway.dto.SubwayResponse;

public class OutputView {
    private static final String NEW_LINE = System.lineSeparator();
    private static final String STATION_MESSAGE = "## 역 목록";
    private static final String LINE_MESSAGE = "## 노선 목록";
    private static final String SUBWAY_MESSAGE = "## 지하철 노선도";
    private static final String DELIMITER = "---";
    private static final String INFO = "[INFO] ";

    public void printMainMenu() {
        System.out.println(MAIN_MENU);
    }

    public void printStationMenu() {
        System.out.println(STATION_MENU);
    }

    public void printLineMenu() {
        System.out.println(LINE_MENU);
    }

    public void printSectionMenu() {
        System.out.println(SECTION_MENU);
    }

    public void printStations(final StationResponse stationResponse) {
        System.out.println(STATION_MESSAGE);
        stationResponse.stations().forEach(station -> System.out.println(INFO + station));
        System.out.print(NEW_LINE);
    }

    public void printInfoMessage(final String message) {
        System.out.println(message);
    }

    public void printLines(final LineResponse lineResponse) {
        System.out.println(LINE_MESSAGE);
        lineResponse.lines().forEach(line -> System.out.println(INFO + line));
        System.out.print(NEW_LINE);
    }

    public void printSubway(final SubwayResponse subwayResponse) {
        System.out.println(SUBWAY_MESSAGE);
        System.out.println(INFO + subwayResponse.line());
        System.out.println(INFO + DELIMITER);
        subwayResponse.stations().forEach(station -> System.out.println(INFO + station));
        System.out.print(NEW_LINE);
    }

    public void printErrorMessage(final String message) {
        System.out.println(message);
    }
}
