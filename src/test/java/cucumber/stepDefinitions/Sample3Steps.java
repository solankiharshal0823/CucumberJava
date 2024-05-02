package cucumber.stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class Sample3Steps {
    private WebDriver driver;

    public Sample3Steps() {
        this.driver = Hooks.driver;
    }

    @Given("I am on feedback page")
    public void iAmOnFeedbackPage() {
        driver.get("https://kristinek.github.io/site/tasks/provide_feedback");
    }

    @When("^Enter name: \"([^\"]*)\"$")
    public void enterName(String name) throws Throwable {
        driver.findElement(By.id("fb_name")).clear();
        driver.findElement(By.id("fb_name")).sendKeys(name);
    }

    @And("^Enter age: (\\d+)$")
    public void enterAge(int age) throws Throwable {
        driver.findElement(By.id("fb_age")).sendKeys(String.valueOf(age));
    }

    @And("^Enter language: \"([^\"]*)\"$")
    public void enterLanguage(String language) throws Throwable {
        driver.findElement(By.xpath("//input[@value='" + language + "']")).click();
    }

    @And("^Enter gender: \"([^\"]*)\"$")
    public void enterGender(String gender) throws Throwable {
        driver.findElement(By.xpath("//input[@value='" + gender + "']")).click();
    }

    @And("^Enter option: \"([^\"]*)\"$")
    public void enterOption(String option) {
        WebElement inputOption = driver.findElement(By.xpath("//select[@id='like_us']"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        inputOption.click();
        driver.findElement(By.xpath("//select[@id='like_us']//option[@value='" + option + "']"));
    }

    @And("^Enter comment: \"([^\"]*)\"$")
    public void enterComment(String comment) {
        driver.findElement(By.xpath("//textarea[@name='comment']")).clear();
        driver.findElement(By.xpath("//textarea[@name='comment']")).sendKeys(comment);
    }

    @Then("^Click submit send")
    public void clickSend() throws Throwable {
        driver.findElement(By.xpath("//button[@type='submit']")).click();
    }

    @When("I select feedback languages")
    public void iSelectFeedbackLanguages(List<String> values) throws Throwable {
        for (String value : values) {
            driver.findElement(By.xpath("//input[@value='" + value + "']")).click();
        }
    }

    @Then("I can see languages {string} in feedback check")
    public void iCanSeeLanguagesInFeedbackCheck(String message) throws Throwable {
        assertEquals(message, driver.findElement(By.xpath("//div[@class='description']//span[@id='language']")).getText());
    }

    @When("Enter values:")
    public void enterValues(Map<String, String> feedback) {
        WebElement nameField = driver.findElement(By.id("fb_name"));
        WebElement ageField = driver.findElement(By.id("fb_age"));
        List<WebElement> genderRadio = driver.findElements(By.name("gender"));
        nameField.sendKeys(feedback.get("name"));
        ageField.sendKeys(feedback.get("age"));

        for (WebElement gender : genderRadio) {
            if (gender.getAttribute("value").equalsIgnoreCase(feedback.get("gender"))) {
                gender.click();
                break;
            }
        }

    }

    @And("I check whether my data is correct")
    public void iCheckWhetherMyDataIsCorrect(Map<String, String> valuesToEnter) {
        WebElement outputName = driver.findElement(By.xpath("//div[@class='description']//span[@id='name']"));
        WebElement outputAge = driver.findElement(By.xpath("//div[@class='description']//span[@id='age']"));
        WebElement outputGender = driver.findElement(By.xpath("//div[@class='description']//span[@id='gender']"));

        assertEquals(valuesToEnter.get("name"), outputName.getText());
        assertEquals(valuesToEnter.get("age"), outputAge.getText());
        assertEquals(valuesToEnter.get("gender").toLowerCase(), outputGender.getText());
    }
}

