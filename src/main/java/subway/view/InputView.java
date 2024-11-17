package subway.view;

import static subway.common.ErrorMessage.INVALID_INPUT;
import static subway.common.ErrorMessage.INVALID_RANGE;

import java.util.Scanner;
import subway.domain.user.MainMenuResponse;
import subway.domain.user.ManagementResponse;

public class InputView {
    private static final String FEATURE_MESSAGE = "## 원하는 기능을 선택하세요.";
    private static final String ENROLL_STATION_MESSAGE = "## 등록할 역 이름을 입력하세요.";
    private static final String DELETE_STATION_MESSAGE = "## 삭제할 역 이름을 입력하세요.";
    private static final String DELETE_LINE_MESSAGE = "## 삭제할 노선 이름을 입력하세요.";
    private static final String ENROLL_LINE_MESSAGE = "## 등록할 노선 이름을 입력하세요.";
    private static final String START_STATION_MESSAGE = "## 등록할 노선의 상행 종점역 이름을 입력하세요.";
    private static final String END_STATION_MESSAGE = "## 등록할 노선의 하행 종점역 이름을 입력하세요.";
    private static final String SEQUENCE_INPUT_MESSAGE = "## 순서를 입력하세요.";
    private static final int MIN_VALUE = 1;

    private final Scanner scanner = new Scanner(System.in);

    public MainMenuResponse inputFeature() {
        System.out.println(FEATURE_MESSAGE);
        String input = scanner.nextLine();
        return MainMenuResponse.from(input);
    }

    public ManagementResponse inputManagement() {
        System.out.println(FEATURE_MESSAGE);
        String input = scanner.nextLine();
        return ManagementResponse.from(input);
    }

    public String inputNewStationName() {
        System.out.println(ENROLL_STATION_MESSAGE);
        return scanner.nextLine();
    }

    public String inputDeletedStationName() {
        System.out.println(DELETE_STATION_MESSAGE);
        return scanner.nextLine();
    }

    public String inputDeletedLINEName() {
        System.out.println(DELETE_LINE_MESSAGE);
        return scanner.nextLine();
    }

    public String inputNewLineName() {
        System.out.println(ENROLL_LINE_MESSAGE);
        return scanner.nextLine();
    }

    public String inputStartStationName() {
        System.out.println(START_STATION_MESSAGE);
        return scanner.nextLine();
    }

    public String inputEndStationName() {
        System.out.println(END_STATION_MESSAGE);
        return scanner.nextLine();
    }

    public int inputSequence() {
        System.out.println(SEQUENCE_INPUT_MESSAGE);
        String input = scanner.nextLine();
        int sequence = convertToInt(input);
        validate(sequence);
        return sequence;
    }

    private int convertToInt(final String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_INPUT.getMessage());
        }
    }

    private void validate(final int sequence) {
        if (sequence < MIN_VALUE) {
            throw new IllegalArgumentException(INVALID_RANGE.getMessage());
        }
    }
}
