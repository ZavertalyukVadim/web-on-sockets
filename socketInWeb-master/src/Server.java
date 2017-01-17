import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
class Server {
    private Parser parser = new ParserImpl();
    int port = 8080;
     void run(Router router) throws IOException {
        ServerSocket server = new ServerSocket(port);
        System.out.println("Listening for connection on port 8080 ....");
        while (true) {
            Socket socket = server.accept();
            HttpRequest request = parser.parse(socket.getInputStream());
            String response = router.dispatch(request);
            socket.getOutputStream().write(response.getBytes("UTF-8"));
            socket.close();
        }
    }

}

