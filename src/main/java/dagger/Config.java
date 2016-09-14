package dagger;

import javax.inject.Singleton;

@Singleton
public class Config {

    public final String name;

    public Config(String name) {
        this.name = name;
    }
}
