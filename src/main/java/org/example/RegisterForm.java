package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Objects;

public class RegisterForm {

    private  WebDriver driver;
    private static final String LIMBA_ROMANA_LOCATOR  = "/html/body/section/div/div/div[2]/form/div[7]/div/multi-select/div[2]/ul/li[30]/a";
//Locator for the First Name input-form XPATH type
    @FindBy(xpath = "/html/body/section/div/div/div[2]/form/div[1]/div[1]/input")
    WebElement firstName;
//Locator for the Last Name input-form XPATH type
    @FindBy(xpath = "/html/body/section/div/div/div[2]/form/div[1]/div[2]/input")
    WebElement lastName;

//Locator for the Adress Locator Classname locator
    @FindBy(xpath = "/html/body/section/div/div/div[2]/form/div[2]/div/textarea")
    WebElement adress;

// Locator for the Email adress CSS compunded
    @FindBy(css = "input[type='email'][ng-model='EmailAdress']" )
    WebElement emailAddress;

    @FindBy(css = "input[type='tel'][ng-model='Phone']" )
    WebElement phone;

    @FindBy(id = "Skills" )
    WebElement Skills;

    @FindBy(css = "input[type='radio'][value='Male']" )

    WebElement maleGender;

    @FindBy(css = "input[type='radio'][value='FeMale']" )
    WebElement femaleGender;

    @FindBy(id = "checkbox1")
    WebElement cricket;

    @FindBy(id = "checkbox2")
    WebElement movies;

    @FindBy(id = "checkbox3")
    WebElement hockey;

    @FindBy(id = "msdd")
    WebElement languageList;

    @FindBy(css ="ul.ui-autocomplete li")
    WebElement listaLimbi;

    @FindBy(id ="country" )
    WebElement selectCountry;

    @FindBy(id = "yearbox")
    WebElement year;

    @FindBy(xpath ="/html/body/section/div/div/div[2]/form/div[11]/div[2]/select" )
    WebElement month;


    @FindBy(id = "daybox")
    WebElement day;

    @FindBy(id = "firstpassword")
    WebElement firstPasssword;

    @FindBy(id = "secondpassword")
    WebElement secondPassword;

    @FindBy(name = "signup")
    WebElement submit;



    public RegisterForm(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void EnterFirstName(String firstNameToBeCompleted)

    {
        firstName.sendKeys(firstNameToBeCompleted);

    }

    public void EnterLastName(String lastNameToBeCompleted)
    {
        lastName.sendKeys(lastNameToBeCompleted);
    }

    public void Adress(String AdressToBeCompleted)
    {
        adress.sendKeys(AdressToBeCompleted);
    }

    public void Email(String EmailAdressToBeCompleted)
    {
        emailAddress.sendKeys(EmailAdressToBeCompleted);
    }

    public void phoneNumber(String phoneNumberToBeEntered)
    {
        phone.sendKeys(phoneNumberToBeEntered);
    }

    public void selectGender(String gender){
        if (Objects.equals(gender, "Female")){
            femaleGender.click();
        }
        else if (Objects.equals(gender, "Male")){
            maleGender.click();
        }

    }

    public void HomePage(){
        driver.get("https://demo.automationtesting.in/Register.html");
    }

    public void selectHobies()
    {
        movies.click();
        hockey.click();


    }

    public void selectLanguage()
    {
        languageList.click();
        WebElement LB_ROMANA = driver.findElement(By.xpath(LIMBA_ROMANA_LOCATOR));
        LB_ROMANA.click();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,250)", "");



    }



    public void selectSkills(String skill)
    {
        Select selectSkills = new Select(Skills);
        selectSkills.selectByVisibleText(skill);


    }

    public void selectCountry(String country)
    {
        Select selectCountries = new Select(selectCountry);
        selectCountries.selectByVisibleText(country);
    }
    public void setDateOfBirth(String months, String years, String days)
    {
        Select selectyear = new Select(year);
        selectyear.selectByVisibleText(years);
        Select selectmonth = new Select(month);
        selectmonth.selectByVisibleText(months);
        Select selectday = new Select(day);
        selectday.selectByVisibleText(days);



    }

    public void setPassword(String parola, String confirmParola){
        firstPasssword.sendKeys(parola);
        secondPassword.sendKeys(confirmParola);

    }
    public void clickSubmit() {
        submit.click();

    }





















}
