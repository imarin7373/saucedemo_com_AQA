package com.saucedemo;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TestCase {
    private static final Logger LOGGER = LogManager.getLogger();
    public static WebDriver driver;
    public static LoginPage loginPage;

    @BeforeTest
    public void setup(){
        WebDriverManager.chromedriver().setup();
        //Определение пути до драйвера и его настройка
//        System.setProperty("webdriver.chrome.driver", "src/test/resources/webdriver/chromedriver.exe");
        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
        //Разворачивем окно на полный экран
        driver.manage().window().maximize();
        //Задержка выполнения теста
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

    }
    @Test(testName = "login")
    public void funcTest(){
        driver.get("https://www.saucedemo.com/");
        LOGGER.info("Загрузка страницы");
        loginPage.enterLogin("standard_user");
        LOGGER.info("Вводим логин");
        loginPage.enterPassword("secret_sauce");
        LOGGER.info("Вводим пароль");
        loginPage.clickLoginBtn();
        LOGGER.info("Нажимаем на кнопку логина");
    }

    @AfterTest
    public void tearDown(){

//        driver.close();
    }
}