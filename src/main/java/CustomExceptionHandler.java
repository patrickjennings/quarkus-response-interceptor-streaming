import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

import java.util.logging.Logger;

@Provider
public class CustomExceptionHandler implements ExceptionMapper<Throwable> {
    private static final Logger LOGGER = Logger.getLogger(CustomExceptionHandler.class.getName());

    @Override
    public Response toResponse(Throwable e) {
        LOGGER.info(e.toString());
        return Response
                .status(Response.Status.BAD_REQUEST)
                .entity("BAD Request")
                .type(MediaType.TEXT_PLAIN_TYPE)
                .build();
    }
}
