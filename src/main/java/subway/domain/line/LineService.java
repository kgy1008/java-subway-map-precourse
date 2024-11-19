package subway.domain.line;

public class LineService {

    void add(final String name) {
        Line line = new Line(name);
        LineRepository.addLine(line);
    }
}
