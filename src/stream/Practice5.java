package stream;

import java.util.*;
import java.util.stream.Collectors;

class Product {
    private String name;
    private String category;

    public Product(String name, String category) {
        this.name = name;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    @Override
    public String toString() {
        return name;
    }
}

public class Practice5 {
    public static void main(String[] args) {
        List<Product> products = Arrays.asList(
                new Product("모니터", "전자제품"),
                new Product("키보드", "전자제품"),
                new Product("사과", "식품"),
                new Product("바나나", "식품"),
                new Product("책", "도서")
        );
        Map<String, List<Product>> productsByCategory = products.stream()
                .collect(
                        Collectors.groupingBy(Product::getCategory)
                );

        System.out.println(productsByCategory);
        // {도서=[책], 전자제품=[모니터, 키보드], 식품=[사과, 바나나]}
    }

}
