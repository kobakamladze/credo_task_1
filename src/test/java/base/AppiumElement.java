package base;

import io.appium.java_client.AppiumDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;

import java.util.List;

public class AppiumElement implements WebElement {

    private final static Logger log = LogManager.getLogger(AppiumElement.class);

    protected AppiumDriver driver;
    private By by;

    public AppiumElement(By by) {
        driver = BaseDriver.get();
        this.by = by;
    }

    @Override
    public void click() {
        log.info(String.format("Clicking on element - %s", by));
        findElement(by).click();
    }

    @Override
    public void submit() {
        log.info(String.format("Submitting element - %s", by));
        findElement(by).submit();
    }

    @Override
    public void sendKeys(CharSequence... keysToSend) {
        log.info(String.format("Sending keys - %s - to element - %s", keysToSend, by));
        findElement(by).sendKeys(keysToSend);
    }

    @Override
    public void clear() {
        log.info(String.format("clearing element - %s", by));
        findElement(by).clear();
    }

    @Override
    public String getTagName() {
        log.info(String.format("Getting tag name of element - %s", by));
        return findElement(by).getTagName();
    }

    @Override
    public String getAttribute(String name) {
        log.info(String.format("Getting attribute - %s of element - %s", name, by));
        return findElement(by).getAttribute(name);
    }

    @Override
    public boolean isSelected() {
        log.info(String.format("Checking if element - %s - is selected", by));
        return findElement(by).isSelected();
    }

    @Override
    public boolean isEnabled() {
        log.info(String.format("Checking if element - %s - is enabled", by));
        return findElement(by).isEnabled();
    }

    @Override
    public String getText() {
        log.info(String.format("Getting text of element - %s", by));
        return findElement(by).getText();
    }

    @Override
    public List<WebElement> findElements(By by) {
        return List.of();
    }

    @Override
    public WebElement findElement(By by) {
        log.info(String.format("Looking for element - %s", by));
        return driver.findElement(by);
    }

    @Override
    public boolean isDisplayed() {
        try {
            log.info(String.format("Checking if element - %s - is displayed", by));
            return findElement(by).isDisplayed();
        } catch (NotFoundException e) {
            log.info(String.format("Element - %s - not found", by));
            return false;
        }
    }

    @Override
    public Point getLocation() {
        log.info(String.format("Getting location of element - ", by));
        WebElement element = findElement(by);
        return new Point(element.getLocation().getX(), element.getLocation().getY());
    }

    @Override
    public Dimension getSize() {
        log.info(String.format("Getting size of element - %s", by));
        return findElement(by).getSize();
    }

    @Override
    public Rectangle getRect() {
        log.info(String.format("Getting rect of element - %s", by));
        return findElement(by).getRect();
    }

    @Override
    public String getCssValue(String propertyName) {
        log.info(String.format("Getting css value of property - %s of element - %d", propertyName, by));
        return findElement(by).getCssValue(propertyName);
    }

    @Override
    public <X> X getScreenshotAs(OutputType<X> target) throws WebDriverException {
        log.info(String.format("Getting screenshot of target - %s of element - %d", target, by));
        return findElement(by).getScreenshotAs(target);
    }
}
