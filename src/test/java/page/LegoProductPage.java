package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import util.WaitUtils;

public class LegoProductPage extends AbstractPage {

    private final String LEGO_PRODUCT_PAGE_URL = "https://www.lego.com/en-us/product/lion-knights-castle-10305";

    private final String acceptAllCookiesButtonXpath = "//button[@class='Button__Base-sc-ae3gos-0 iGRVKg CookieModalstyles__PrimaryButton-sc-19wlthm-7 ipbwEr']";
    private final String continueButtonXpath = "//button[@class='Button__Base-sc-ae3gos-0 ldrbfz AgeGatestyles__StyledButton-sc-xudtvj-12 bfdrMm']";
    private final String addProductToCartButtonXpath = "//div[@class=\"ButtonLabelWithProgressstyles__StyledMessage-sc-19upyqe-1 gmykdd\"]";
    private final String viewMyBagButtonXpath = "//a[@class=\"LinksNextstyles__AnchorButton-sc-1sxojvh-1 ciodVn AddToBagModalstyles__StyledLink-sc-thtx66-12 dAhZmg\"]";

    @FindBy(xpath = acceptAllCookiesButtonXpath)
    private WebElement acceptAllCookiesButton;

    @FindBy(xpath = addProductToCartButtonXpath)
    private WebElement addProductToCartButton;

    @FindBy(xpath = viewMyBagButtonXpath)
    private WebElement viewMyBagButton;

    @FindBy(xpath = continueButtonXpath)
    private WebElement continueButton;

    public LegoProductPage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(this.webDriver, this);
    }

    public LegoProductPage addProductToCart() {
        WaitUtils.waitForPresenceOfAllElementsLocatedByXpath(addProductToCartButtonXpath, webDriver);
        WaitUtils.waitForElementToBeClickable(addProductToCartButtonXpath, webDriver);
        addProductToCartButton.click();
        return this;
    }

    public LegoCartPage goToCartPage() {
        WaitUtils.waitForPresenceOfAllElementsLocatedByXpath(viewMyBagButtonXpath, webDriver);
        WaitUtils.waitForElementToBeClickable(viewMyBagButtonXpath, webDriver);
        viewMyBagButton.click();
        return new LegoCartPage(webDriver);
    }

    @Override
    public LegoProductPage openPage() {
        webDriver.get(LEGO_PRODUCT_PAGE_URL);

        WaitUtils.waitForPresenceOfAllElementsLocatedByXpath(continueButtonXpath, webDriver);
        WaitUtils.waitForElementToBeClickable(continueButtonXpath, webDriver);
        continueButton.click();

        WaitUtils.waitForPresenceOfAllElementsLocatedByXpath(acceptAllCookiesButtonXpath, webDriver);
        WaitUtils.waitForElementToBeClickable(acceptAllCookiesButtonXpath, webDriver);
        acceptAllCookiesButton.click();

        return this;
    }
}
