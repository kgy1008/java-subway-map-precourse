package subway.service;

import static subway.common.ErrorMessage.CAN_NOT_DELETE_LINE;

import java.util.List;
import subway.domain.Line;
import subway.dto.LineResponse;
import subway.repository.LineRepository;


public class LineService {

    public LineResponse findAllLines() {
        List<String> lines = LineRepository.lines().stream()
                .map(Line::getName)
                .toList();
        return new LineResponse(lines);
    }

    public void deleteLine(final String name) {
        checkDeleteLine(name);
        LineRepository.deleteLineByName(name);
    }

    private void checkDeleteLine(final String name) {
        Line line = LineRepository.findLineByName(name);
        if (line.hasStations()) {
            throw new IllegalArgumentException(CAN_NOT_DELETE_LINE.getMessage());
        }
    }
}
