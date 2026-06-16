package Factory;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Driverfactory {
	protected WebDriver driver;
	public static WebDriver createdriver(String browser){
			
		switch (browser.toLowerCase()) {

        case "chrome" : {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--start-maximized");
            System.out.println("chrome driver created");
            return new ChromeDriver(options);
        }

        case "edge" : {
            WebDriverManager.edgedriver().setup();
            EdgeOptions options = new EdgeOptions();
            return new EdgeDriver(options);
        }

        case "firefox" : {
            WebDriverManager.firefoxdriver().setup();
            FirefoxOptions options = new FirefoxOptions();
            return new FirefoxDriver(options);
        }

        default : throw new IllegalArgumentException("Unsupported browser: " + browser);
        }
		/*else {
			if (browser.equalsIgnoreCase("chrome")) {
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--start-maximized");

                driver = new RemoteWebDriver(new URL("http://192.168.0.105:4444"), options);

            } else if (browser.equalsIgnoreCase("edge")) {
                EdgeOptions options = new EdgeOptions();

                driver = new RemoteWebDriver(new URL("http://192.168.0.105:4444"), options);

            } else {
                throw new RuntimeException("Unsupported browser for Grid");
            }*/

			
	}
	
	}


