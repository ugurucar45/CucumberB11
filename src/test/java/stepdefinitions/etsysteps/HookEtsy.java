package stepdefinitions.etsysteps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import utils.DriverHelper;

import java.io.File;
import java.io.IOException;
import java.util.Date;

public class HookEtsy {

    WebDriver driver=DriverHelper.getDriver();
    @Before
    public void beforeScenario(){
        System.out.println("Before sc");
    }

    @After
    public void afterScenario(Scenario scenario){
        Date currentDate= new Date();
        String screenshotfileName=currentDate.toString().replace(" ","-")
                .replace(":","-");
        if (scenario.isFailed()){
            File screenShotFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            try {
                FileUtils.copyFile(screenShotFile,new File("src/test/java/screenshot/"+screenshotfileName+".png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        DriverHelper.tearDown();
    }
}
