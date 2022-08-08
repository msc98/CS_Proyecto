package Tests;

import static org.junit.Assert.assertTrue;

import java.time.Duration;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class PHPTravels_Test1 {

	private static WebDriver driver;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		// Determina la ubicación del ChromeDriver
		System.setProperty("webdriver.chrome.driver",
				"src\\main\\resources\\Drivers\\chromedriver.exe");

		// Inicia el ChromeDriver en la variable driver
		driver = new ChromeDriver();

		// Maximiza la ventana del browser
		driver.manage().window().maximize();

		// Abre la página en el browser
		driver.get("https://www.phptravels.net/admin");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		// Cierra el browser
		driver.close();
	}

	@Test
	public void test() {

		// ************Login************

		// Crea un elemento para el campo del email buscando por nombre, y escribe el
		// texto correspondiente
		WebElement emailBox = driver.findElement(By.name("email"));
		emailBox.sendKeys("admin@phptravels.com");

		// Crea un elemento para el campo de la contraseña buscando por nombre, escribe
		// el texto correspondiente y envía lo ingresado
		WebElement passwordBox = driver.findElement(By.name("password"));
		passwordBox.sendKeys("demoadmin");
		passwordBox.submit();

		// Hace una espera implícita de 30 segundos mientras carga la página principal
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		// ************Página principal************

		// Crea el elemento hotels_1 para la primera opción "Hotels" en el menú lateral
		// buscando por Xpath, y luego hace clic sobre el elemento
		WebElement hotels_1 = driver.findElement(By.xpath("//a[@data-bs-target=\"#hotelsmodule\"]"));
		hotels_1.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		// Crea el elemento hotels_2 para la segunda opción "Hotels" en el menú lateral
		// buscando por Xpath, y luego hace clic sobre el elemento
		WebElement hotels_2 = driver.findElement(By.xpath("//a[@data-bs-target=\"#Hotels\"]"));
		hotels_2.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		// Crea el elemento hotels_3 para la tercera opción "Hotels" en el menú lateral
		// buscando por Xpath, y luego hace clic sobre el elemento
		WebElement hotels_3 = driver
				.findElement(By.xpath("//a[@href=\"https://www.phptravels.net/api/admin/hotels\"]"));
		hotels_3.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		// Crea un elemento para el botón "Add" buscando por Xpath, y hace clic sobre el
		// elemento
		WebElement addButton = driver.findElement(By.xpath("//button[@type=\"submit\"]"));
		addButton.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		// ************Pestaña "General"************

		// Se generan un número aleatorio entre 1000 y 2000 para agregar al nombre
		int randomInt = (int) Math.floor(Math.random() * (1001) + 1000);

		// Crea un String para el nombre del hotel utilizando el número aleatorio
		String hotelName = ("Hotel " + randomInt);

		// Crea un elemento para el campo del nombre del hotel buscando por nombre, y
		// escribe el texto correspondiente
		WebElement hotelNameBox = driver.findElement(By.name("hotelname"));
		hotelNameBox.sendKeys(hotelName);

		// Hace una espera de 3 segundos
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		// Crea un un elemento para el botón "Source" buscando por Xpath, y hace clic
		// sobre el elemento
		WebElement sourceBtn = driver.findElement(By.xpath("//a[@id=\"cke_46\"]"));
		sourceBtn.click();

		// Crea un elemento para el campo de la descripción buscando por Xpath, hace
		// clic sobre el elemento, y escribe el texto correspondiente
		WebElement hotelDescBox = driver.findElement(By.xpath(
				"//textarea[@class=\"cke_source cke_reset cke_enable_context_menu cke_editable cke_editable_themed cke_contents_ltr\"]"));
		hotelDescBox.click();
		hotelDescBox.sendKeys("<p>Test Description</p>");

		// ************Pestaña "Facilities"************

		// Crea un elemento para la pestaña "Facilities" buscando por id, y hace clic
		// sobre el elemento
		WebElement facilitiesTab = driver.findElement(By.id("FACILITIES-tab"));
		facilitiesTab.click();

		// Crea un elemento para el checkbox que selecciona todas las amenidades
		// buscando por Xpath, y hace clic sobre el elemento
		WebElement amenity = driver.findElement(By.xpath("//div[@class=\"icheckbox_square-grey\"]"));
		amenity.click();

		// ************Pestaña "Meta"************

		// Crea un elemento para la pestaña "Meta" buscando por id, y hace clic sobre el
		// elemento
		WebElement metaTab = driver.findElement(By.id("META_INFO-tab"));
		metaTab.click();

		// Crea un elemento para el campo del título buscando por nombre, y escribe el
		// texto correspondiente
		WebElement metaTitleBox = driver.findElement(By.name("hotelmetatitle"));
		metaTitleBox.sendKeys("Test Meta Title");

		// Crea un elemento para el campo de los keywords buscando por nombre, y escribe
		// el texto correspondiente
		WebElement metaKeywordsBox = driver.findElement(By.name("hotelkeywords"));
		metaKeywordsBox.sendKeys("testkeyword");

		// Crea un elemento para el campo de la descripción buscando por nombre, y
		// escribe el texto correspondiente
		WebElement metaDescriptionBox = driver.findElement(By.name("hotelmetadesc"));
		metaDescriptionBox.sendKeys("Test Meta Decription");

		// ************Pestaña "Policy"************

		// Crea un elemento para la pestaña "Policy" buscando por id, y hace clic sobre
		// el elemento
		WebElement policyTab = driver.findElement(By.id("POLICY-tab"));
		policyTab.click();

		// Crea un elemento para el campo del check-in buscando por nombre, y escribe el
		// texto correspondiente
		WebElement checkInTimeBox = driver.findElement(By.name("checkintime"));
		checkInTimeBox.sendKeys("3 PM");

		// Crea un elemento para el campo del check-out buscando por nombre, y escribe
		// el texto correspondiente
		WebElement checkOutTimeBox = driver.findElement(By.name("checkouttime"));
		checkOutTimeBox.sendKeys("11 AM");

		// Crea un elemento para el campo de los pagos buscando por nombre, escribe el
		// texto correspondiente y envía la información
		WebElement paymentsBox = driver.findElement(By.name("hotelpayments[]"));
		paymentsBox.sendKeys("Credit Card");
		paymentsBox.submit();

		// Crea un elemento para el campo "Policy" buscando por nombre, y escribe el
		// texto correspondiente
		WebElement policyBox = driver.findElement(By.name("hotelpolicy"));
		policyBox.sendKeys("Test Policy");

		// ************Pestaña "Contact"************

		// Crea un elemento para la pestaña "Contact" buscando por id, y hace clic sobre
		// el elemento
		WebElement contactTab = driver.findElement(By.id("CONTACT-tab"));
		contactTab.click();

		// Crea un elemento para el campo del email del hotel buscando por nombre, y
		// escribe el texto correspondiente
		WebElement hotelEmailBox = driver.findElement(By.name("hotelemail"));
		hotelEmailBox.sendKeys("testhotelemail@test.com");

		// Crea un elemento para el campo del sitio web buscando por nombre, y escribe
		// el texto correspondiente
		WebElement websiteBox = driver.findElement(By.name("hotelwebsite"));
		websiteBox.sendKeys("www.testwebsite.com");

		// Crea un elemento para el campo del teléfono buscando por nombre, y escribe el
		// texto correspondiente
		WebElement phoneBox = driver.findElement(By.name("hotelphone"));
		phoneBox.sendKeys("777-888-1010");

		// ************Sección "Main"************

		// Crea un elemento para el campo "Location" buscando por Xpath, y hace clic
		// sobre el elemento
		WebElement location = driver.findElement(By.xpath("//span[@class=\"select2-chosen\"]"));
		location.click();

		// Crea un elemento el campo de texto editable desplegado buscando por Xpath, y
		// hace clic sobre el elemento
		WebElement locations = driver.findElement(By.xpath("//*[@id=\"select2-drop\"]/div/input"));

		// Hace una espera de 3 segundos
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		// Escribe el texto correspondiente a la ubicación del hotel y espera 3 segundos
		locations.sendKeys("Newcastle");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		// Una vez desplegado y seleccionado el resultado segun la ubicación ingresada,
		// se pulsa la tecla "ENTER" para seleccionar la opción
		locations.sendKeys(Keys.RETURN);

		// Crea un elemento para el botón "Submit" buscando por id, hace clic sobre el
		// elemento y espera 10 segundos
		WebElement submit = driver.findElement(By.id("add"));
		submit.click();
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		// ************Lista de hoteles************

		// Crea un elemento para el botón "Search" buscando por Xpath, y hace clic sobre
		// el elemento
		WebElement searchBtn = driver
				.findElement(By.xpath("//*[@id=\"layoutDrawer_content\"]/main/div/div[1]/div/div[1]/div[3]/a"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", searchBtn);

		// Crea un elemento para el campo de búsqueda buscando por Xpath, y escribe el
		// nombre del hotel
		WebElement searchBox = driver.findElement(
				By.xpath("//*[@id=\"layoutDrawer_content\"]/main/div/div[1]/div/div[1]/div[3]/span[1]/input"));
		searchBox.sendKeys(hotelName);

		// Crea un elemento para el botón "Go" buscando por Xpath, y hace clic sobre el
		// elemento
		WebElement goBtn = driver.findElement(
				By.xpath("//*[@id=\"layoutDrawer_content\"]/main/div/div[1]/div/div[1]/div[3]/span[1]/span/a"));
		js.executeScript("arguments[0].click()", goBtn);

		// Realiza el assert buscando el hotel creado (por su nombre) dentro de la lista
		// de resultados de la búsqueda, si el hotel es encontrado, la prueba es exitosa
		assertTrue(driver.findElement(By.linkText(hotelName)).isDisplayed());

	}

}
