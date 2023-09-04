import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Arrays;
import java.util.List;

public class BannerReduction {
    public static void main(String[] args) throws InterruptedException {
        // Set the path to the chromedriver executable
        //System.setProperty("webdriver.chrome.driver", "C:\\Users\\tihor\\Downloads\\chromedriver_win32\\chromedriver.exe");
        //C:\Users\tihor\Downloads\chromedriver-win64\chromedriver-win64
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\tihor\\Downloads\\chromedriver-win64\\\\chromedriver-win64\\chromedriver.exe");

        // Specify the path to the unpacked extension directory
        String extensionPath = "C:\\Users\\tihor\\Downloads\\internal_capstone\\NUS_MComp_CapStone\\extension";

        // Enable cookies
        ChromeOptions options = new ChromeOptions();
        options.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
        options.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);

        // Add the extension to ChromeOptions as an unpacked extension
        options.addArguments("--load-extension=" + extensionPath);

        // Create an instance of ChromeDriver
        WebDriver driver = new ChromeDriver(options);

        // List of websites to test
        List<String> websitesToTest = Arrays.asList(
                "https://www.gigabyte.com/",
                "https://www.singaporeair.com/",
                "https://www.formula1.com/",
                "https://www.virginatlantic.com/",
                "https://www.chrysal.com/en-us",
                "https://www.dailymotion.com/",
                "https://www.danskebank.com/",
                "https://www.springer.com/",
                "https://www.ubuntu.com/",
                "https://www.volkswagen.com.sg/",
                "https://stackoverflow.com/",
                "https://leica-camera.com/en-SG",
                "https://dictionary.cambridge.org/",
                "https://www.cambridge.org/",
                "https://www.faber-castell.com/",
                "https://nus.edu.sg/",
                "https://www.ft.com/",
                "https://www.lawinsider.com/",
                "https://www.sassymamasg.com/",
                "https://www.biomedcentral.com/",
                "https://www.nhs.uk/",
                "https://www.lufthansa.com/sg/en/homepage",
                "https://wwws.airfrance.sg/",
                "https://bab.la/",
                "https://www.sorbonne-universite.fr/",
                "https://www.gucci.com/us/en/",
                "https://affinity.serif.com/en-us/",
                "https://www.bauhaus.cz/",
                "https://www.begadi.com/",
                "https://www.benq.com/en-sg/index.html",
                "https://www.bol.com/nl/nl/",
                "https://borlabs.io/",
                "https://www.cdiscount.com/",
                "https://complianz.io/",
                "https://www.consentmanager.net/",
                "https://cookie-bar.eu/",
                "https://www.cookielab.io/",
                "https://cookie-script.com/",
                "https://cookiewow.com/",
                "https://webedia-group.com/",
                "https://www.deepl.com/en/translator",
                "https://www.didomi.io/",
                "https://designilpdpa.com/",
                "https://www.eurorepar.com/GB-en/",
                "https://www.easycookie.io/",
                "https://www.fanatical.com/en/",
                "https://www.flysas.com/",
                "https://gfycat.com/",
                "https://www.gov.uk/",
                "https://www.gravito.net/",
                "https://www.hampshire.police.uk/",
                "https://www.ikea.com/sg/en/",
                "https://www.ionos.com/",
                "https://www.iubenda.com/en/",
                "https://www.k-m.de/en/",
                "https://www.kk.dk/",
                "https://www.ku.dk/",
                "https://www.laitapro.fr/",
                "https://www.lego.com/en-sg",
                "https://www.lemonde.fr/",
                "https://www.les-atlantes.fr/",
                "https://www.lucide.com/en/",
                "https://www.marktplaats.nl/",
                "https://www.moneysavingexpert.com/",
                "https://www.mydealz.de/",
                "https://www.nd.nl/",
                "https://www.nordnet.dk/dk",
                "https://www.nordpoolgroup.com/en/",
                "https://www.onetrust.com/",
                "https://www.osano.com/",
                "https://phpipam.net/",
                "https://www.pricerunner.dk/",
                "https://www.saturn.de/",
                "https://sylius.com/partner/setono/",
                "https://snigel.com/",
                "https://suchen.mobile.de/",
                "https://www.sundhed.dk/",
                "https://thenextweb.com/",
                "https://www.truendo.com/",
                "https://trustarc.com/",
                "https://www.tui.co.uk/",
                "https://ufm.dk/",
                "https://www.uniconsent.com/",
                "https://usercentrics.com/",
                "https://yle.fi/",
                "https://www.wshop.com/",
                "https://www.ebay.de/",
                "https://www.pcmag.com/",
                "https://www.globo.com/",
                "https://www.bbb.org/",
                "https://www.mercari.com/",
                "https://www.overstock.com/",
                "https://www.stern.de/",
                "https://www.olx.ua/uk/",
                "https://www.nhsinform.scot/",
                "https://www.focus.de/",
                "https://european-union.europa.eu/index_en",
                "https://www.lefigaro.fr/",
                "https://www.pagesjaunes.fr/",
                "https://www.tum.de/"
        );

        int counter = 0; // Counter to track websites with fewer popups or alerts after

        for (String url : websitesToTest) {
            try {
                // Launch the website
                driver.get(url);
                System.out.println("Opened the browser and navigated to: " + url);

                // Wait for the page content to load
                WebDriverWait wait = new WebDriverWait(driver, 10);
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("body")));

                System.out.println("Page content loaded");

                // Find all elements with class names containing keywords
                List<WebElement> bannersAndAlerts = driver.findElements(By.cssSelector("[class*='popup'], [class*='banner'], [class*='alert']"));

                // Print the count of banners and alerts before the delay
                System.out.println("Total number of non-disappearing banners and alerts before: " + bannersAndAlerts.size());

                //test
                Thread.sleep(10000); // 20 seconds delay


                // Find elements with class names containing keywords again after the delay
                //List<WebElement> bannersAndAlertsAfter = driver.findElements(By.cssSelector("[class*='popup'], [class*='banner'], [class*='alert']"));

                List<WebElement> bannersAndAlertsAfter = driver.findElements(By.cssSelector("[class*='popup'], [class*='alert']"));

                // Print the count of hidden or closed banners and alerts after the delay
                System.out.println("Total number of hidden or closed banners and alerts after: " + bannersAndAlertsAfter.size());

                // Check if bannersAndAlertsAfter.size() is less than bannersAndAlerts.size()
                if (bannersAndAlertsAfter.size() != bannersAndAlerts.size()) {
                    counter++;
                }

                // Add delay before closing the browser (if needed)
                Thread.sleep(3000); // 10 seconds delay
            } catch (NoSuchElementException e) {
                System.out.println("No such element found for URL: " + url);
            } catch (Exception e) {
                System.out.println("Failed to load URL: " + url + ". Exception: " + e.getMessage());
            }
        }
        // Close the browser
        driver.quit();

        // Print the counter after all websites are tested
        System.out.println("Number of websites with fewer popups or alerts after: " + counter);
    }
}
