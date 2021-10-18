package testrunner;

import java.io.File;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.vimalselvam.cucumber.listener.Reporter;

import cucumber.api.CucumberOptions;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
features = "src/test/java/Features",
glue= {"stepdef"},
plugin = { "pretty", "htmlreports", "com.cucumber.listener.ExtentCucumberFormatter:cucumber-reports/report.html" },
monochrome = true


)

public class Runner 
{
	@AfterClass
    public static void writeExtentReport() {
        Reporter.loadXMLConfig(new File("resources/report.xml"));
    
    }
}
