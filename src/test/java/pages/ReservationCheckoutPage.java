package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.ConfigReader;
import utilities.Driver;

import java.util.List;

public class ReservationCheckoutPage {
    public ReservationCheckoutPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy (css = ".css-1mtizo0") public WebElement cardNumberField;

    @FindBy (xpath ="(//*[@class='css-vt2avn'])") public List<WebElement> confirmCheckboxes;

    @FindBy ( xpath = "//div[text()='I have read and agree to the byFood ']") public WebElement termsConditionCheckbox;

    @FindBy (css = "#complete") public WebElement reservationReceivedText;

    @FindBy (xpath = "(//div[@class='css-10jdsay'])[1]/descendant::div[@class='css-9hrffv'][4]]") public WebElement userDashboardReservationDate;

    public WebElement getCheckoutFields (String fieldName ){
        return Driver.getDriver().findElement(By.xpath("//label[text() = '"+fieldName+"']"));
    }

    public WebElement selectCountryAndCode (String country){
        return Driver.getDriver().findElement(By.xpath("//div[text()='"+ConfigReader.getProperty(country)+"']"));
    }


}
