package user_story_11.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class PearlyMarketHomePage {
    public PearlyMarketHomePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "//div[@class='account']//i[@class='w-icon-account']")
    public WebElement accountIcon;

    @FindBy(xpath = "//h2[.='My Account']")
    public WebElement myAccount;

    @FindBy(xpath = "//a[.='Dashboard']")
    public WebElement dashboard;

    @FindBy(xpath = "//a[.='Store Manager']")
    public WebElement storeManager;

    @FindBy(xpath = "//a[.='Orders']")
    public WebElement orders;

    @FindBy(xpath = "//a[.='Downloads']")
    public WebElement downloads;

    @FindBy(xpath = "//a[.='Addresses']")
    public WebElement addresses;

    @FindBy(xpath = "//a[.='Account details']")
    public WebElement accountDetails;

    @FindBy(xpath = "(//a[.='Wishlist'])[1]")
    public WebElement wishlist;

    @FindBy(xpath = "//a[.='Support Tickets']")
    public WebElement supportTickets;

    @FindBy(xpath = "//a[.='Followings']")
    public WebElement followings;

    @FindBy(xpath = "//a[.='Logout']")
    public WebElement logout;





}
