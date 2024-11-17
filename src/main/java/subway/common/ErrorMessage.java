package subway.common;

public enum ErrorMessage {
    INVALID_LINE_NAME_LENGTH("지하철 노선의 이름은 2글자 이상이여야 합니다."),
    CONFLICT_LINE("이미 존재하는 노선입니다."),
    INVALID_FORMAT("부적절한 형식입니다."),

    INVALID_STATION_NAME_LENGTH("지하철 역의 이름은 2글자 이상이여야 합니다."),
    CONFLICT_STATION("이미 존재하는 역 이름 입니다."),
    ;


    private static final String HEADER = "[ERROR] ";
    private final String message;

    ErrorMessage(final String message) {
        this.message = message;
    }

    public String getMessage() {
        return HEADER + message;
    }
}
