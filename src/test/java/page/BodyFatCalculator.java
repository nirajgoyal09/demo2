package page;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class BodyFatCalculator extends BasePage {
    public WebDriver driver;

    public BodyFatCalculator(WebDriver dri) throws IOException {
        this.driver = dri;/*verInitializer();
 */       PageFactory.initElements(dri,this);
    }
@FindBy (linkText = "Fitness & Health Calculators")
    WebElement fitnesscalc1;
    @FindBy(linkText = "Body Fat Calculator")
    WebElement body_calc;
    @FindBy(linkText = "Metric Units")
    WebElement mu;
    @FindBy(xpath = "//img[@class='clearbtn']")
    WebElement clr;
    @FindBy(xpath = "//label[@for='csex2']")
    WebElement gender;
    @FindBy(xpath = "//input[@name='cage']")
    WebElement age;
    @FindBy(xpath = "//input[@name='cweightkgs']")
    WebElement weight;
    @FindBy(xpath = "//input[@name='cheightmeter']")
    WebElement height;
    @FindBy(xpath = "//input[@name='cneckmeter']")
    WebElement neck;
    @FindBy(xpath = "//input[@name='cwaistmeter']")
    WebElement waist;
    @FindBy(xpath = "//input[@id='chipmeter']")
    WebElement hip;
    @FindBy(xpath = "//input[@value='Calculate']")
    WebElement claculate1;
    @FindBy(xpath = "//p[@class='verybigtext']")
    WebElement result;
    public void fitness_Calculator1(){fitnesscalc1.click();}
    public void body(){body_calc.click();}
    public void metricunits(){mu.click();}
    public void clrbutton(){clr.click();}
    public void gender_selector(){gender.click();}
    public void enterage(String age1){ age.sendKeys(age1);}
    public void enterweight(String w){weight.sendKeys(w);}
    public void enterheight(String h){height.sendKeys(h);}
    public void enterneck(String n){neck.sendKeys(n);}
    public void enterwaist(String w1){waist.sendKeys(w1);}
    public void enterhip(String h1){hip.sendKeys(h1);}

    public void calculatebutton(){claculate1.click();}
    public  String getresult(){
        return result.getText();
    }

}
