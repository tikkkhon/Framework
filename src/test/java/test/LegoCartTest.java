package test;

import model.Product;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.LegoCartPage;
import page.LegoProductPage;
import service.ProductCreator;
import service.TestDataReader;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class LegoCartTest extends CommonConditions {

    private final String INVALID_COUPON_CODE = TestDataReader.getTestData("testdata.invalid_coupon_code");
    private final String INVALID_COUPON_CODE_MESSAGE = TestDataReader.getTestData("testdata.invalid_coupon_code_message");
    private final String MESSAGE_AFTER_REMOVING_PRODUCT_FROM_CART = TestDataReader.getTestData("testdata.empty_cart_message");

    @BeforeMethod(onlyForGroups = {"addedProductToCartPreconditionIsNeeded"})
    public void addProductToCart() {
        new LegoProductPage(driver)
                .openPage()
                .addProductToCart()
                .goToCartPage();
    }

    @Test
    public void addProductToCartTest() {

        Product testProduct = ProductCreator.createProductWithCredentialsFromProperty();

        LegoCartPage legoCartPage = new LegoProductPage(driver)
                .openPage()
                .addProductToCart()
                .goToCartPage();

        String addedProductName = legoCartPage.getProductName();
        String addedProductPrice = legoCartPage.getProductPrice();

        assertThat(testProduct.getName().trim(), is(equalTo(addedProductName.trim())));
        assertThat(testProduct.getPrice().trim(), is(equalTo(addedProductPrice.trim())));

    }

    @Test(groups = {"addedProductToCartPreconditionIsNeeded"})
    public void removeProductFromCartTest() {
        String messageAfterRemovingProductsFromCart = new LegoCartPage(driver)
                .removeProductFromCart()
                .getTextAfterRemovingProductFromCart();

        assertThat(messageAfterRemovingProductsFromCart, is(equalTo(MESSAGE_AFTER_REMOVING_PRODUCT_FROM_CART)));
    }

    @Test(groups = {"addedProductToCartPreconditionIsNeeded"})
    public void useInvalidCouponCodeTest() {
        String couponCodeStatusMessage = new LegoCartPage(driver)
                .enterCouponCode(INVALID_COUPON_CODE)
                .getCouponCodeStatusMessage();

        assertThat(couponCodeStatusMessage, is(equalTo(INVALID_COUPON_CODE_MESSAGE)));
    }
}
