import java.io.IOException;
import java.io.InputStream;

/**
 * Created by employee on 11/10/16.
 */
interface Parser {
    HttpRequest parse(InputStream inputStream) throws IOException;
}
