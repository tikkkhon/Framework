package driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class DriverSingleton {
    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    private DriverSingleton() {}

    public static WebDriver getDriver() {

        if (null == driver.get()) {
            switch (System.getProperty("browser")) {
                case "firefox": {
                    WebDriverManager.firefoxdriver().setup();
                    FirefoxOptions firefoxOptions = new FirefoxOptions();
                    firefoxOptions.addArguments("--headless", "--no-sandbox", "--disable-dev-shm-usage");
                    driver.set(new FirefoxDriver());
                }
                default: {
                    WebDriverManager.chromedriver().setup();
                    ChromeOptions chromeOptions = new ChromeOptions();
                    chromeOptions.addArguments("--headless", "--no-sandbox", "--disable-dev-shm-usage", "--window-size=1920,1080",
                            "--disable-extensions", "--proxy-server='direct://'", "--proxy-bypass-list=*", "--start-maximized",
                            "--disable-gpu", "--ignore-certificate-errors","user-agent=Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/108.0.0.0 Safari/537.36");
                    driver.set(new ChromeDriver());
                }
            }
            driver.get().manage().window().maximize();
        }
        return driver.get();
    }

    public static void closeDriver(){
        driver.get().quit();
        driver.remove();
    }
    
}
