package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonMethods;

public class AppointmentFlowPage extends CommonMethods {

    @FindBy(xpath = "//a[@id='appointments-go']")
    public WebElement appointmentsBTN;

    @FindBy(xpath = "//*[@class='btn btn-primary btn-block']")
    public WebElement scheduleNewAppBtn;

    @FindBy(xpath = "//select[@id='form_category']")
    public WebElement visitBtn;

    @FindBy(xpath = "//select[@id='form_provider_ae']")
    public WebElement doctorBtn;

    @FindBy(xpath = "//input[@value='See Availability']")
    public WebElement seeAvailabilityBtn;

    @FindBy(name = "form_comments")
    public WebElement reasonVisit;

    @FindBy(xpath = "//*[@id='theaddform']/div/div[6]/input")
    public WebElement saveBtn;

    @FindBy(xpath = "//td[contains(text(),'No openings were found for this period.')]")
    public WebElement noOpenings;

    @FindBy(xpath = "(//button[@class='btn btn-danger btn-sm'])[1]")
    public WebElement cancelBtn;

    @FindBy(xpath = "//button[@class='btn btn-btn-sm btn-secondary']")
    public  WebElement cancelBTn2;

   public AppointmentFlowPage(){
       PageFactory.initElements(driver,this);
   }
}
