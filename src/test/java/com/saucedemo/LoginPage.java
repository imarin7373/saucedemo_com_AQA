package com.saucedemo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    public WebDriver driver;
    /**
     * конструктор класса, инициализацией полей класса
     */
    LoginPage(WebDriver driver){
        PageFactory.initElements(driver, this); {
            this.driver = driver;
        }
    }
    /**
     * Определение локатора поля ввода логина
     */
    @FindBy(id = "user-name")
    private WebElement loginField;
    /**
     * Метод ввода логина
     */
    public void enterLogin(String login){
        loginField.sendKeys(login);
    }
    /**
     * Определение локатора поля ввода пароля
     */
    @FindBy(id = "password")
    private WebElement passwordField;

    /**
     * Метод ввода пароля
     */
    //Метод ввода логина
    public void enterPassword(String password){
        passwordField.sendKeys(password);
    }
    /**
     * Определение локатора кнопки логина
     */
    @FindBy(id = "login-button")
    private WebElement loginBtn;
    /**
     * Метод нажатия на кнопку логин
     */
    public void clickLoginBtn(){
        loginBtn.click();
    }
}
