package subway.domain.line;

import java.util.List;
import subway.common.ErrorMessage;
import subway.domain.section.SectionRepository;

public class LineService {

    void add(final String name) {
        Line line = new Line(name);
        LineRepository.addLine(line);
    }

    void delete(final String name) {
        Line line = LineRepository.findByName(name);
        checkCanDelete(line);
        LineRepository.deleteLine(line);
    }

    private void checkCanDelete(final Line line) {
        if (SectionRepository.isExistLine(line)) {
            throw new IllegalArgumentException(ErrorMessage.UNAUTHORIZED_DELETE_LINE.getMessage());
        }
    }

    List<Line> findAll() {
        return LineRepository.lines();
    }
}
