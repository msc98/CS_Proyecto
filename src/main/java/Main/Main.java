package Main;

import org.openqa.selenium.chrome.ChromeDriver;

public class Main {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\Drivers\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://phptravels.com/demo/");
	}

}
