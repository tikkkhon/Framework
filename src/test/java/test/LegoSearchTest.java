package test;

import model.Product;
import org.testng.annotations.Test;
import page.LegoSearchPage;
import service.ProductCreator;
import service.TestDataReader;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class LegoSearchTest extends CommonConditions {

    private final String CORRECT_SEARCH_REQUEST = TestDataReader.getTestData("testdata.correct_search_request");

    @Test
    public void searchForProductTest() {
        Product testProduct = ProductCreator.createProductWithCredentialsForSearch();

        LegoSearchPage legoSearchPage = new LegoSearchPage(driver)
                .openPage()
                .setInputSearchRequest(CORRECT_SEARCH_REQUEST);

        String foundedProductName = legoSearchPage
                .getProductName();

        String foundedProductPrice = legoSearchPage
                .getProductPrice();

        assertThat(foundedProductName, is(equalTo(testProduct.getName())));
        assertThat(foundedProductPrice, is(equalTo(testProduct.getPrice())));
    }


}
