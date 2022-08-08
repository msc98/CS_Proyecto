package Tests;

import static org.junit.Assert.*;

import java.time.Duration;
import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class OpenMRS_Test1 {

	private static WebDriver driver;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {

		// Determina la ubicación del ChromeDriver
		System.setProperty("webdriver.chrome.driver",
				"\\Users\\Fer\\Documents\\Selenium\\Chrome Driver\\chromedriver.exe");

		// Inicia el ChromeDriver en la variable driver
		driver = new ChromeDriver();

		// Maximiza la ventana del browser
		driver.manage().window().maximize();

		// Abre la página en el browser
		driver.get("https://demo.openmrs.org/openmrs");

	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {

		// Cierra el browser
		driver.close();

	}

	@Test
	public void test() {

		// ************Página Login************

		// Crea elemento para el campo de usuario buscando por id, y escribe el usuario
		WebElement userBox = driver.findElement(By.id("username"));
		userBox.sendKeys("Admin");

		// Crea elemento para el campo de contraseña buscando por id, y escribe la
		// contraseña
		WebElement passwordBox = driver.findElement(By.id("password"));
		passwordBox.sendKeys("Admin123");

		// Crea elemento para las opciones de "Location" buscando por id, y hace clic en
		// el elemento
		WebElement locationBtn = driver.findElement(By.id("Inpatient Ward"));
		locationBtn.click();

		// Crea elemento para botón de login buscando por id, y hace clic en el elemento
		WebElement loginBtn = driver.findElement(By.id("loginButton"));
		loginBtn.click();

		// Espera implícitamente por 30 segundo
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		// **********Home************

		// Crea elemento para la opción de "Register a patient" buscando por id, y hace
		// clic en el elemento
		WebElement registerBtn = driver.findElement(
				By.id("referenceapplication-" + "registrationapp-registerPatient-homepageLink-referenceapplication-"
						+ "registrationapp-registerPatient-homepageLink-extension"));
		registerBtn.click();

		// ************Creación del paciente************

		// Crea elemento para el campo "Given" buscando por nombre, y escribe el texto
		// correspondiente
		WebElement nameTextBox = driver.findElement(By.name("givenName"));
		nameTextBox.sendKeys("Juan");

		// Crea elemento para el campo "Middle" buscando por nombre, y escribe el texto
		// correspondiente
		WebElement middleTextBox = driver.findElement(By.name("middleName"));
		middleTextBox.sendKeys("Manuel");

		// Crea elemento para el campo "Family Name" buscando por nombre, y escribe el
		// texto correspondiente
		WebElement lastTextBox = driver.findElement(By.name("familyName"));
		lastTextBox.sendKeys("Soto");

		// Crea elemento para el botón "Next" buscando por id, y hace clic al elemento
		WebElement nextBtn = driver.findElement(By.id("next-button"));
		nextBtn.click();

		// Crea elemento para el menú de opciones "Gender" buscando por id, y hace clic
		// al elemento
		WebElement genderBox = driver.findElement(By.id("gender-field"));
		genderBox.click();

		// Crea elemento para la opción "Male" buscando por Xpath, y hace clic al
		// elemento
		WebElement gender = driver.findElement(By.xpath("//option[@value=\"M\"]"));
		gender.click();

		// Hace clic al botón "Next"
		nextBtn.click();

		// Crea elemento para el campo "Day" buscando por id, y escribe el texto
		// correspondiente
		WebElement birthDay = driver.findElement(By.id("birthdateDay-field"));
		birthDay.sendKeys("15");

		// Crea elemento para el menú de opciones "Month" buscando por id, y hace clic
		// al elemento
		WebElement birthMonth = driver.findElement(By.id("birthdateMonth-field"));
		birthMonth.click();

		// Crea elemento para la opción "September" buscando por Xpath, y hace clic al
		// elemento
		WebElement month = driver.findElement(By.xpath("//option[@value=\"9\"]"));
		month.click();

		// Crea elemento para el campo "Year" buscando por id, y escribe el texto
		// correspondiente
		WebElement birthYear = driver.findElement(By.id("birthdateYear-field"));
		birthYear.sendKeys("1995");

		// Hace clic al botón "Next"
		nextBtn.click();

		// Crea elemento para el campo "Address" buscando por id, y escribe el texto
		// correspondiente
		WebElement addressTextBox = driver.findElement(By.id("address1"));
		addressTextBox.sendKeys("Test Address Line 1");

		// Crea elemento para el campo "Address2" buscando por id, y escribe el texto
		// correspondiente
		WebElement address2TextBox = driver.findElement(By.id("address2"));
		address2TextBox.sendKeys("Test Address Line 2");

		// Crea elemento para el campo "City/Village" buscando por id, y escribe el
		// texto correspondiente
		WebElement cityTextBox = driver.findElement(By.id("cityVillage"));
		cityTextBox.sendKeys("Test City");

		// Crea elemento para el campo "State/Province" buscando por id, y escribe el
		// texto correspondiente
		WebElement stateTextBox = driver.findElement(By.id("stateProvince"));
		stateTextBox.sendKeys("Test State");

		// Crea elemento para el campo "Country" buscando por id, y escribe el texto
		// correspondiente
		WebElement countryTextBox = driver.findElement(By.id("country"));
		countryTextBox.sendKeys("Test Country");

		// Crea elemento para el campo "Postal Code" buscando por id, y escribe el texto
		// correspondiente
		WebElement postalTextBox = driver.findElement(By.id("postalCode"));
		postalTextBox.sendKeys("12345");

		// Hace clic al botón "Next"
		nextBtn.click();

		// Crea elemento para el campo de teléfono buscando por nombre, y escribe el
		// texto correspondiente
		WebElement phoneTextBox = driver.findElement(By.name("phoneNumber"));
		phoneTextBox.sendKeys("777-888-9999");

		// Hace clic al botón "Next"
		nextBtn.click();

		// Crea elemento para el menú de opciones de relación buscando por id, y hace
		// clic al elemento
		WebElement relationshipType = driver.findElement(By.id("relationship_type"));
		relationshipType.click();

		// Crea elemento para la opción "Sibling" buscando por Xpath, y hace clic al
		// elemento
		WebElement relationship = driver.findElement(By.xpath("//option[@data-val=\"Sibling\"]"));
		relationship.click();

		// Crea elemento para el campo "Person Name" buscando por Xpath, y escribe el
		// texto correspondiente
		WebElement relationshipName = driver.findElement(By.xpath("//input[@ng-model=\"relationship.name\"]"));
		relationshipName.sendKeys("Pedro");

		// Hace clic al botón "Next"
		nextBtn.click();

		// ************Confirmación de creación************

		// Crea elemento para el botón "Confirm" buscando por id, y hace clic al
		// elemento
		WebElement confirmBtn = driver.findElement(By.id("submit"));
		confirmBtn.click();

		// Espera 5 segundos a que se cree el paciente
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}

		// ************Página del paciente creado************

		// Utilizando el Xpath, lee el "Patient ID" creado para el nuevo paciente, y lo
		// guarda en una variable String
		String patientId = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[6]/div[2]/div/span")).getText();

		// Crea elemento para el botón "Home" buscando por Xpath, y hace clic al
		// elemento
		WebElement homeBtn = driver.findElement(By.xpath("//a[@href=\"/openmrs/index.htm\"]"));
		homeBtn.click();

		// **********Home************

		// Crea elemento para la opción de "Find Patient Record" buscando por id, y hace
		// clic en el elemento
		WebElement searchBtn = driver.findElement(
				By.id("coreapps-activeVisitsHomepageLink-" + "coreapps-activeVisitsHomepageLink-extension"));
		searchBtn.click();

		// **********Búsqueda de pacientes************

		// Crea elemento para el campo de búsqueda, buscando por id, y escribe el
		// Patient ID guardado anteriormente
		WebElement searchField = driver.findElement(By.id("patient-search"));
		searchField.sendKeys(patientId);

		// Espera 5 segundos por los resultados
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		// Crea una lista de elementos para los campos del resultado desplegado
		List<WebElement> result = driver
				.findElements(By.xpath("/html/body/div/div[3]/div[2]/div/div/div/table/tbody/tr/td"));

		// Guarda el valor cada uno de los campos en la lista (campos del paciente) en
		// una variable String
		String idResult = result.get(0).getText();
		String nameResult = result.get(1).getText();
		String genderResult = result.get(2).getText();
		String ageResult = result.get(3).getText();
		String birthdateResult = result.get(4).getText();

		// Realiza los hard asserts en los cuales compara todos valores de los campos
		// del resultado desplegado con los valores del paciente creado
		assertEquals(patientId + "Recent", idResult);
		assertEquals("Juan Manuel Soto", nameResult);
		assertEquals("M", genderResult);
		assertEquals("26", ageResult);
		assertEquals("   14 Sep 1995", birthdateResult);

	}

}
