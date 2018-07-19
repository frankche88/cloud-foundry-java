package banking.accounts.application.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import banking.accounts.application.dto.deserializer.RequestBankAccountDtoDeserializer;
import banking.common.application.enumeration.RequestBodyType;

@JsonDeserialize(using = RequestBankAccountDtoDeserializer.class)
public class RequestBankAccountDto {
	
	private long id;
	
	RequestBodyType requestBodyType = RequestBodyType.VALID;

	public RequestBankAccountDto(RequestBodyType requestBodyType) {
		this.requestBodyType = requestBodyType;
	}

	public RequestBankAccountDto() {
		// TODO Auto-generated constructor stub
	}

	public long getId() {
		return id;
	}

}
