package subway.service;

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
}
