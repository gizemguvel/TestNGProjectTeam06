package user_story_9.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class PearlyMarketLoginRegisterPage {
    public PearlyMarketLoginRegisterPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//a//span[.='Register']")
    public WebElement registerLink;

    @FindBy(xpath = "//div//a[.='Become a Vendor']")
    public WebElement becomeAVendorLink;

    @FindBy(id = "user_email")
    public WebElement registerEmail;

    @FindBy(xpath = "//*[@id='wcfm_membership_registration_form_expander']/div[2]")
    public WebElement verificationCodeMessage;
    @FindBy(xpath = "//input[@placeholder='Verification Code']")
    public WebElement verificationCode;
    @FindBy(id = "passoword")
    public WebElement registerPassword;
    @FindBy(id = "confirm_pwd")
    public WebElement confirmPassword;
    @FindBy(xpath = "//input[@name='save-data']")
    public WebElement registerButton;
    @FindBy(xpath = "//div//span[@class='wcicon-status-cancelled']")
    public WebElement errorMessage_registeredEmail;

    @FindBy(xpath = "//a//span[.='Sign In']")
    public WebElement signInLink;

    @FindBy(id = "username")
    public WebElement username;

    @FindBy(id = "password")
    public WebElement userPassword;

    @FindBy(xpath = "//button[@value='Sign In']")
    public WebElement signInButton;



}