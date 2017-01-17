import java.util.Map;

class HttpRequest {
    private String path;

    private final Map<String, String> param;

    public HttpRequest(String path, Map<String, String> param) {
        this.path = path;
        this.param = param;
    }

    public String getPath() {
        return path;
    }
    public Map<String, String> getParam() {
        return param;
    }

}
