package subway.common;

public enum InfoMessage {

    CREATE_STATION("지하철 역이 등록되었습니다."),
    DELETE_STATION("지하철 역이 삭제되었습니다."),
    CREATE_LINE("지하철 노선이 등록되었습니다."),
    DELETE_LINE("지하철 노선이 삭제되었습니다."),
    CREATE_SECTION("구간이 등록되었습니다."),
    DELETE_SECTION("구간이 삭제되었습니다.");

    private static final String HEADER = "[INFO] ";
    private final String message;

    InfoMessage(final String message) {
        this.message = message;
    }

    public String getMessage() {
        return HEADER + message;
    }
}
