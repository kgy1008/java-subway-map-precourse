package subway.view;

public class OutputView {
    private static final String MAIN_MENU = "## 메인 화면";
    private static final String STATION_MANAGEMENT = "1. 역 관리";
    private static final String LINE_MANAGEMENT = "2. 노선 관리";
    private static final String SECTION_MANAGEMENT = "3. 구간 관리";
    private static final String DISPLAY_ROUTE = "4. 지하철 노선도 출력";
    private static final String EXIT = "Q. 종료";

    public void printMainMenu() {
        System.out.println(MAIN_MENU);
        System.out.println(STATION_MANAGEMENT);
        System.out.println(LINE_MANAGEMENT);
        System.out.println(SECTION_MANAGEMENT);
        System.out.println(DISPLAY_ROUTE);
        System.out.println(EXIT);
    }
}
