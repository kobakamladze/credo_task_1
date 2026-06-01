package utils;

import java.io.InputStream;
import java.util.Properties;

public class PropertiesReader {

    private static Properties load(String fileName) {
        Properties properties = new Properties();
        try (
            InputStream is = PropertiesReader.class
                .getClassLoader()
                .getResourceAsStream(fileName)) {
            if (is == null) {
                throw new RuntimeException(String.format("File - %s - not found: ", fileName));
            }
            properties.load(is);

        } catch (Exception e) {
            throw new RuntimeException(String.format("Failed to load: ", fileName), e);
        }
        return properties;
    }

    public static String get(String fileName, String key) {
        return load(fileName).getProperty(key);
    }
}
