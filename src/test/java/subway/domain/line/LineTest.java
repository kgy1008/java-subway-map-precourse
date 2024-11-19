package subway.domain.line;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import subway.common.ErrorMessage;

class LineTest {

    @ParameterizedTest
    @DisplayName("2글자 미만의 노선 이름 입력시, 예외 발생")
    @ValueSource(strings = {"강선", "선"})
    void invalidStationNameLength(final String name) {
        assertThatThrownBy(() -> new Line(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.INVALID_LINE_NAME_LENGTH.getMessage());
    }

    @ParameterizedTest
    @DisplayName("잘못된 형식의 노선 이름 입력시, 예외 발생")
    @ValueSource(strings = {"강강강", "선1호"})
    void invalidStationNameFormat(final String name) {
        assertThatThrownBy(() -> new Line(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.INVALID_LINE_NAME_FORMAT.getMessage());
    }

    @Test
    @DisplayName("이미 존재하는 노선 이름 입력시, 예외 발생")
    void duplicatedStationInput() {
        LineRepository.addLine(new Line("1호선"));
        String inputLineName = "1호선";

        assertThatThrownBy(() -> new Line(inputLineName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.CONFLICT_LINE.getMessage());
    }
}
