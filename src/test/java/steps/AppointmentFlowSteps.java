package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.CommonMethods;

import java.time.Duration;
import java.util.List;

public class AppointmentFlowSteps extends CommonMethods {
    @When("I click on Appointments")
    public void i_click_on_appointments() throws InterruptedException {
       appointmentFlowPage.appointmentsBTN.click();
      Thread.sleep(5000);
    }
    @When("I click on Schedule a New Appointment")
    public void i_click_on_schedule_a_new_appointment() throws InterruptedException {
       appointmentFlowPage.scheduleNewAppBtn.click();
        Thread.sleep(2000);

    }
    @When("I select a doctor and date")
    public void i_select_a_doctor_and_date() throws InterruptedException {

        selectFromDropDown("1", appointmentFlowPage.doctorBtn);
        appointmentFlowPage.seeAvailabilityBtn.click();
        getWait();

        //getWait().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='searchResults']/div/table/tbody/tr/td")));
        driver.switchTo().frame("modalframe");
        if(appointmentFlowPage.noOpenings.isDisplayed()){
           driver.switchTo().defaultContent();
            appointmentFlowPage.cancelBtn.click();
            appointmentFlowPage.cancelBTn2.click();

        }else {
            driver.switchTo().frame("modalframe");
            List<WebElement>dayAndDate=driver.findElements(By.xpath("/html/body[@class='body_top']/div[3]/div/table/tbody/tr/td/div/a"));
            for(WebElement date:dayAndDate){
                String timeTitle=date.getAttribute("title");
                if(timeTitle.equals("Choose 2:30 pm")){
                    date.click();
                    break;
                }
            }
        }
        driver.switchTo().defaultContent();

        }

    @When("I enter the reason of this visit")
    public void i_enter_the_reason_of_this_visit() throws InterruptedException {

        getWait().until(ExpectedConditions.visibilityOf(appointmentFlowPage.reasonVisit));
       JavascriptExecutor js=(JavascriptExecutor) driver;
       js.executeScript("arguments[0].click();",appointmentFlowPage.reasonVisit);
       appointmentFlowPage.reasonVisit.sendKeys("flu symptoms");
       Thread.sleep(2000);

    }
    @When("I click save")
    public void i_click_save() {
        getWait().until(ExpectedConditions.elementToBeClickable(appointmentFlowPage.saveBtn));
        JavascriptExecutor js=(JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();",appointmentFlowPage.saveBtn);
    }
    @Then("I should be able to see the appointment form")
    public void i_should_be_able_to_see_the_appointment_form() {

        List<WebElement> appointments=driver.findElements(By.xpath("//*[@id='appointmentcard']//div[contains(@class,'card-body')]//p"));
        boolean found=false;
        for(WebElement card:appointments){
            String text=card.getText();
            System.out.println("Card text:\n" + text);
            if (text.contains("2025-05-29 2:30 pm".trim()) &&
                    text.contains("Type: Office Visit") &&
                    text.contains("Provider: Billy Smith") &&
                    text.contains("Status: ^ Pending")){
                found=true;
                break;
            }

        }
        Assert.assertTrue("Expected appointment not found in the UI!", found);
    }

}
