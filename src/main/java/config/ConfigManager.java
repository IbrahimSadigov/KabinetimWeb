package config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author : Ibrahim Sadigov
 * @mailto : isadigov4638@ada.edu.az
 * @created : 11 April, 2025
 **/
public class ConfigManager {
    private static final Properties properties = new Properties();
    // The environment is determined by a system property, defaulting to "dev" if not specified.
    private static final String ENV = System.getProperty("env", "qa");

    static {
        try (InputStream input = ConfigManager.class.getClassLoader()
                .getResourceAsStream("config/" + ENV + ".properties")) {
            if (input == null) {
                throw new RuntimeException("Configuration file not found for environment: " + ENV);
            }
            properties.load(input);
        } catch (IOException e) {
            throw new RuntimeException("Failed to load configuration for environment: " + ENV, e);
        }
    }

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }
}
