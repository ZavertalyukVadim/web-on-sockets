import java.io.IOException;

/**
 * Created by employee on 11/10/16.
 */
public class Main {

    static Router router ;
    static Server server = new Server();
    public static void main(String[] args) throws IOException {
        setup();
        server.run(router);
    }
    private static void setup() {
        router = new RouterImp();
        router.register("/calendar?", CalendarHandler::new);
        router.register("/hello_world?", GreeterHandler::new);
    }
}
