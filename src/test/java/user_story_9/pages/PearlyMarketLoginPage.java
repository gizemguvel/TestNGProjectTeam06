package user_story_9.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import user_story_9.utilities.Driver;

public class PearlyMarketLoginPage {
    public PearlyMarketLoginPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//a//span[.='Register']")
    public WebElement registerLink;

    @FindBy(xpath = "//div//a[.='Become a Vendor']")
    public WebElement becomeAVendorLink;

    @FindBy(id = "user_email")
    public WebElement email;
    @FindBy(xpath = "//input[@placeholder='Verification Code']")
    public WebElement verificationCode;
    @FindBy(id = "passoword")
    public WebElement password;
    @FindBy(id = "confirm_pwd")
    public WebElement confirmPassword;
    @FindBy(id = "wcfm_membership_register_button")
    public WebElement registerButton;




}
