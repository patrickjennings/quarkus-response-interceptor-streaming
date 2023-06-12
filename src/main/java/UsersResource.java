import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

import java.util.stream.IntStream;
import java.util.stream.Stream;

@Path("/api/users")
public class UsersResource {

    @GET
    public Stream<Integer> users() {
        return IntStream.range(0, 10)
                .filter(x -> {
                    if(x == 9) {
                        throw new RuntimeException("This is an error");
                    }
                    return true;
                }).boxed();
    }
}