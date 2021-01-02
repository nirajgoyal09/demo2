package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BasePage {
    public Properties prop;
    public WebDriver driver;
    public WebDriver driverInitializer() throws IOException {
        prop = new Properties();
        FileInputStream fis = new FileInputStream("D:\\SeleniumPractice\\src\\main\\resources\\config.properties");
        prop.load(fis);
        System.out.println(prop.getProperty("browser"));
        if(prop.getProperty("browser").equals("Chrome")){
            System.setProperty("webdriver.chrome.driver", "D://SeleniumPractice//Drivers//chromedriver.exe");
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        }

        return driver;

    }
}
