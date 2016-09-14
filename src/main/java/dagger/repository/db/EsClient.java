package dagger.repository.db;

import dagger.Config;
import dagger.rest.DaggerConf;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class EsClient {

    private static Logger LOGGER = LoggerFactory.getLogger(EsClient.class);

    @Inject
    @Singleton
    public EsClient(DaggerConf config) {
        LOGGER.info("CTOR: EsClient [host: {}]", config.es.host);
    }

    public void start() {
        LOGGER.info("starting EsClient");
    }

    //TODO: good idea to call from service (multiple threads)
    public void stop() {
        LOGGER.info("stopping EsClient");
    }

    public String getUser() {
        return "Arne";
    }
}
