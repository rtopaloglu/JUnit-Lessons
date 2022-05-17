package day05_JUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_MavenTest {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //1.http://zero.webappsecurity.com sayfasina gidin
        driver.get("http://zero.webappsecurity.com");

        //2. Signin button una tiklayin
        driver.findElement(By.xpath("//button[@id='signin_button']")).click();

        //3. L ogin alanine “ yazdirin
        WebElement loginAlani = driver.findElement(By.xpath("//input[@id='user_login']"));
        loginAlani.sendKeys("username");
        //4. P assword alanine “ yazdirin
        WebElement passwordAlani = driver.findElement(By.xpath("//input[@id='user_password']"));
        passwordAlani.sendKeys("password");
        //5. Sign in buttonuna tiklayin
        driver.findElement(By.xpath("//input[@type='submit']")).click();
        driver.navigate().back();

        //6. Pay Bills sayfasina gidin
        driver.findElement(By.xpath("(//*[text()='Online Banking'])[1]")).click();
        driver.findElement(By.xpath("//span[@id='pay_bills_link']")).click();


        //7.
        //amount kismina yatirmak istediginiz herhangi bir miktari yazin

        driver.findElement(By.xpath("//input[@id='sp_amount']")).sendKeys("500");
        Thread.sleep(3000);
        //8.
        //tarih kismina “2020 0 9 10 yazdirin

        driver.findElement(By.xpath("//input[@id='sp_date']")).sendKeys("2020.09.10");
        Thread.sleep(3000);
        //9. Pay button
        //una tiklayin
        driver.findElement(By.id("pay_saved_payees")).click();
        Thread.sleep(3000);
        //10. “The payment was successfully submitted.”
        //mesajinin ciktigini control edin

        WebElement mesaj = driver.findElement(By.xpath("//*[text()='The payment was successfully submitted.']"));
        if(mesaj.isDisplayed()){
            System.out.println("Test Passed");
        } else{
            System.out.println("Test Failed");
        }
        driver.close();
    }
}
