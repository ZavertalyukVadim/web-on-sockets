/**
 * Created by employee on 11/11/16.
 */
public class HomePageHandler implements Handler {
    static String header = "<!DOCTYPE html>\n" +
            "<html>\n" +
            "<head>\n" +
            "<title>Page Title</title>\n" +
            "</head>\n" +
            "<body>\n";
    static String footer =
            "</body>\n" +
                    "</html>";
    static String headerForMyCalendar =
            "<form action=\"http://greater.local:8080/calendar?\">\n" +
                    "  <p><b>Введите вариант</b></p>\n" +
                    "  <input placeholder=\"day=1-31\"; type=\"text\"name=\"day\" \n<Br>\n" +
                    "  <input placeholder=\"month=1-12\"; type=\"text\"name=\"month\" \n<Br>\n" +
                    "  <input placeholder=\"year=1111\"; type=\"text\"name=\"year\" \n<Br>\n" +
                    "  <input placeholder=\"dayOfWeek=1-7\"; type=\"text\"name=\"dayOfWeek\" \n<Br>\n" +
                    "  <input placeholder=\"weekends=1-7\"; type=\"text\"name=\"weekends\" \n<Br>\n" +

                    "  <p><input type=\"submit\"value=\"Let's go!\"></p>\n" +
                    " </form>\n";

    static String headerForHelloWorld =
            " <form action=\"http://greater.local:8080/hello_world?\">\n" +
                    "  <p><b>Введите вариант</b></p>\n" +
                    "  <input type=\"text\" name=\"name\" \n<Br>\n" +
                    "  <p><input type=\"submit\"value=\"Let's go!\"></p>\n" +
                    " </form>\n";

    public HomePageHandler(HttpRequest httpRequest) {
    }

    @Override
    public String print(HttpRequest httpRequest) {
        return header + headerForMyCalendar + headerForHelloWorld + footer;
    }
}
