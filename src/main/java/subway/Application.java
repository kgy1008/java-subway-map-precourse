package subway;

import subway.config.AppConfig;
import subway.controller.SubwayController;

public class Application {
    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();
        SubwayController subwayController = appConfig.subwayController();
        subwayController.run();
    }
}
