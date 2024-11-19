package subway.view;

import java.util.Scanner;
import subway.domain.response.ManageResponse;
import subway.domain.response.MenuResponse;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);
    private static final String NEW_LINE = System.lineSeparator();
    private static final String MENU_INPUT_MESSAGE = "## 원하는 기능을 선택하세요.";
    private static final String STATION_NAME_INPUT_MESSAGE = "## 등록할 역 이름을 입력하세요.";
    private static final String DELETED_STATION_NAME_INPUT_MESSAGE = "## 삭제할 역 이름을 입력하세요.";
    private static final String DELETED_LINE_NAME_INPUT_MESSAGE = "## 삭제할 노선 이름을 입력하세요.";
    private static final String LINE_NAME_INPUT_MESSAGE = "## 등록할 노선 이름을 입력하세요.";
    private static final String START_STATION_NAME_INPUT_MESSAGE = "## 등록할 노선의 상행 종점역 이름을 입력하세요.";
    private static final String END_STATION_NAME_INPUT_MESSAGE = "## 등록할 노선의 하행 종점역 이름을 입력하세요.";

    public MenuResponse inputMainMenuFeature() {
        System.out.println(MENU_INPUT_MESSAGE);
        String input = scanner.nextLine();
        return MenuResponse.of(input);
    }

    public ManageResponse inputManageFeature() {
        System.out.println(MENU_INPUT_MESSAGE);
        String input = scanner.nextLine();
        return ManageResponse.of(input);
    }

    public String inputStationName() {
        System.out.println(NEW_LINE + STATION_NAME_INPUT_MESSAGE);
        return scanner.nextLine();
    }

    public String inputDeletedStationName() {
        System.out.println(NEW_LINE + DELETED_STATION_NAME_INPUT_MESSAGE);
        return scanner.nextLine();
    }

    public String inputDeletedLineName() {
        System.out.println(NEW_LINE + DELETED_LINE_NAME_INPUT_MESSAGE);
        return scanner.nextLine();
    }

    public String inputLineName() {
        System.out.println(NEW_LINE + LINE_NAME_INPUT_MESSAGE);
        return scanner.nextLine();
    }

    public String inputStartStationName() {
        System.out.println(NEW_LINE + START_STATION_NAME_INPUT_MESSAGE);
        return scanner.nextLine();
    }

    public String inputEndStationName() {
        System.out.println(NEW_LINE + END_STATION_NAME_INPUT_MESSAGE);
        return scanner.nextLine();
    }
}
