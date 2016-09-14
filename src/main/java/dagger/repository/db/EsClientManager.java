package dagger.repository.db;

import io.dropwizard.lifecycle.Managed;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EsClientManager implements Managed {

    private static Logger LOGGER = LoggerFactory.getLogger(EsClientManager.class);

    private EsClient client;

    public EsClientManager(EsClient client) {
        LOGGER.info("CTOR: EsClientManager");
        this.client = client;
    }

    @Override
    public void start() throws Exception {
        client.start();
    }

    @Override
    public void stop() throws Exception {
        client.stop();
    }
}
