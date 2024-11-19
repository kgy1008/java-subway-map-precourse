package subway.controller;

import java.util.List;
import subway.domain.line.LineRepository;
import subway.domain.section.Section;
import subway.domain.section.SectionRepository;
import subway.dto.SubwayInfo;
import subway.dto.SubwayRoute;
import subway.view.InputView;
import subway.view.OutputView;

public class SubwayController {
    protected final OutputView outputView;
    protected final InputView inputView;

    public SubwayController(final OutputView outputView, final InputView inputView) {
        this.outputView = outputView;
        this.inputView = inputView;
    }

    public void run() {
        SubwayRoute subwayRoute = getSubwayInfo();
        outputView.printSubway(subwayRoute);
    }

    public SubwayRoute getSubwayInfo() {
        List<SubwayInfo> subwayInfos = LineRepository.lines().stream()
                .map(line -> {
                    Section section = SectionRepository.findByLine(line);
                    List<String> stationNames = section.getStationInfo();
                    return new SubwayInfo(line.getName(), stationNames);
                })
                .toList();
        return new SubwayRoute(subwayInfos);
    }
}

