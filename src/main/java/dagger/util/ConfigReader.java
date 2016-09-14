package dagger.util;

import com.google.common.base.Preconditions;
import io.dropwizard.configuration.ConfigurationSourceProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;

public class ConfigReader implements ConfigurationSourceProvider {
    @Override
    public InputStream open(String s) throws IOException {
        String path = "/" + s + ".yml";
        System.out.println("looking for config: " + path);
        return this.getClass().getResourceAsStream(path);
    }
}
