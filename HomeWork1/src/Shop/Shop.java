package Shop;

import java.util.Comparator;
import java.util.List;
import java.util.ArrayList;

public class Shop {
    private List<Product> products;

    // Геттеры, сеттеры:
    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    // Метод должен вернуть отсортированный по возрастанию по цене список продуктов
    public List<Product> sortProductsByPrice() {
        if (products != null && !products.isEmpty()) {
            List<Product> sortedProducts = new ArrayList<>(products);
            sortedProducts.sort(Comparator.comparing(Product::getCost));
            return sortedProducts;
        }
        return null;
    }

    // Метод должен вернуть самый дорогой продукт
    public Product getMostExpensiveProduct() {
        Product maxPriceProduct;
        if (products != null && !products.isEmpty()) {
            maxPriceProduct = products.getFirst();
            for (Product product :
                    products) {
                if (product.getCost() > maxPriceProduct.getCost()) {
                    maxPriceProduct = product;
                }
            }
            return maxPriceProduct;
        }
        return null;
    }

}