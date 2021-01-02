package baseTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

public class BaseTest {
  /*  BaseTest(){

    }*/
 public WebDriver driver;
/*
    @BeforeTest
    public void Method2(){
      System.out.println("I m in Before Base Test");
      System.setProperty("webdriver.chrome.driver", "D://SeleniumPractice//Drivers//chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }*/
  @AfterTest
  public void tearDown(){
    driver.quit();
  }
}
