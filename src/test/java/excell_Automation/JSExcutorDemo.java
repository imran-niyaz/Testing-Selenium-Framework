package excell_Automation;

import com.weborders.utilities.BrowserUtils;
import com.weborders.utilities.TestBase;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

public class JSExcutorDemo extends TestBase {

    @Test
    public void test(){
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        // the command creates an alert on the page
//        jse.executeScript("alert('you are doing sth dangerous');");
        EmployeesFormPage employeesFormPage = new EmployeesFormPage();

        //it will click on the employeesFormPage.male
        jse.executeScript("arguments[0].click();",
                employeesFormPage.male);

        String name = "kunkka";
        jse.executeScript("arguments[0].setAttribute('value','"+ name +"');",
                employeesFormPage.male);

        jse.executeScript("window.scrollBy(0,1000)");

        BrowserUtils.wait(7);
    }
}
