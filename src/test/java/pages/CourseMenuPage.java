package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class CourseMenuPage {

    public CourseMenuPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy (css = ".css-96a1kx") public WebElement courseMenuTitle;

    @FindBy(xpath = "(//div[@class='css-wm5jxl'])[2]") public WebElement adultPlusSign;

    @FindBy (css = ".css-12a9ixm>:last-child") public WebElement calendarNextArrow;

    @FindBy (xpath = "//table//td//div[text()='12']") public WebElement date;

    @FindBy (xpath = "//div[@class='css-tirbjw']") public WebElement hour;

    @FindBy ( xpath = "//div[text()='Checkout']") public WebElement checkoutText;


    public WebElement getCourseMenuPageButtons (String buttonText ){
      return Driver.getDriver().findElement(By.xpath("//div[@class='css-1j096s0']/descendant::div[text()='"+buttonText+"']"));
    }








}
