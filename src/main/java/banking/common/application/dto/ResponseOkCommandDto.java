package banking.common.application.dto;

public class ResponseOkCommandDto {

	private int httpStatus;
	
	private String message;

	public ResponseOkCommandDto(int httpStatus, String message) {
		super();
		this.httpStatus = httpStatus;
		this.message = message;
	}

	public int getHttpStatus() {
		return httpStatus;
	}

	public String getMessage() {
		return message;
	}
	
	
	

}
