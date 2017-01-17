/**
 * Created by employee on 11/11/16.
 */
public class GreeterHandler implements Handler {
    static String header = "<!DOCTYPE html>\n" +
            "<html>\n" +
            "<head>\n" +
            "<title>Page Title</title>\n" +
            "</head>\n" +
            "<body>\n";


    static String footer =
            "</body>\n" +
                    "</html>";

    static String form =
            "<form method=\"LINK\" action=\"http://greater.local:8080\">\n" +
                    "    <input type=\"submit\" value=\"Home\">\n" +
                    "</form>" ;

    private HttpRequest request;

    GreeterHandler(HttpRequest httpRequest) {
        this.request=httpRequest;
    }

    @Override
    public String print(HttpRequest httpRequest) {
        System.out.println("httpRequest in Calendar Hadler="+httpRequest.getParam().size());
        System.out.println(httpRequest.getParam());
        StringBuilder builder = new StringBuilder();
        builder.append(header);
        if(httpRequest.getParam().get("name").length()==0){
            builder.append("Hello world!");
        }else {
            builder.append("Hello " + httpRequest.getParam().get("name"));
        }
        builder.append(form).append(footer);
        return builder.toString();
    }
}
