package dagger;

import javax.inject.Inject;

public class Target {

    @Inject
    Config config;

    public void sayHello() {
        System.out.println("Hello " + config.name);
    }
}
