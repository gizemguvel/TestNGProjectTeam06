package user_story_9.tests;

import com.aventstack.extentreports.ExtentReports;
import org.openqa.selenium.By;
import org.openqa.selenium.WindowType;
import org.testng.annotations.Test;
import user_story_9.pages.PearlyMarketLoginRegisterPage;
import utilities.*;

import java.io.ObjectInputFilter;

public class VendorRegister {
    ExcelUtils excelUtils;

    @Test
    public void vendorRegisterTest(){
        PearlyMarketLoginRegisterPage pearlyMarketLoginRegisterPage=new PearlyMarketLoginRegisterPage();

//        Go to website https://pearlymarket.com/
        Driver.getDriver().get(ConfigReader.getProperty("pearly_market_url"));
//        Click on Register link
        pearlyMarketLoginRegisterPage.registerLink.click();
//        Click on Become a Vendor
        pearlyMarketLoginRegisterPage.becomeAVendorLink.click();
//        Enter the email
        pearlyMarketLoginRegisterPage.registerEmail.sendKeys(ConfigReader.getProperty("vendor_email"));
//        Verify that “Verification code sent to your email: guvelg@gmail.com.” is visible
        ReusableMethods.verifyExpectedAndActualTextMatch("Verification code sent to your email: guvelg@gmail.com."
        ,pearlyMarketLoginRegisterPage.verificationCodeMessage);
//        Check your e-mail
        Driver.getDriver().switchTo().newWindow(WindowType.TAB);
        Driver.getDriver().get(ConfigReader.getProperty("gmail"));
//        Get the verification code from you e-mail
        Driver.getDriver().findElement(By.id(":24")).click();
        String verificationCode=Driver.getDriver().findElement(By.xpath("//*[@id='m_-7079504241922783453body_content_inner']/p[2]/b")).getText();
//        Type verification code
        ReusableMethods.switchToWindow(0);
        pearlyMarketLoginRegisterPage.verificationCode.sendKeys(verificationCode);


//        Enter password and confirm password(password should contain uppercase, lowercase, digit and special character)
//        Click on Register to complete registration as a vendor
    }
    @Test
    public void registeredEmail(){

        String path="src/test/java/resources/account.xlsx";
        String sheetName="Sheet 1";
        excelUtils=new ExcelUtils(path,sheetName);
        PearlyMarketLoginRegisterPage pearlyMarketLoginRegisterPage=new PearlyMarketLoginRegisterPage();
//        Go to website https://pearlymarket.com/
        Driver.getDriver().get(ConfigReader.getProperty("pearly_market_url"));
//        Click on Register link
        pearlyMarketLoginRegisterPage.registerLink.click();
//        Click on Become a Vendor
        pearlyMarketLoginRegisterPage.becomeAVendorLink.click();
//        Enter the email
        pearlyMarketLoginRegisterPage.registerEmail.sendKeys("gguvel@hotmail.com");
        pearlyMarketLoginRegisterPage.verificationCode.click();
//        Verify that “Verification code sent to your email: guvelg@gmail.com.” is visible
        WaitUtils.waitForVisibility(pearlyMarketLoginRegisterPage.verificationCodeMessage,3);
        ReusableMethods.verifyElementDisplayed(pearlyMarketLoginRegisterPage.verificationCodeMessage);
//        Check your e-mail
        Driver.getDriver().switchTo().newWindow(WindowType.TAB);
        Driver.getDriver().get(ConfigReader.getProperty("outlook"));
        Driver.getDriver().findElement(By.xpath("(//nav//ul//li)[2]//a")).click();
        Driver.getDriver().findElement(By.xpath("//input[@type='email']")).sendKeys("gguvel@hotmail.com");
        Driver.getDriver().findElement(By.xpath("//input[@type='submit']")).click();
        Driver.getDriver().findElement(By.xpath("//input[@type='password']")).sendKeys(excelUtils.getCellData(2,0));
        Driver.getDriver().findElement(By.id("idSIButton9")).click();
        Driver.getDriver().findElement(By.id("idBtn_Back")).click();
//        Get the verification code from your e-mail
        WaitUtils.waitForVisibility(By.xpath("//div//span[@title='info@pearlymarket.com']"),5).click();
        //Driver.getDriver().findElement(By.xpath("//*[@id='AQAAAAAAAQwBAAAHE6dAvQAAAAA=']/div/div/div[2]/div/div[2]/div/div[1]/span")).click();
        String verificationCode=Driver.getDriver().findElement(By.xpath("//*[@id='x_body_content_inner']/p[2]/b")).getText();
//        Type verification code
        ReusableMethods.switchToWindow(0);
        pearlyMarketLoginRegisterPage.verificationCode.sendKeys(verificationCode);

//        Enter password and confirm password(password should contain uppercase, lowercase, digit and special character)
        pearlyMarketLoginRegisterPage.registerPassword.sendKeys(ConfigReader.getProperty("vendor_password"));
        pearlyMarketLoginRegisterPage.confirmPassword.sendKeys(ConfigReader.getProperty("vendor_password"));

//        Click on Register to complete registration as a vendor
        JSUtils.clickWithTimeoutByJS(pearlyMarketLoginRegisterPage.registerButton);


//        Verify that “This Email already exists. Please login to the site and apply as vendor.”  message appears
//        if user tries to register with a registered email
        //WaitUtils.waitForVisibility(pearlyMarketLoginRegisterPage.errorMessage_registeredEmail,5);
        ReusableMethods.verifyElementDisplayed(WaitUtils.waitForVisibility(pearlyMarketLoginRegisterPage.errorMessage_registeredEmail,5));

        Driver.closeDriver();

    }
}
