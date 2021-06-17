package nam.nd.shopmall.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
public class ErrorDetails {
	private Date timestamp;
	private String errorCode;
	private String message;

	public ErrorDetails() {
	}

	public ErrorDetails(Date timestamp, String errorCode, String message) {
		this.timestamp = timestamp;
		this.errorCode = errorCode;
		this.message = message;
	}
}
