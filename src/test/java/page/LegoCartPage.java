package page;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import util.WaitUtils;

public class LegoCartPage extends AbstractPage{

    private final String LEGO_CART_PAGE_URL = "https://www.lego.com/en-us/cart";
    private final String acceptAllCookiesButtonXpath = "//div[@class=\"btn-asus btn-ok btn-read-ck\"]";
    private final String productNameXpath = "//h3[@class=\"Text__BaseText-sc-13i1y3k-0 iSNFVS LineItemDetailsstyles__StyledTitle-sc-ndkgof-27 dJdudQ\"]";
    private final String productPriceXpath = "//div[@class=\"Pricingstyles__PriceRow-sc-1jfbpia-3 hAwpoa\"]/span[@class=\"Text__BaseText-sc-13i1y3k-0 kkcaWu\"]/span[@class=\"Markup__StyledMarkup-sc-nc8x20-0 dbPAWk\"]";
    private final String removeProductFromCartButtonXpath = "//button[@class=\"LineItemDetailsstyles__IconButton-sc-ndkgof-0 cAXhpU\"]";
    private final String couponCodeInputXpath = "//input[@class=\"Inputstyles__InputField-sc-12nwzc4-1 gaLzqO\"]";
    private final String applyCouponCodeButtonXpath = "//button[@class=\"action apply primary\"]";
    private final String couponCodeStatusMessageXpath = "//span[@class=\"Inputstyles__ErrorText-sc-12nwzc4-3 ccSBgY\"]";
    private final String messageAfterRemovingProductsFromCartXpath = "//h1[@class=\"Text__BaseText-sc-13i1y3k-0 kYOpFp EmptyBagstyles__StyledText-sc-fd71fo-4 ljtWMs\"]";
    private final String incorrectAmountOfProductsXpath = "//div[@class=\"mage-error\"]";

    @FindBy(xpath = acceptAllCookiesButtonXpath)
    private WebElement acceptAllCookiesButton;

    @FindBy(xpath = productNameXpath)
    private WebElement productName;

    @FindBy(xpath = productPriceXpath)
    private WebElement productPrice;

    @FindBy(xpath = removeProductFromCartButtonXpath)
    private WebElement removeProductFromCartButton;

    @FindBy(xpath = couponCodeInputXpath)
    private WebElement couponCodeInput;

    @FindBy(xpath = applyCouponCodeButtonXpath)
    private WebElement applyCouponCodeButton;

    @FindBy(xpath = couponCodeStatusMessageXpath)
    private WebElement couponCodeStatusMessage;

    @FindBy(xpath = messageAfterRemovingProductsFromCartXpath)
    private WebElement messageAfterRemovingProductsFromCart;

    @FindBy(xpath = incorrectAmountOfProductsXpath)
    private WebElement incorrectAmountOfProducts;

    public LegoCartPage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(this.webDriver, this);
    }

    public String getProductName() {
        WaitUtils.waitForPresenceOfAllElementsLocatedByXpath(productNameXpath, webDriver);
        return productName.getText();
    }

    public String getProductPrice() {
        WaitUtils.waitForPresenceOfAllElementsLocatedByXpath(productPriceXpath, webDriver);
        return productPrice.getText();
    }

    public LegoCartPage removeProductFromCart() {
        WaitUtils.waitForPresenceOfAllElementsLocatedByXpath(removeProductFromCartButtonXpath, webDriver);
        WaitUtils.waitForElementToBeClickable(removeProductFromCartButtonXpath, webDriver);
        removeProductFromCartButton.click();
        return this;
    }

    public LegoCartPage enterCouponCode(String couponCode) {
        WaitUtils.waitForPresenceOfAllElementsLocatedByXpath(couponCodeInputXpath, webDriver);
        couponCodeInput.sendKeys(couponCode, Keys.ENTER);

        return this;
    }

    public String getCouponCodeStatusMessage() {
        WaitUtils.waitForPresenceOfAllElementsLocatedByXpath(couponCodeStatusMessageXpath, webDriver);
        return couponCodeStatusMessage.getText();
    }

    public String getTextAfterRemovingProductFromCart() {
        WaitUtils.waitForPresenceOfAllElementsLocatedByXpath(messageAfterRemovingProductsFromCartXpath, webDriver);
        return messageAfterRemovingProductsFromCart.getText();
    }


    @Override
    public LegoCartPage openPage() {
        webDriver.get(LEGO_CART_PAGE_URL);
        return this;
    }
}
