package isi.devops.gestion_etablissement.selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.junit.jupiter.api.Assertions.*;

public class ClasseTest {
    private WebDriver driver;

    @BeforeEach
    void setup() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized"); // Ouvre en plein écran
        options.addArguments("--headless=new"); // Mode headless pour CI/CD (optionnel)
        driver = new ChromeDriver(options);
    }

    @Test
    void testAfficherListeClasses() {
        driver.get("http://localhost:8888/classes"); // Remplace par l'URL de ta page

        // Vérifie que la page contient bien une liste de classes
        WebElement tableClasses = driver.findElement(By.id("table-classes"));
        assertNotNull(tableClasses, "La liste des classes devrait être affichée.");
    }

    @Test
    void testAjouterNouvelleClasse() {
        driver.get("http://localhost:8888/classes/new"); // Page où on ajoute une classe

        // Remplit le formulaire
        WebElement nomInput = driver.findElement(By.id("nom"));
        WebElement niveauInput = driver.findElement(By.id("niveau"));
        WebElement anneeInput = driver.findElement(By.id("anneeScolaire"));
        WebElement submitButton = driver.findElement(By.id("submit-classe"));

        nomInput.sendKeys("Terminale S");
        niveauInput.sendKeys("Lycée");
        anneeInput.sendKeys("2024-2025");
        submitButton.click();

       }

    @AfterEach
    void tearDown() {
        if (driver != null) {
            driver.quit(); // Ferme le navigateur
        }
    }
}
