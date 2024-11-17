package subway.view;

import java.util.Scanner;
import subway.domain.MainMenuResponse;
import subway.domain.ManagementResponse;

public class InputView {
    private static final String FEATURE_MESSAGE = "## 원하는 기능을 선택하세요.";

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
}
