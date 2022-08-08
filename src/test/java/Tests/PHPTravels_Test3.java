package Tests;

import static org.junit.Assert.*;

import java.time.Duration;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class PHPTravels_Test3 {
	
	private static WebDriver driver;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
		//Localizar el Chrome Driver
	    System.setProperty("webdriver.chrome.driver",
	            "src\\main\\resources\\Drivers\\chromedriver.exe");
	    driver = new ChromeDriver();
	    //Extender la ventana de Chrome
	    driver.manage().window().maximize();
	    //Ingresar a la pagina 
	    driver.get("https://www.phptravels.net/admin");
		
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		
		//Suprimir driver
	    driver.close();
	    
	}

	@Test
	public void test() {
		
		//Localizar cada campo y llenarlos con los datos solicitados
	    WebElement  Firstnamelabeltext = driver.findElement(By.name("first_name"));
	    Firstnamelabeltext.sendKeys("Federico");
	    
	    WebElement Lastnamelabeltext = driver.findElement(By.name("last_name"));
	    Lastnamelabeltext.sendKeys("Lopez Hernandez");
	    
	    WebElement Phonelabel = driver.findElement(By.name("phone"));
	    Phonelabel.sendKeys("25523178");
	    
	    WebElement email = driver.findElement(By.name("email"));
	    email.sendKeys("admin@phptravels.com");
	    
	    WebElement password = driver.findElement(By.name("password"));
	    password.sendKeys("demoadmin");
	    
	    //Acceder al dropdown y seleccionar el rol  
	    WebElement dropdownList_accountypeA = driver.findElement(By.id("select2-account_type-container"));
	    dropdownList_accountypeA.sendKeys("Agent");
	    
	    //Localizar el boton de Signup y dar click
	    WebElement Signupbutton = driver.findElement(By.xpath("//button/span[contains(text(),\"Signup\")]"));
	    Signupbutton.click();
	    
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	    driver.manage().window().maximize();
	    driver.get("https://www.phptravels.net/signup");
	    
	    WebElement Firstnamelabeltext2 = driver.findElement(By.name("first_name"));
	    Firstnamelabeltext2.sendKeys("Arlin");
	    
	    WebElement Lastnamelabeltext2 = driver.findElement(By.name("last_name"));
	    Lastnamelabeltext2.sendKeys("Arrieta Cespedes ");
	    
	    WebElement Phonelabel2 = driver.findElement(By.name("phone"));
	    Phonelabel2.sendKeys("89657328");
	    
	    WebElement email2 = driver.findElement(By.name("email"));
	    email2.sendKeys("marrieta70227@ufide.ac.cr");
	    
	    WebElement password2 = driver.findElement(By.name("password"));
	    password2.sendKeys("demoadmin");
	    
	    WebElement dropdownList_accountypeA2 =driver.findElement(By.id("select2-account_type-container"));
	    dropdownList_accountypeA2.sendKeys("Customer");
	    
	    WebElement Signupbutton2 = driver.findElement(By.xpath("//button/span[contains(text(),\"Signup\")]"));
	    Signupbutton2.click();
	    
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	    driver.manage().window().maximize();
	    driver.get("https://www.phptravels.net/signup");
	    
	    WebElement Firstnamelabeltext3 = driver.findElement(By.name("first_name"));
	    Firstnamelabeltext3.sendKeys("Maria");
	    
	    WebElement Lastnamelabeltext3 = driver.findElement(By.name("last_name"));
	    Lastnamelabeltext3.sendKeys("Gonzalez Rojas");
	    
	    WebElement Phonelabel3 = driver.findElement(By.name("phone"));
	    Phonelabel3.sendKeys("96378917");
	    
	    WebElement email3 = driver.findElement(By.name("email"));
	    email3.sendKeys("melanyarlin@hotmail.com");
	    
	    WebElement password3 = driver.findElement(By.name("password"));
	    password3.sendKeys("demoadmin");
	    
	    WebElement dropdownList_accountypeA3 =driver.findElement(By.id("select2-account_type-container"));
	    dropdownList_accountypeA3.sendKeys("Supplier");
	    
	    WebElement Signupbutton3 = driver.findElement(By.xpath("//button/span[contains(text(),\"Signup\")]"));
	    Signupbutton3.click();
	    
	}

}

