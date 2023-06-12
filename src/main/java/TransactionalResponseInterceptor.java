import jakarta.annotation.Priority;
import jakarta.ws.rs.ConstrainedTo;
import jakarta.ws.rs.RuntimeType;
import jakarta.ws.rs.ext.Provider;
import jakarta.ws.rs.ext.WriterInterceptor;
import jakarta.ws.rs.ext.WriterInterceptorContext;

import java.io.IOException;
import java.util.logging.Logger;

@Provider
@ConstrainedTo(RuntimeType.SERVER)
@Priority(10000)
public class TransactionalResponseInterceptor implements WriterInterceptor {
    private static final Logger LOGGER = Logger.getLogger(TransactionalResponseInterceptor.class.getName());

    @Override
    public void aroundWriteTo(WriterInterceptorContext context) throws IOException {

        try {
            context.proceed();
        } finally {
            LOGGER.info("KeycloakSession::close here.");
        }
    }
}
