package user_story_9.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WindowType;
import org.testng.annotations.Test;
import user_story_9.pages.PearlyMarketLoginRegisterPage;
import utilities.*;

import java.io.IOException;

public class RegisteredEmail extends ExtentReportsBase {
    ExcelUtils excelUtils;
    @Test
    public void registeredEmail() throws IOException {

        String path="src/test/java/resources/account.xlsx";
        String sheetName="Sheet 1";
        excelUtils=new ExcelUtils(path,sheetName);
        PearlyMarketLoginRegisterPage pearlyMarketLoginRegisterPage=new PearlyMarketLoginRegisterPage();

        //extentTest.pass("start testing");
//        Go to website https://pearlymarket.com/
        Driver.getDriver().get(ConfigReader.getProperty("pearly_market_url"));
        MediaUtils.takeScreenshotOfTheEntirePageAsString();
//        Click on Register link
        pearlyMarketLoginRegisterPage.registerLink.click();
//        Click on Become a Vendor
        pearlyMarketLoginRegisterPage.becomeAVendorLink.click();
        //extentTest.pass("register as a vendor");
        MediaUtils.takeScreenshotOfTheEntirePageAsString();
//        Enter the email
        pearlyMarketLoginRegisterPage.registerEmail.sendKeys("gguvel@hotmail.com");
        pearlyMarketLoginRegisterPage.verificationCode.click();
        //extentTest.pass("Verification code sent to your email is visible");
//        Verify that “Verification code sent to your email: guvelg@gmail.com.” is visible
        WaitUtils.waitForVisibility(pearlyMarketLoginRegisterPage.verificationCodeMessage,3);
        ReusableMethods.verifyElementDisplayed(pearlyMarketLoginRegisterPage.verificationCodeMessage);
        MediaUtils.takeScreenshotOfTheEntirePageAsString();
//        Check your e-mail
        Driver.getDriver().switchTo().newWindow(WindowType.TAB);
        Driver.getDriver().get(ConfigReader.getProperty("outlook"));
        Driver.getDriver().findElement(By.xpath("(//nav//ul//li)[2]//a")).click();
        Driver.getDriver().findElement(By.xpath("//input[@type='email']")).sendKeys("gguvel@hotmail.com");
        Driver.getDriver().findElement(By.xpath("//input[@type='submit']")).click();
        WaitUtils.waitForVisibility(By.xpath("//input[@type='password']"),5).sendKeys(excelUtils.getCellData(2,0));
        Driver.getDriver().findElement(By.id("idSIButton9")).click();
        Driver.getDriver().findElement(By.id("idBtn_Back")).click();
//        Get the verification code from your e-mail
        WaitUtils.waitForVisibility(By.xpath("//div//span[@title='info@pearlymarket.com']"),5).click();
        String verificationCode=Driver.getDriver().findElement(By.xpath("//*[@id='x_body_content_inner']/p[2]/b")).getText();

        //extentTest.pass("typing verification code");
//        Type verification code
        ReusableMethods.switchToWindow(0);
        pearlyMarketLoginRegisterPage.verificationCode.sendKeys(verificationCode);
        MediaUtils.takeScreenshotOfTheEntirePageAsString();

        //extentTest.pass("entering password");
//        Enter password and confirm password(password should contain uppercase, lowercase, digit and special character)
        pearlyMarketLoginRegisterPage.registerPassword.sendKeys(ConfigReader.getProperty("vendor_password"));
        pearlyMarketLoginRegisterPage.confirmPassword.sendKeys(ConfigReader.getProperty("vendor_password"));
        MediaUtils.takeScreenshotOfTheEntirePageAsString();
        String password="Gizem*123";
        String upper=password.replaceAll("[^A-Z]","");
        String lower=password.replaceAll("[^a-z]","");
        String digit=password.replaceAll("[^0-9]","");
        String symbol=password.replaceAll("[a-zA-Z0-9]","");
        if(password.contains(upper)&&password.contains(lower)&&password.contains(digit)&&password.contains(symbol)){
            System.out.println("password contains uppercase, lowercase, digit and special character ");
        }else {
            System.out.println("password does not contain uppercase, lowercase, digit and special character");
        }


//        Click on Register to complete registration as a vendor
        JSUtils.clickWithTimeoutByJS(pearlyMarketLoginRegisterPage.registerButton);

//        Verify that “This Email already exists. Please login to the site and apply as vendor.”  message appears
//        if user tries to register with a registered email
        //WaitUtils.waitForVisibility(pearlyMarketLoginRegisterPage.errorMessage_registeredEmail,5);
        ReusableMethods.verifyElementDisplayed(WaitUtils.waitForVisibility(pearlyMarketLoginRegisterPage.errorMessage_registeredEmail,5));

        Driver.closeDriver();

    }
}