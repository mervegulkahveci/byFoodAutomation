package stepDefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import pages.CourseMenuPage;
import pages.ReservationCheckoutPage;
import utilities.ConfigReader;
import utilities.Driver;
import static org.junit.Assert.*;
import static utilities.ReusableMethods.*;

public class CourseMenuReservation {
    CourseMenuPage courseMenuPage = new CourseMenuPage();
    ReservationCheckoutPage reservationCheckoutPage = new ReservationCheckoutPage();
    Actions actions = new Actions(Driver.getDriver());
    String reservationDate;

    @Given("go to {string} page")
    public void goToPage(String page) {
        Driver.getDriver().get(ConfigReader.getProperty(page));
    }

    @And("scroll down the page")
    public void scrollDownThePage() {
        actions.scrollByAmount(0,700).perform();
        waitFor(2);
    }

    @And("click on {string} button")
    public void clickOnButton(String buttonText) {
        visibleWait(courseMenuPage.getCourseMenuPageButtons(buttonText),5);
        courseMenuPage.getCourseMenuPageButtons(buttonText).click();

    }

    @Then("confirm course menu section is displayed")
    public void confirmCourseMenuSectionIsDisplayed() {
        assertTrue(courseMenuPage.courseMenuTitle.isDisplayed());
    }

    @And("add {int} adults")
    public void addAdults(int adult) {
        for (int i = 0; i < adult ; i++) {
            waitFor(1);
            clickElementByJS(courseMenuPage.adultPlusSign);

        }
    }

    @And("select a date")
    public void selectADate() {
        actions.scrollByAmount(0,400).perform();
        waitFor(2);
        courseMenuPage.calendarNextArrow.click();
        waitFor(2);
        reservationDate = courseMenuPage.date.getText();
        courseMenuPage.date.click();

    }

    @And("select hour")
    public void selectsHour() {
        waitFor(3);
        actions.scrollByAmount(0,400).perform();
        courseMenuPage.hour.click();
    }

    @Then("verify landing on checkout page")
    public void verifyLandingOnCheckoutPage() {
        visibleWait(courseMenuPage.checkoutText,6);
        assertTrue(Driver.getDriver().getCurrentUrl().contains("checkout"));
        waitFor(2);
    }


    @And("enter {string} in the {string} field")
    public void enterInTheField(String input, String field) {
        actions.moveToElement(reservationCheckoutPage.getCheckoutFields(field))
                .click()
                .sendKeys(ConfigReader.getProperty(input))
                .perform();
        waitFor(2);
    }

    @And("click on {string} from opened menu")
    public void clickOnFromOpenedMenu(String input) {
        reservationCheckoutPage.selectCountryAndCode(input).click();
        waitFor(2);
    }

    @And("enter card number information")
    public void enterCardNumberInformation() {
        actions.moveToElement(reservationCheckoutPage.cardNumberField)
                .click()
                .sendKeys(ConfigReader.getProperty("CardNumber"))
                .sendKeys(ConfigReader.getProperty("ExpDate"))
                .sendKeys(ConfigReader.getProperty("CVC"))
                .sendKeys(ConfigReader.getProperty("PostalCode"))
                .perform();
        waitFor(2);
        actions.scrollByAmount(0,500).perform();
    }

    @And("select the checkboxes")
    public void selectTheCheckboxes() {
        for (WebElement w : reservationCheckoutPage.confirmCheckboxes){
            w.click();
            waitFor(1);
        }
        actions.scrollToElement(reservationCheckoutPage.termsConditionCheckbox).perform();
        reservationCheckoutPage.termsConditionCheckbox.click();
        waitFor(2);
    }

    @Then("verify reservation is completed successfully")
    public void verifyReservationIsCompletedSuccessfully() {
        assertTrue(reservationCheckoutPage.reservationReceivedText.getText().contains("received"));
    }


    @Then("verify that the reservation is displayed on user dashboard")
    public void verifyThatTheReservationIsDisplayedOnUserDashboard() {
      assertTrue(reservationCheckoutPage.userDashboardReservationDate.getText().contains(reservationDate));

    }
}

