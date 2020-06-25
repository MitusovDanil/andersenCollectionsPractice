import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;
import java.util.Properties;

public class Helper {
    public Properties loadProperties(String propertiesFileName) throws IOException {
        Objects.requireNonNull(propertiesFileName, "Не указано имя файла");
        InputStream resourceAsStream = Thread.currentThread().getContextClassLoader().getResourceAsStream(propertiesFileName);
        Properties properties = new Properties();
        properties.load(resourceAsStream);
        return properties;
    }
}
