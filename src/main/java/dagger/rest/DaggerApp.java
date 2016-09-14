package dagger.rest;

import dagger.DaggerDiConfig;
import dagger.DiConfig;
import dagger.repository.db.EsClient;
import dagger.repository.db.EsClientManager;
import dagger.service.UserService;
import dagger.util.ConfigReader;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Request;

public class DaggerApp extends Application<DaggerConf> {

//    @Inject
//    @Singleton
//    EsClient esClient;

    private static Logger LOGGER = LoggerFactory.getLogger(DaggerApp.class);

    @Override
    public void run(DaggerConf daggerConf, Environment environment) throws Exception {

        DiConfig diConfig = bootstrapDi(daggerConf);

        LOGGER.info("name: {}", daggerConf.name);

        // manage user service (->repo->client) instead ?
        // managedSet.addAll(userService.getManaged()) ?
//        EsClientManager esClientManager = new EsClientManager(esClient);
//        environment.lifecycle().manage(esClientManager);

        UserService userService = diConfig.createUserService();
        userService = diConfig.createUserService();
        userService = diConfig.createUserService();
        environment.lifecycle().manage(userService);

        environment.jersey().register(new DaggerEp(userService));
    }

    @Override
    public void initialize(Bootstrap<DaggerConf> bootstrap) {
        super.initialize(bootstrap);
        bootstrap.setConfigurationSourceProvider(new ConfigReader());
    }

    private DiConfig bootstrapDi(DaggerConf daggerConf) {
        DiConfig diConfig = DaggerDiConfig.builder()
                .configModule(new DiConfig.ConfigModule(daggerConf))
                .build();
//        diConfig.injectInto(this);
        return diConfig;
    }

    public static void main(String[] args) throws Exception {
        new DaggerApp().run(args);
    }
}
