

import java.util.function.Function;

/**
 * Created by employee on 11/10/16.
 */
public interface Router {

    String dispatch(HttpRequest httpRequest);

    void register(String s, Function<HttpRequest, Handler> handlerFactory);
}
