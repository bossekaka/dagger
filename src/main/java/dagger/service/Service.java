package dagger.service;

import io.dropwizard.lifecycle.Managed;

public interface Service extends Managed {

    @Override
    default void start() throws Exception {

    }

    @Override
    default void stop() throws Exception {

    }
}
