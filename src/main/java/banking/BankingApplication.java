package banking;

import javax.inject.Singleton;

import org.glassfish.hk2.utilities.binding.AbstractBinder;

import banking.accounts.api.controller.AccountsController;
import banking.common.api.controller.ResponseHandler;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class BankingApplication extends Application<BankingConfiguration> {

	public static void main(String[] args) throws Exception {
		new BankingApplication().run(args);
	}


	@Override
	public String getName() {
		return "java-api";
	}

	@Override
	public void initialize(Bootstrap<BankingConfiguration> bootstrap) {

		

	}

	@Override
	public void run(BankingConfiguration configuration, Environment environment) throws Exception {

		environment.jersey().register(AccountsController.class);
		environment.jersey().register(new AbstractBinder() {
			
			@Override
			protected void configure() {
				bind(ResponseHandler.class).to(ResponseHandler.class).in(Singleton.class );
				
			}
		});

	}
}
