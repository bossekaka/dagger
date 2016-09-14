package dagger.rest;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public class DaggerConf extends Configuration {

    @NotEmpty
    public String name;

    @NotNull
    @Valid
    public Es es;

    public static class Es {
        @NotEmpty
        public String host;
    }
}
