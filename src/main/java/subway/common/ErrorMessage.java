package subway.common;

public enum ErrorMessage {
    INVALID_STATION_NAME_LENGTH("역의 이름은 2글자 이상이여야 합니다."),
    CONFLICT_STATION("이미 해당 역이 존재합니다."),
    INVALID_STATION_NAME_FORMAT("역 이름의 포맷이 잘못되었습니다. - XX역 형식으로 한글을 입력해주세요."),

    INVALID_LINE_NAME_LENGTH("노선의 이름은 2글자 이상이여야 합니다."),
    CONFLICT_LINE("이미 해당 노선이 존재합니다."),
    INVALID_LINE_NAME_FORMAT("노선 이름의 포맷이 잘못되었습니다. - XX선 형식으로 한글을 입력해주세요.");


    private static final String HEADER = "[ERROR] ";
    private final String message;

    ErrorMessage(final String message) {
        this.message = message;
    }

    public String getMessage() {
        return HEADER + message;
    }
}
