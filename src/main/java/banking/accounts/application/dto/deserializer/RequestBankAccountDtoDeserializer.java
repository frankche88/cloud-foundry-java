package banking.accounts.application.dto.deserializer;

import java.io.IOException;
import java.math.BigDecimal;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;

import banking.accounts.application.dto.RequestBankAccountDto;
import banking.common.application.enumeration.RequestBodyType;

public class RequestBankAccountDtoDeserializer extends JsonDeserializer<RequestBankAccountDto> {

	@Override
	public RequestBankAccountDto deserialize(JsonParser jsonParser, DeserializationContext ctxt)
			throws IOException, JsonProcessingException {
		
		RequestBankAccountDto requestBankAccountDto;
		
		try {
    		ObjectCodec objectCodec = jsonParser.getCodec();
            JsonNode node = objectCodec.readTree(jsonParser);
            String fromAccountNumber = node.get("fromAccountNumber").asText();
            String toAccountNumber = node.get("toAccountNumber").asText();
            BigDecimal amount = new BigDecimal(node.get("amount").asText());
            requestBankAccountDto = new RequestBankAccountDto();
    	} catch(Exception ex) {
    		requestBankAccountDto = new RequestBankAccountDto(RequestBodyType.INVALID);
    	}
		return requestBankAccountDto;
	}

}
