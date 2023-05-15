import net.bytebuddy.implementation.bytecode.collection.ArrayAccess;
import org.example.RegisterForm;
import org.example.SwitchToPage;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;




import java.util.Arrays;
import java.util.List;

public class TestRunner {
    private   static WebDriver driver;
    @BeforeClass
    public static void setUp(){
        //Ne conectam la driverul de Chrome descarcat mai devreme
        System.setProperty("webdriver.chrome.driver", "/home/lenovobook/chromedriver_linux64/chromedriver");
        System.setProperty("webdriver.http.factory", "jdk-http-client");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    //Aici facem testele pentru site, prin create unui nou obiect de tip RegisterForm
    public void registerPage(){
        RegisterForm registerPage;
        registerPage = new RegisterForm(driver);
        registerPage.HomePage();
        registerPage.EnterFirstName("Claudiu");
        registerPage.EnterLastName("Iacob");
        registerPage.Adress("Iasi, Romania");
        registerPage.Email("iacob.claudiu1@gmail.com");
        registerPage.phoneNumber("0723715100");
        registerPage.selectGender("Female");
        registerPage.selectHobies();
        registerPage.selectLanguage();
        registerPage.selectSkills("Android");
        registerPage.selectCountry("Japan");
        registerPage.setDateOfBirth("July", "1998", "15");
        registerPage.setPassword("parolamea", "parolamea");
        registerPage.clickSubmit();
    }

    @Test
    // Aici rulam testele de pe Pagina SwithToTests
    public void SwitchToTests()
    {   driver.get("https://demo.automationtesting.in/Register.html");
        SwitchToPage switchToPage = new SwitchToPage(driver);
        switchToPage.clickSwitchTo();
        List<String> expectedSubMenuNames;
        expectedSubMenuNames = Arrays.asList("Alerts", "Windows", "Frames");
        List<String> actualresultSubNames;
        actualresultSubNames = switchToPage.subMenuNames();
        //System.out.println(actualresultSubNames);
        //System.out.println(expectedSubMenuNames);

       Assert.assertEquals( "Submeniurile nu sunt as expected",actualresultSubNames, expectedSubMenuNames);


        if (actualresultSubNames.equals(expectedSubMenuNames))
        {
            System.out.println("Submeniurile sunt as expected");
        }
        else
        {
            System.out.println("Submeniurile nu sunt as expected");
        }







    }




}
