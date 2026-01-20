package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigFileReader {
    private Properties prop;

    public ConfigFileReader() {
        FileInputStream fis = null;
        try {
            prop = new Properties();
            File file = new File(System.getProperty("user.dir") +
                    "\\src\\test\\resources\\config.properties");

            fis = new FileInputStream(file);
            prop.load(fis);

        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Could not load config.properties!");
        } finally {
            try {
                if (fis != null)
                    fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public String getBrowser() {
        String browser_prop = prop.getProperty("browser");
        String browser_maven = System.getProperty("browser");
        String browser = browser_maven != null ? browser_maven : browser_prop;
        if (browser == null) {
            throw new RuntimeException("Browser not specified in config.properties");
        }
        return browser;
    }

    public String getUrl() {
        String url_prop = prop.getProperty("url");
        String url_maven = System.getProperty("url");
        String url = url_maven != null ? url_maven : url_prop;
        if (url == null) {
            throw new RuntimeException("URL not specified in config.properties");
        }
        return url;
    }
}
