
package com.pbautista;


import com.github.javafaker.Faker;
import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
//import com.thoughtworks.selenium.Selenium;
//import com.thoughtworks.selenium.webdriven.WebDriverBackedSelenium;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author pbautista
 */
public class Main {
    
    public static void fill(String url) throws InterruptedException {
        long random;
        String user;
        String name;
        String fullname;
        String email;
        String password;
        String ruta = Paths.get(System.getProperty("user.home")).toAbsolutePath().toString() + "/geckodriver";


        Faker faker = new Faker();

        random = faker.number().randomNumber();
        name = faker.name().lastName();
        user = name + random;
        fullname = faker.name().fullName();
        email = user + "@gmail.com";
        password = faker.code().isbn10();

        System.setProperty("webdriver.gecko.driver", ruta);

        WebDriver driver = new FirefoxDriver();
        //String URL = "http://localhost:2145/registro.php";
        String URL=url;
        

        System.out.println("nombre falso: " + email);

        driver.get(URL);
        WebElement username = driver.findElement(By.id("username"));
        WebElement fllname = driver.findElement(By.id("fullname"));
        WebElement mail = driver.findElement(By.id("email"));
        WebElement pass = driver.findElement(By.id("password"));
        WebElement confirmpass = driver.findElement(By.id("confirm_password"));
        //WebElement submit = driver.findElement(By.id("submit"));

        username.sendKeys(user);
        fllname.sendKeys(fullname);
        mail.sendKeys(email);
        pass.sendKeys(password);
        confirmpass.sendKeys(password);

        Thread.sleep(1000);
        confirmpass.sendKeys(Keys.ENTER);
        //submit.submit();
        // WebElement btn= driver.findElement(By.className("btn btn-default"));

        //WebElement btn2=driver.findElement(By.xpath("//input[@type='submit']"));
//driver.findElement(By.className("submit")).click();
//btn2.click();
        driver.quit();

    }
    
    
    public static void main( String[] args ) throws InterruptedException {
        
        String ip=args[0];
        int times=Integer.parseInt(args[1]);
        
        System.out.println("esto entra: " +ip);
       
           
        for(int i=0; i<times;i++){
          fill(ip);
    
         
        
        
        }
        
        
        
        
        
        
    
    
    }
    
}
