package Shop;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class ShopTest {

    /*
   1. Напишите тесты, чтобы проверить, что магазин хранит верный список продуктов (правильное количество продуктов, верное содержимое корзины).
   2. Напишите тесты для проверки корректности работы метода getMostExpensiveProduct.
   3. Напишите тесты для проверки корректности работы метода sortProductsByPrice (проверьте правильность сортировки).
   */

    public static void main(String[] args) {
        // Заводим 4 продукта для теста

        Product apple = new Product();
        apple.setTitle("Apple");
        apple.setCost(40);

        Product bread = new Product();
        bread.setTitle("Bread");
        bread.setCost(50);

        Product sugar = new Product();
        sugar.setTitle("Sugar");
        sugar.setCost(100);

        Product milk = new Product();
        milk.setTitle("Milk");
        milk.setCost(30);

        // Наполняем тестовую корзину продуктами
        Shop testShop = new Shop();
        testShop.setProducts(new ArrayList<>(Arrays.asList(apple, bread, sugar, milk)));

        // Тест, проверяем, что количество продуктов в корзине соответствует ожидаемому
        assertThat(testShop.getProducts().size()).isEqualTo(4);

        // Тест, проверяем содержимое корзины
        assertThat(testShop.getProducts().getFirst()).isEqualTo(apple);
        assertThat(testShop.getProducts().get(1)).isEqualTo(bread);
        assertThat(testShop.getProducts().get(2)).isEqualTo(sugar);
        assertThat(testShop.getProducts().get(3)).isEqualTo(milk);

        // Тест, проверяем getMostExpensiveProduct, ожидаем получить сахар
        assertThat(testShop.getMostExpensiveProduct()).isEqualTo(sugar);

        // Тест, проверяем sortProductsByPrice, проверяем, что тестовые продукты отсортировались по возрастанию цены
        List<Product> sortedProducts = testShop.sortProductsByPrice();
        assertThat(sortedProducts.getFirst()).isEqualTo(milk);
        assertThat(sortedProducts.get(1)).isEqualTo(apple);
        assertThat(sortedProducts.get(2)).isEqualTo(bread);
        assertThat(sortedProducts.get(3)).isEqualTo(sugar);
    }
}