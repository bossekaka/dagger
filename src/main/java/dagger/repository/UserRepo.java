package dagger.repository;

import dagger.repository.db.EsClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;

public class UserRepo {

    private EsClient client;

    private static Logger LOGGER = LoggerFactory.getLogger(UserRepo.class);

    @Inject
    public UserRepo(EsClient client) {
        this.client = client;
        LOGGER.info("CTOR: UserRepo");
    }

    public String getUser() {
        return client.getUser();
    }

    public void start() {
        client.start();
    }

    public void stop() {
        client.stop();
    }
}
