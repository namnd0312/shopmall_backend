package nam.nd.shopmall.exception;

import lombok.Getter;
import lombok.Setter;
import nam.nd.shopmall.Util.Util;
import nam.nd.shopmall.enums.MessageEnum;

/**
 * @author nam.nd
 * @created 17/06/2021 - 8:36 PM
 */

@Getter
@Setter
public class LogicException  extends Exception {
    MessageEnum messageEnum;

    private String code;
    private String message;

    public LogicException(String code, String message){
        this.message = message;
        this.code = code;
    }



    public LogicException(MessageEnum messageEnum) {
        this.messageEnum = messageEnum;
    }

    public LogicException(MessageEnum messageEnum, String param) {
        String message = Util.getTextParam(messageEnum.getMessage(), param);
        String code = messageEnum.getCode();
        this.setCode(code);
        this.setMessage(message);
    }

    public LogicException() {
        super();
    }

    public MessageEnum getMessageEnum() {
        return messageEnum;
    }

    public void setMessageEnum(MessageEnum messageEnum) {
        this.messageEnum = messageEnum;
    }
}