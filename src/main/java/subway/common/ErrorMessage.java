package subway.common;

public enum ErrorMessage {

    // station error
    INVALID_STATION_NAME_LENGTH("역의 이름은 2글자 이상이여야 합니다."),
    CONFLICT_STATION("이미 해당 역이 존재합니다."),
    INVALID_STATION_NAME_FORMAT("역 이름의 포맷이 잘못되었습니다. - XX역 형식으로 한글을 입력해주세요."),
    NOT_FOUND_STATION("존재하지 않는 역 이름입니다."),
    UNAUTHORIZED_DELETE_STATION("노선에 등록된 역은 삭제할 수 없습니다."),

    // line error
    INVALID_LINE_NAME_LENGTH("노선의 이름은 2글자 이상이여야 합니다."),
    CONFLICT_LINE("이미 해당 노선이 존재합니다."),
    INVALID_LINE_NAME_FORMAT("노선 이름의 포맷이 잘못되었습니다. - XX선 형식으로 한글을 입력해주세요."),
    NOT_FOUND_LINE("존재하지 않는 노선입니다."),
    UNAUTHORIZED_DELETE_LINE("역이 등록된 노선은 삭제할 수 없습니다."),

    // input error
    INVALID_INPUT("잘못된 입력값입니다. 메뉴 목록에 있는 값을 입력해주세요."),
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
