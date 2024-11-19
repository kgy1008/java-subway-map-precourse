package subway.domain.section;

import subway.common.ErrorMessage;
import subway.common.InfoMessage;
import subway.domain.response.ManageResponse;
import subway.util.RetryTemplate;
import subway.view.InputView;
import subway.view.OutputView;

public class SectionController {

    private final OutputView outputView;
    private final InputView inputView;
    private final SectionService sectionService;

    public SectionController(final OutputView outputView, final InputView inputView,
                             final SectionService sectionService) {
        this.outputView = outputView;
        this.inputView = inputView;
        this.sectionService = sectionService;
    }

    public void run() {
        RetryTemplate.retryTemplate(() -> {
            displayMenu();
            ManageResponse response = getUserInput();
            execute(response);
        });
    }

    private void displayMenu() {
        outputView.printSectionMenu();
    }

    private ManageResponse getUserInput() {
        return RetryTemplate.retryTemplate(inputView::inputManageFeature);
    }

    private void execute(ManageResponse response) {
        if (response == ManageResponse.ONE) {
            enrollSection();
            return;
        }
        if (response == ManageResponse.TWO) {
            deleteSection();
            return;
        }
        if (response == ManageResponse.BACK) {
            return;
        }
        throw new IllegalArgumentException(ErrorMessage.INVALID_INPUT.getMessage());
    }

    private void enrollSection() {
        String lineName = inputView.inputSectionLine();
        String stationName = inputView.inputSectionStation();
        int sequence = RetryTemplate.retryTemplate(inputView::inputSectionSequence);
        sectionService.add(lineName, stationName, sequence);
        outputView.printMessage(InfoMessage.CREATE_SECTION.getMessage());
    }

    private void deleteSection() {
        String lineName = inputView.inputDeletedSectionLineName();
        String stationName = inputView.inputDeletedSectionStationName();
        sectionService.delete(lineName, stationName);
        outputView.printMessage(InfoMessage.DELETE_LINE.getMessage());
    }
}
