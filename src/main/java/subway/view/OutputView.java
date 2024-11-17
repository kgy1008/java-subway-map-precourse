package subway.view;

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
    private static final String INFO = "[INFO] ";

    public void printMainMenu() {
        System.out.println(MAIN_MENU);
    }

    public void printStationMenu() {
        System.out.println(STATION_MENU);
    }
}
