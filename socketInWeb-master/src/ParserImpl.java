import java.io.*;
import java.net.URLDecoder;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by employee on 11/10/16.
 */
class ParserImpl implements Parser {
    @Override
    public HttpRequest parse(InputStream stream) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
        String parameters;
        try {
            parameters = reader.readLine().split(" ")[1];
            return new HttpRequest(getPath(parameters), getParameters(parameters));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private String getPath(String parameters) {
        int par = parameters.lastIndexOf("?");
        par+=1;
        return parameters.substring(0,par==0?parameters.length():par);
    }


    Map<String, String> getParameters(String query) throws UnsupportedEncodingException {
        System.out.println("qweqweqweqweqwe!!!!"+query);
        String string = query.substring(query.indexOf("?")+1);
        Map<String, String> query_pairs = new LinkedHashMap<>();
            String[] pairs = string.split("&");
            for (String pair : pairs) {
                int idx = pair.indexOf("=");
                try
                {       query_pairs.put(URLDecoder.decode(pair.substring(0, idx), "UTF-8"),
                             URLDecoder.decode(pair.substring(idx + 1), "UTF-8"));
                }catch (Exception ignored){}
            }
            return query_pairs;
//        }

    }


}

