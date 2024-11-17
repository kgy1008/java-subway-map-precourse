package subway;

import subway.config.AppConfig;
import subway.config.Initializer;
import subway.controller.SubwayController;

public class Application {
    public static void main(String[] args) {
        final Initializer initializer = new Initializer();
        initializer.init();
        AppConfig appConfig = new AppConfig();
        final SubwayController subwayController = appConfig.subwayController();
        subwayController.run();
    }
}
