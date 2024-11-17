package subway.common;

public enum ErrorMessage {
    INVALID_LINE_NAME_LENGTH("지하철 노선의 이름은 2글자 이상이여야 합니다."),
    CONFLICT_LINE("이미 존재하는 노선입니다."),
    INVALID_FORMAT("부적절한 형식입니다."),
    CAN_NOT_DELETE_LINE("역이 등록된 노선은 삭제할 수 없습니다."),
    NOT_LINE_FOUND("존재하지 않는 노선입니다."),
    CONFLICT_ERROR("이미 해당 노선에 존재하는 역입니다."),
    NO_STATION_FOUND("해당 노선에 존재하지 않는 역입니다."),
    CAN_NOT_DELETE("노선에 포함된 역이 두개 이하일 때는 역을 제거할 수 없습니다."),

    INVALID_STATION_NAME_LENGTH("지하철 역의 이름은 2글자 이상이여야 합니다."),
    CONFLICT_STATION("이미 존재하는 역 이름 입니다."),
    NOT_STATION_FOUND("존재하지 않는 역입니다."),
    CAN_NOT_DELETE_STATION("노선에 등록된 역은 삭제할 수 없습니다."),

    INVALID_INPUT("잘못된 입력입니다. 다시 입력해 주세요."),
    INVALID_RANGE("1이상의 숫자를 입력해주세요.");


    private static final String HEADER = "[ERROR] ";
    private final String message;

    ErrorMessage(final String message) {
        this.message = message;
    }

    public String getMessage() {
        return HEADER + message;
    }
}
