package user_story_11.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import user_story_11.pages.PearlyMarketHomePage;
import user_story_11.pages.PearlyMarketLoginRegisterPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.WaitUtils;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class AccountAndDashboard {
    PearlyMarketLoginRegisterPage pearlyMarketLoginRegisterPage=new PearlyMarketLoginRegisterPage();
    PearlyMarketHomePage pearlyMarketHomePage=new PearlyMarketHomePage();
    @Test
    public void myAccountDashboardTest(){
//    Go to website https://pearlymarket.com/
        Driver.getDriver().get(ConfigReader.getProperty("pearly_market_url"));
//    Click on Sign In link
        pearlyMarketLoginRegisterPage.signInLink.click();
//    Enter username
        pearlyMarketLoginRegisterPage.username.sendKeys("gizem_1206@hotmail.com");
//    Enter password
        pearlyMarketLoginRegisterPage.userPassword.sendKeys(ConfigReader.getProperty("vendor_password"));
//    Click on Sign In button
        pearlyMarketLoginRegisterPage.signInButton.click();
        WaitUtils.waitFor(3);
//    Assert that you signed in
        String icon=WaitUtils.waitForVisibility(By.xpath("(//*[@id='header']//span)[8]"),3).getText();
        //String icon=Driver.getDriver().findElement(By.xpath("(//*[@id='header']//span)[8]")).getText();
        assertEquals("Sign Out",icon);

//    Click on the Sign-Out icon to see "My Account"
        pearlyMarketHomePage.accountIcon.click();

//    Assert that "My Account" is visible
        assertTrue(pearlyMarketHomePage.myAccount.isDisplayed());

//    Assert that Store manager, orders, downloads, addresses , account details, wishlist, Support tickets, followings ve log out are visible in Dashboard.
        assertTrue(pearlyMarketHomePage.dashboard.isDisplayed());
        assertTrue(pearlyMarketHomePage.storeManager.isDisplayed());
        assertTrue(pearlyMarketHomePage.orders.isDisplayed());
        assertTrue(pearlyMarketHomePage.downloads.isDisplayed());
        assertTrue(pearlyMarketHomePage.addresses.isDisplayed());
        assertTrue(pearlyMarketHomePage.accountDetails.isDisplayed());
        assertTrue(pearlyMarketHomePage.wishlist.isDisplayed());
        assertTrue(pearlyMarketHomePage.supportTickets.isDisplayed());
        assertTrue(pearlyMarketHomePage.followings.isDisplayed());
        assertTrue(pearlyMarketHomePage.logout.isDisplayed());
        Driver.closeDriver();
    }
}
