package Tests;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class OpenMRS_Test3 {

	
	private static WebDriver driver;
	
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
		//Localizar el Chrome Driver
	    System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\Drivers\\chromedriver.exe");
	    driver = new ChromeDriver();
	    //Extender la ventana de Chrome
	    driver.manage().window().maximize();
	    //Ingresar a la pagina 
	    driver.get("https://demo.openmrs.org/openmrs/login.htm");
		
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		
		//Suprimir driver
		driver.close();
		
	}

	@Test
	public void test() {
		
		//Colocar el usuario y contraseña
	    WebElement usuario = driver.findElement(By.name("username"));
	    usuario.sendKeys("Admin");
	    WebElement contrasena = driver.findElement(By.name("password"));
	    contrasena.sendKeys("Admin123");
	    //Seleccionar la opcion de Pharmacy
	    WebElement locacion = driver.findElement(By.id("Pharmacy"));
	    locacion.click();
	    //Acceder 
	    WebElement botonIngreso = driver.findElement(By.id("loginButton"));
	    botonIngreso.click();
	    //Localiza el boton de Management y da click
	    WebElement botondataManagement = driver.findElement(By.id("coreapps-datamanagement-homepageLink-coreapps-datamanagement-homepageLink-extension"));
	    botondataManagement.click();
	    //Ubica el boton Merge he ingresa
	    WebElement botonMerge = driver.findElement(By.id("coreapps-mergePatientsHomepageLink-app"));
	    botonMerge.click();
	    //Encuentra el campo Id y se ingresa el Id del paciente a buscar 
	    WebElement patientId1 = driver.findElement(By.id("patient-search"));
	    patientId1.sendKeys("100LDG");
		
	}

}
