package subway.view;

import static subway.view.MenuTemplate.MAIN_MENU;
import static subway.view.MenuTemplate.STATION_MENU;

public class OutputView {
    private static final String NEW_LINE = System.lineSeparator();

    public void printMainMenu() {
        System.out.println(MAIN_MENU);
        System.out.print(NEW_LINE);
    }

    public void printStationMenu() {
        System.out.println(STATION_MENU);
    }

    public void printMessage(final String message) {
        System.out.print(NEW_LINE);
        System.out.println(message);
        System.out.print(NEW_LINE);
    }
}
