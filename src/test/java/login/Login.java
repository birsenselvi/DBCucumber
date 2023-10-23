package login;

import com.guidersoft.webdriver.Driver;
import org.apache.poi.ss.usermodel.*;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Login {
    WebDriver driver;
    @Test
    public void loginToBe(){
      driver =  Driver.getDriver();
      driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

      String file = "src/test/java/login/MOCK_DATA.xlsx";
    }

}
