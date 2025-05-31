package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonMethods;

public class LoginPage extends CommonMethods {

    @FindBy(xpath = "//input[@id='uname']")
    public WebElement usernameField;

    @FindBy(xpath = "//input[@id='pass']")
    public WebElement passwordField;

    @FindBy(xpath = "//input[@type='email']")
    public WebElement emailField;

    @FindBy(xpath = "//select[@name='languageChoice']")
    public WebElement languageChoice;

    @FindBy(xpath = "//button[contains(text(),'Log In')]")
    public WebElement loginBTN;

    @FindBy(xpath = "//div[@class='container-fluid p-0 p-sm-3']/div[1]/h2")
    public WebElement dashboardMessage;

    public LoginPage(){
        PageFactory.initElements(driver,this);
    }

}
