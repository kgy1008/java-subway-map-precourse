package subway.controller.util;

import java.util.function.Supplier;
import subway.view.OutputView;

public class RetryTemplate {

    private final OutputView outputView = new OutputView();

    public <T> T retryTemplate(final Supplier<T> action) {
        while (true) {
            try {
                return action.get();
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e.getMessage());
            }
        }
    }

    public void retryTemplate(final Runnable action) {
        while (true) {
            try {
                action.run();
                break;
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e.getMessage());
            }
        }
    }
}
