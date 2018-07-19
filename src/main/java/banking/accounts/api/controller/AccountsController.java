package banking.accounts.api.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.security.PermitAll;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

//import banking.accounts.application.BankAccountService;
import banking.accounts.application.dto.RequestBankAccountDto;
//import banking.accounts.application.dto.ResponseBankAccountDto;
//import banking.accounts.application.dto.mapper.BankAccountDtoMapper;
import banking.accounts.domain.entity.BankAccount;
import banking.common.api.controller.ResponseHandler;

@Path("/api/bankAccounts/")
@PermitAll
public class AccountsController {

	@Inject
	ResponseHandler responseHandler;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response listAll(@DefaultValue("1") @QueryParam("pageNumber") int pageNumber,
			@DefaultValue("10") @QueryParam("pageSize") int pageSize) {
		try {

			List<Object> response = new ArrayList<>();

			return this.responseHandler.getOkObjectResponse(response);
			
//		} catch (EntityNotFoundResultException ex) {	
//			
//			return this.responseHandler.getNotFoundObjectResponse("Bank Accounts not found", ex);

		} catch (IllegalArgumentException ex) {

			return this.responseHandler.getAppCustomErrorResponse(ex.getMessage());

		} catch (Throwable ex) {

			return this.responseHandler.getAppExceptionResponse(ex);
		}
	}

	

	

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addBankAccount(RequestBankAccountDto bankAccountDto) {
		try {

			//bankAccountService.save(bankAccountDto);

			return this.responseHandler.getOkObjectResponse("Bank account saved: " + bankAccountDto.getId());

		} catch (IllegalArgumentException ex) {

			return this.responseHandler.getAppCustomErrorResponse(ex.getMessage());

		} catch (Throwable ex) {

			return this.responseHandler.getAppExceptionResponse(ex);
		}
	}

	@PUT
	@Path("{ID}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateBankAccount(@PathParam("ID") long id, RequestBankAccountDto bankAccountDto) {

		try {

			BankAccount bankAccount = new BankAccount();//bankAccountService.update(bankAccountDto);

			return this.responseHandler.getOkObjectResponse("Bank account updated: " + bankAccount.getId());

		} catch (IllegalArgumentException ex) {

			return this.responseHandler.getAppCustomErrorResponse(ex.getMessage());

		} catch (Throwable ex) {

			return this.responseHandler.getAppExceptionResponse(ex);
		}
	}

}
