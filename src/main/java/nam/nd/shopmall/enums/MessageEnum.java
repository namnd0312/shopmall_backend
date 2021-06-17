package nam.nd.shopmall.enums;

/**
 * @author nam.nd
 * @created 17/06/2021 - 8:37 PM
 */
public enum  MessageEnum {

    INTERNAL_API_ERROR("SEATELLER-500", "INTERNAL SERVER ERROR"),
    BAD_REQUEST("SEATELLER-400", "BAD REQUEST"),
    OK("00", "OK"),
    SUCCESS("00", "Success"),
    RECORD_NOT_EXIST("401", "Record not exist"),
    FIELD_REQUIRED("402", " {0} required");

    private  String code;
    private  String message;

    MessageEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
