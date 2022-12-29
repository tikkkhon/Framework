package service;

import model.Product;

public class ProductCreator {

    public static final String TESTDATA_PRODUCT_NAME = "testdata.product.name";
    public static final String TESTDATA_PRODUCT_PRICE = "testdata.product.price";
    public static final String TESTDATA_SEARCHED_PRODUCT_PRICE = "testdata.product.searched_price";

    public static Product createProductWithCredentialsFromProperty() {
        return new Product(TestDataReader.getTestData(TESTDATA_PRODUCT_NAME),
                TestDataReader.getTestData(TESTDATA_PRODUCT_PRICE));
    }

    public static Product createProductWithCredentialsForSearch() {
        return new Product(TestDataReader.getTestData(TESTDATA_PRODUCT_NAME),
                TestDataReader.getTestData(TESTDATA_SEARCHED_PRODUCT_PRICE));
    }

}
