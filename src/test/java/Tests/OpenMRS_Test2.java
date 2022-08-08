package Tests;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class OpenMRS_Test2 {
	private static WebDriver driver;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		// Ubicar el Chrome Driver
		System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\Drivers\\chromedriver.exe");

		driver = new ChromeDriver();

		// Agrandar la ventana
		driver.manage().window().maximize();

		// Ingresar a Open MRS
		driver.get("https://demo.openmrs.org/openmrs/login.htm");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		//driver.quit();
	}

	@Test
	public void test() {
		try {
			// Ingresar datos de usuario y contrasena
			WebElement usuario = driver.findElement(By.name("username"));
			usuario.sendKeys("Admin");

			Thread.sleep(1000);

			WebElement contrasena = driver.findElement(By.name("password"));
			contrasena.sendKeys("Admin123");

			Thread.sleep(1000);

			WebElement locacion = driver.findElement(By.id("Pharmacy"));
			locacion.click();

			// Ingresar
			WebElement botonIngreso = driver.findElement(By.id("loginButton"));
			botonIngreso.click();

			Thread.sleep(1000);

			// Seleccionar la opción de administrar calendarios
			WebElement botonAgendar = driver.findElement(
					By.id("appointmentschedulingui-homeAppLink-appointmentschedulingui-homeAppLink-extension"));
			botonAgendar.click();

			Thread.sleep(1000);

			// Seleccionar la opción de administrar servicios
			WebElement botonAdministrar = driver
					.findElement(By.id("appointmentschedulingui-manageAppointmentTypes-app"));
			botonAdministrar.click();

			Thread.sleep(1000);

			// Seleccionar la opción de crear servicios
			WebElement botonCrear = driver
					.findElement(By.xpath("//button[@class=\"confirm appointment-type-label right\"]"));
			botonCrear.click();

			Thread.sleep(1000);

			// Crear un servicio
			WebElement crearNombre = driver.findElement(By.id("name-field"));
			crearNombre.clear();
			crearNombre.sendKeys("Dermatología");

			Thread.sleep(1000);
			//Ingresar la duración
			WebElement crearDuracion = driver.findElement(By.id("duration-field"));
			crearDuracion.clear();
			crearDuracion.sendKeys("60");

			Thread.sleep(1000);
			//Agrear descripción
			WebElement crearDescripcion = driver.findElement(By.id("description-field"));
			crearDescripcion.clear();
			crearDescripcion.sendKeys("Se crea consulta de Dermatología");

			Thread.sleep(1000);

			//Clic para guardar el nuevo servicio
			WebElement botonGuardar = driver.findElement(By.xpath("//input[@class=\"confirm right\"]"));
			botonGuardar.submit();
			
			assertEquals(driver.findElement(By.xpath("//*[@id=\"appointmentTypesTable\"]/tbody/tr[1]/td[1]")).getText(),"Dermatología");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
