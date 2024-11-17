package subway.controller;

import java.util.List;
import subway.controller.util.RetryTemplate;
import subway.domain.Line;
import subway.domain.Stations;
import subway.domain.user.MainMenuResponse;
import subway.dto.SubwayResponse;
import subway.repository.LineRepository;
import subway.view.InputView;
import subway.view.OutputView;

public class SubwayController {

    private final InputView inputView;
    private final OutputView outputView;
    private Controller controller;
    private final RetryTemplate retryTemplate = new RetryTemplate();

    public SubwayController(final InputView inputView, final OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        while (true) {
            outputView.printMainMenu();
            MainMenuResponse mainMenuResponse = retryTemplate.retryTemplate(inputView::inputFeature);
            if (mainMenuResponse == MainMenuResponse.ONE) {
                Controller stationController = new StationController(inputView, outputView);
                stationController.run();
            }
            if (mainMenuResponse == MainMenuResponse.TWO) {
                Controller lineController = new LineController(inputView, outputView);
                lineController.run();
            }
            if (mainMenuResponse == MainMenuResponse.THREE) {
                Controller sectionController = new SectionController(inputView, outputView);
                sectionController.run();
            }
            if (mainMenuResponse == MainMenuResponse.FOUR) {
                displaySubwayMap();
            }
            if (mainMenuResponse == MainMenuResponse.EXIT) {
                break;
            }
        }
    }

    private void displaySubwayMap() {
        List<Line> lines = LineRepository.lines();
        for (Line line : lines) {
            Stations stations = line.getStations();
            SubwayResponse subwayResponse = SubwayResponse.of(line, stations);
            outputView.printSubway(subwayResponse);
        }
    }
}
