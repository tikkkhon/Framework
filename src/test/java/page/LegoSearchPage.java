package page;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import util.WaitUtils;

public class LegoSearchPage extends AbstractPage {

    private final String LEGO_SEARCH_RESULT_PAGE_URL = "https://www.lego.com/en-us";

    private final String acceptAllCookiesButtonXpath = "//button[@class='Button__Base-sc-ae3gos-0 iGRVKg CookieModalstyles__PrimaryButton-sc-19wlthm-7 ipbwEr']";
    private final String continueButtonXpath = "//button[@class='Button__Base-sc-ae3gos-0 ldrbfz AgeGatestyles__StyledButton-sc-xudtvj-12 bfdrMm']";
    private final String searchInputXpath = "//input[@class=\"Searchstyles__InputField-sc-qaapd1-4 ckHjUw\"]";
    private final String emptySearchResultAreaXpath = "//div[@class=\"SearchResultRightArea__emptyWord__LRN3T\"]";
    private final String receivedNameOfProductXpath = "//a[@data-di-id=\"di-id-9792ec8c-7e58bc47\"]//h2[@class=\"Text__BaseText-sc-13i1y3k-0 iSNFVS ProductLeafSharedstyles__Title-sc-1yg7ucv-9 zimKm\"]//span[@class=\"Markup__StyledMarkup-sc-nc8x20-0 dbPAWk\"]";
    private final String receivedPriceOfProductXpath = "//div[@data-test=\"product-leaf-price\" and @class=\"ProductLeafSharedstyles__PriceRow-sc-1yg7ucv-10 dOljwL\"]//div[@class=\"ProductPricestyles__Wrapper-sc-vmt0i4-1 chsnOq\"]//span[@data-test=\"product-price\" and @class=\"Text__BaseText-sc-13i1y3k-0 eTDhBg ProductPricestyles__StyledText-sc-vmt0i4-0 tMWye\"]";
    private final String searchButtonXpath = "//button[@class=\"MainBarstyles__OpenButton-sc-1cg7sjw-12 esrmCC\"]";

    @FindBy(xpath = searchButtonXpath)
    private WebElement searchButton;

    @FindBy(xpath = acceptAllCookiesButtonXpath)
    private WebElement acceptAllCookiesButton;

    @FindBy(xpath = searchInputXpath)
    private WebElement searchInput;

    @FindBy(xpath = emptySearchResultAreaXpath)
    private WebElement emptySearchResultArea;

    @FindBy(xpath = receivedNameOfProductXpath)
    private WebElement receivedNameOfProduct;

    @FindBy(xpath = receivedPriceOfProductXpath)
    private WebElement receivedPriceOfProduct;

    @FindBy(xpath = continueButtonXpath)
    private WebElement continueButton;

    public LegoSearchPage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(this.webDriver, this);
    }

    public LegoSearchPage setInputSearchRequest(String request) {
        WaitUtils.waitForElementToBeClickable(searchButtonXpath, webDriver);
        searchButton.click();

        WaitUtils.waitForPresenceOfAllElementsLocatedByXpath(searchInputXpath, webDriver);
        searchInput.sendKeys(request, Keys.ENTER);
        return this;
    }

    public String getEmptySearchResultArea() {
        WaitUtils.waitForPresenceOfAllElementsLocatedByXpath(emptySearchResultAreaXpath, webDriver);
        return emptySearchResultArea.getText();
    }

    public String getProductName() {
        WaitUtils.waitForPresenceOfAllElementsLocatedByXpath(receivedNameOfProductXpath, webDriver);
        return receivedNameOfProduct.getText();
    }

    public String getProductPrice() {
        WaitUtils.waitForPresenceOfAllElementsLocatedByXpath(receivedPriceOfProductXpath, webDriver);
        return receivedPriceOfProduct.getText();
    }

    @Override
    public LegoSearchPage openPage() {
        webDriver.get(LEGO_SEARCH_RESULT_PAGE_URL);

        WaitUtils.waitForPresenceOfAllElementsLocatedByXpath(continueButtonXpath, webDriver);
        WaitUtils.waitForElementToBeClickable(continueButtonXpath, webDriver);
        continueButton.click();

        WaitUtils.waitForPresenceOfAllElementsLocatedByXpath(acceptAllCookiesButtonXpath, webDriver);
        WaitUtils.waitForElementToBeClickable(acceptAllCookiesButtonXpath, webDriver);
        acceptAllCookiesButton.click();
        return this;
    }
}
