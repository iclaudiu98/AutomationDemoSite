package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Arrays;
import java.util.List;

public class SwitchToPage {

    private final WebDriver driver;

    public SwitchToPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(className = "dropdown-toggle")
    WebElement switchToSubmenu;

    @FindBy(xpath = "/html/body/header/nav/div/div[2]/ul/li[4]/ul/li[1]/a")
    WebElement alerts;

    @FindBy(xpath = " /html/body/header/nav/div/div[2]/ul/li[4]/ul/li[2]/a")
    WebElement windows;

    @FindBy(xpath = "/html/body/header/nav/div/div[2]/ul/li[4]/ul/li[3]/a ")
    WebElement frames;

    public void clickSwitchTo() {

        switchToSubmenu.click();
    }

    public List<String> subMenuNames() {
        List<String> submeniuri;
        submeniuri = Arrays.asList(alerts.getText(), windows.getText(), frames.getText());
        return submeniuri;
    }



}