package testScript;

import base.BasePage;
import baseTest.BaseTest;
import jdk.nashorn.internal.ir.Assignment;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.BodyFatCalculator;
import page.FitnessCalcuatorCopy;
import page.FitnessCalculator;
import page.page_objects_perc_calc;
import utility.Log;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Calculator extends BasePage {
    WebDriver driver ;
    /*static final Logger logger =
            LogManager.getLogger(Calculator.class.getName());
*/

    @Test(dataProvider = "Abc.xslx",dataProviderClass = Assignment,enabled = false,description = "Test Case for % calculator")

    public void percentCalculatorEg(String username,String password) {

        driver.get("http://www.calculator.net");

// Use page Object library now
        //logger.info("Click on Math Link");

        page_objects_perc_calc.lnk_math_calc(driver).click();
    //    logger.info("Click on % Link");
        page_objects_perc_calc.lnk_percent_calc(driver).click();

        page_objects_perc_calc.enterValueIntxt_num_1(driver,"10");
        page_objects_perc_calc.enterValueIntxt_num_2(driver,"50");
        page_objects_perc_calc.btn_calc(driver).click();
        String result =
                page_objects_perc_calc.web_result(driver).getText();
        System.out.println(result);
       // it is applied to fail the condition .... Assert.assertEquals(result,"6");
        Assert.assertEquals(result,"10% of 50 = 5","Results are incorrect");
        if (result.contains("5")) {
            System.out.println(" The Result is Pass");
        } else {
            System.out.println(" The Result is Fail");
        }
    }
    @Test(enabled=false,description = "Test case for fitness claculator",dependsOnMethods ="percentCalculatorEg" )
    public void fitnessCalculator()  {
        DOMConfigurator.configure("log4j2.xml");
        Log.startTest("Test Case for fitnessCalculator ");

        driver.get("http://www.calculator.net");
      //  FitnessCalculator b= new FitnessCalculator(driver);
        FitnessCalcuatorCopy b= new FitnessCalcuatorCopy(driver);

        b.clickFitnessCalculator();
        b.clickbmi_calculator();
        b.clickUsUnits();
        b.clearButton();
        b.enterAge("25");
        b.enterHeightfeet("5");
        b.enterHeight1("10");
        b.enterWeight("180");
        b.calculateButton();
      String result= b.web_result();

        System.out.println(result);
        if (result.contains("Overweight")) {
            System.out.println(" The Result is Pass");
        } else {
            System.out.println(" The Result is Fail");
        }
        Log.endTest();
    }
    @Test(enabled=true, description = "Test case for body fat calculator")
    public void bodyFatCalculator() throws InterruptedException, IOException {
       driver= driverInitializer();
        driver.get("http://www.calculator.net");
        BodyFatCalculator a=new BodyFatCalculator(driver);
        a.fitness_Calculator1();
        a.body();
        a.metricunits();
        a.clrbutton();
        Thread.sleep(2000);
        a.gender_selector();
        a.enterage("24");
        a.enterweight("80");
        a.enterheight("195");
        a.enterneck("50");
        a.enterwaist("96");
        a.enterhip("93");
        a.calculatebutton();
        String result= a.getresult();

        System.out.println(result);
        if (result.contains("Body Fat")) {
            System.out.println(" The Result is Pass");
        } else {
            System.out.println(" The Result is Fail");
        }
    }
    }
