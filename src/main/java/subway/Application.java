package subway;

import subway.view.InputView;
import subway.view.OutputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        Subway subway = new Subway(inputView, outputView);
        subway.run();
    }
}
