package subway.controller;

import static subway.common.InfoMessage.DELETE_SECTION;
import static subway.common.InfoMessage.REGISTER_SECTION;
import static subway.domain.user.ManagementResponse.ONE;
import static subway.domain.user.ManagementResponse.TWO;

import subway.controller.util.RetryTemplate;
import subway.domain.user.ManagementResponse;
import subway.service.SectionService;
import subway.view.InputView;
import subway.view.OutputView;

public class SectionController implements Controller {

    private final SectionService sectionService;
    private final InputView inputView;
    private final OutputView outputView;
    private final RetryTemplate retryTemplate = new RetryTemplate();

    public SectionController(final InputView inputView, final OutputView outputView) {
        this.sectionService = new SectionService();
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        outputView.printSectionMenu();
        ManagementResponse managementResponse = retryTemplate.retryTemplate(inputView::inputManagement);

        if (managementResponse == ONE) {
            executeEnroll();
        }
        if (managementResponse == TWO) {
            executeDelete();
        }
    }

    private void executeEnroll() {
        retryTemplate.retryTemplate(() -> {
            String lineName = inputView.inputNewSectionLine();
            String stationName = inputView.inputNewSectionStation();
            int sequence = inputView.inputSequence();
            sectionService.enrollSection(lineName, stationName, sequence);
            outputView.printInfoMessage(REGISTER_SECTION.getMessage());
        });
    }

    private void executeDelete() {
        retryTemplate.retryTemplate(() -> {
            String lineName = inputView.inputDeletedSectionLine();
            String stationName = inputView.inputDeletedSectionStation();
            sectionService.deleteSection(lineName, stationName);
            outputView.printInfoMessage(DELETE_SECTION.getMessage());
        });
    }
}
