package stepdefinitions;

import io.cucumber.java.fr.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import static org.junit.Assert.*;

public class PanierSteps {

    private WebDriver driver;

    @Soit("je suis sur la page d'accueil du site")
    public void jesuisSurLaPageAccueil() {

        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless", "--no-sandbox", "--disable-dev-shm-usage");

        driver = new ChromeDriver(options);

        // ⚠️ IMPORTANT : chemin correct vers ton fichier HTML
        driver.get("file:///C:/chemin/vers/ton/fichier/index.html");
    }

    @Quand("je clique sur le bouton {string}")
    public void jeCliqueSurLeBouton(String texte) {
        driver.findElement(By.id("btn-add")).click();
    }

    @Alors("le compteur du panier doit afficher {string}")
    public void leCompteurDoitAfficher(String valeur) {

        // ⚠️ petite sécurité (attente simple)
        try { Thread.sleep(500); } catch (InterruptedException e) {}

        String count = driver.findElement(By.id("cart-count")).getText();
        assertEquals(valeur, count);

        driver.quit();
    }
}
