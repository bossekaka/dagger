package dagger.rest;

import com.google.common.collect.ImmutableBiMap;
import dagger.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import java.util.Map;

@Path("/")
public class DaggerEp {

    private static Logger LOGGER = LoggerFactory.getLogger(DaggerEp.class);

    @Context
    HttpServletRequest request;

    private UserService userService;

    public DaggerEp(UserService userService) {
        LOGGER.info("CTOR: {}", this.getClass().getSimpleName());
        this.userService = userService;
    }

    @GET
    @Path("hej")
    @Produces(MediaType.APPLICATION_JSON)
    public Map<String, String> sayHello() {
        LOGGER.info("/hej: {}", request.getQueryString());
        return ImmutableBiMap.of("greeting", "Hejsan Svejsan");
    }

    @GET
    @Path("user")
    @Produces(MediaType.APPLICATION_JSON)
    public Map<String, String> getUser() {
        LOGGER.info("/user: {}", request.getQueryString());
        return ImmutableBiMap.of("user", userService.getUser());
    }
}
