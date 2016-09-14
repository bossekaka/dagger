package dagger.service;

import dagger.repository.UserRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;

public class UserService implements Service {

    private static Logger LOGGER = LoggerFactory.getLogger(UserService.class);

    private UserRepo repo;

    @Inject
    public UserService(UserRepo repo) {
        this.repo = repo;
        LOGGER.info("CTOR: UserService");
    }

    public String getUser() {
        return repo.getUser();
    }

    @Override
    public void start() throws Exception {
        repo.start();
    }

    @Override
    public void stop() throws Exception {
        repo.stop();
    }
}
