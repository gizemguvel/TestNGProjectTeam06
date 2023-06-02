package user_story_9.pages;

import org.openqa.selenium.support.PageFactory;
import user_story_9.utilities.Driver;

public class PearlyMarketHomePage {
    public PearlyMarketHomePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

}
