package Tests;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class PHPTravels_Test2 {
	private static WebDriver driver;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		// Ubicar el Chrome Driver
		System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\Drivers\\chromedriver.exe");

		driver = new ChromeDriver();

		// Agrandar la ventana
		driver.manage().window().maximize();

		// Ingresar a PHP Travels
		driver.get("https://www.phptravels.net/login");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		driver.close();
	}

	@Test
	public void test() {
		try {

			// Ingresar datos de correo y contrasena
			WebElement correo = driver.findElement(By.name("email"));
			correo.sendKeys("msalazar60008@ufide.ac.cr");

			// Enviar contrasena
			Thread.sleep(1000);
			WebElement contrasena = driver.findElement(By.name("password"));
			contrasena.sendKeys("prueba123");

			// Dar clic en ingresar
			Thread.sleep(1000);
			WebElement botonIngresar = driver.findElement(
					By.xpath("//button[@class=\"btn btn-default btn-lg btn-block effect ladda-button waves-effect\"]"));
			botonIngresar.click();

			Thread.sleep(1000);
			// Seleccionar opción Hotels en el menu
			WebElement opcionHotel = driver.findElement(By.xpath("//a[@title=\"hotels\"]"));
			opcionHotel.click();

			// Escoger el hotel
			JavascriptExecutor js = (JavascriptExecutor) driver;
			Thread.sleep(5000);
			WebElement escogerHotel = driver.findElement(By.xpath(
					"//a[@href=\"https://www.phptravels.net/hotel/en/usd/dubai/hyatt-regency-perth/38/11-08-2022/12-08-2022/1/2/0/1/IN/IN/0\"]"));
			js.executeScript("arguments[0].click()", escogerHotel);

			assertEquals("hyatt-regency-perth - PHPTRAVELS", driver.getTitle());
			
			Thread.sleep(1000);
			// Seleccionar 2 habitaciones
			WebElement cantidadHabitaciones = driver.findElement(By.name("room_quantity"))
					.findElement(By.xpath("//option[@value=\"2\"]"));
			cantidadHabitaciones.click();

			Thread.sleep(1000);
			// Dar enter para continuar reserva
			WebElement cajaBookNow = driver.findElement(By.xpath("//div[@class=\"col-md-3 booked_44\"]"));
			cajaBookNow.submit();

			// Llenar datos de viajeros
			Thread.sleep(500);
			WebElement nombreViajero1 = driver.findElement(By.name("firstname_1"));
			nombreViajero1.sendKeys("Juan");

			Thread.sleep(500);
			WebElement apellidoViajero1 = driver.findElement(By.name("lastname_1"));
			apellidoViajero1.sendKeys("Lopez");

			Thread.sleep(500);
			WebElement nombreViajero2 = driver.findElement(By.name("firstname_2"));
			nombreViajero2.sendKeys("Esmeralda");

			Thread.sleep(500);
			WebElement apellidoViajero2 = driver.findElement(By.name("lastname_2"));
			apellidoViajero2.sendKeys("Chacon");

			Thread.sleep(500);
			WebElement nombreNino1 = driver.findElement(By.name("child_firstname_1"));
			nombreNino1.sendKeys("Daniel");

			Thread.sleep(500);
			WebElement apellidoNino1 = driver.findElement(By.name("child_lastname_1"));
			apellidoNino1.sendKeys("Lopez");

			Thread.sleep(500);
			WebElement nombreNino2 = driver.findElement(By.name("child_firstname_2"));
			nombreNino2.sendKeys("Santiago");

			Thread.sleep(500);
			WebElement apellidoNino2 = driver.findElement(By.name("child_lastname_2"));
			apellidoNino2.sendKeys("Lopez");

			//Seleccionar método de pago
			WebElement marcarPago = driver.findElement(By.id("gateway_pay-later"));
			js.executeScript("arguments[0].click()", marcarPago);

			//Aceptar términos y condiciones
			WebElement marcarTerminos = driver.findElement(By.id("agreechb"));
			js.executeScript("arguments[0].click()", marcarTerminos);

			//Crear reserva
			WebElement botonReservar = driver.findElement(By.id("booking"));
			js.executeScript("arguments[0].click()", botonReservar);
			
			//Validar que genere número de reserva
			assertTrue(driver.findElement(By.xpath("//*[@id=\"fadein\"]/section[1]/div/div/div/div/div[2]/div[1]/h3/span/strong")).isDisplayed());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
