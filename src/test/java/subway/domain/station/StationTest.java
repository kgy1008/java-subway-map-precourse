package subway.domain.station;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.ValueSource;
import subway.common.ErrorMessage;

class StationTest {

    @ParameterizedTest
    @DisplayName("2글자 미만의 역 이름 입력시, 예외 발생")
    @ValueSource(strings = {"강역", "역"})
    void invalidStationNameLength(final String name) {
        assertThatThrownBy(() -> new Station(name)).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.INVALID_STATION_NAME_LENGTH.getMessage());
    }

    @ParameterizedTest
    @EmptySource
    @DisplayName("잘못된 형식의 역 이름 입력시, 예외 발생")
    @ValueSource(strings = {"강강강", "$#", "역조사", "일#원역"})
    void invalidStationNameFormat(final String name) {
        assertThatThrownBy(() -> new Station(name)).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.INVALID_STATION_NAME_FORMAT.getMessage());
    }

    @Test
    @DisplayName("이미 존재하는 역 이름 입력시, 예외 발생")
    void duplicatedStationInput() {
        StationRepository.addStation(new Station("일원역"));
        String inputStationName = "일원역";

        assertThatThrownBy(() -> new Station(inputStationName)).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.CONFLICT_STATION.getMessage());
    }
}
