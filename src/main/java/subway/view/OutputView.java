package subway.view;

import subway.dto.LineResponse;
import subway.dto.StationResponse;
import subway.dto.SubwayResponse;

public class OutputView {
    private static final String NEW_LINE = System.lineSeparator();
    private static final String MAIN_MENU = "## 메인 화면" + NEW_LINE
            + "1. 역 관리" + NEW_LINE
            + "2. 노선 관리" + NEW_LINE
            + "3. 구간 관리" + NEW_LINE
            + "4. 지하철 노선도 출력" + NEW_LINE
            + "Q. 종료";
    private static final String STATION_MENU = "## 역 관리 화면" + NEW_LINE
            + "1. 역 등록" + NEW_LINE
            + "2. 역 삭제" + NEW_LINE
            + "3. 역 조회" + NEW_LINE
            + "B. 돌아가기";
    private static final String LINE_MENU = "## 노선 관리 화면" + NEW_LINE
            + "1. 노선 등록" + NEW_LINE
            + "2. 노선 삭제" + NEW_LINE
            + "3. 노선 조회" + NEW_LINE
            + "B. 돌아가기" + NEW_LINE;
    private static final String SECTION_MENU = "## 구간 관리 화면" + NEW_LINE
            + "1. 구간 등록" + NEW_LINE
            + "2. 구간 삭제" + NEW_LINE
            + "B. 돌아가기" + NEW_LINE;
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
}
