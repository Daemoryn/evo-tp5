package models;

import java.util.ArrayList;
import java.util.Date;
import java.util.Optional;
import java.util.UUID;
import models.Product;

public class Repository {
    private ArrayList<Product> products = new ArrayList<>();

    public ArrayList<Product> getProducts() {
        return products;
    }

    @Override
    public String toString() {
        return "Repository {" +
                "products = " + products +
                '}';
    }

    public void addProduct(Product p) throws Exception {
        Optional<Product> optionalProduct = products.stream().filter(product -> product.getId() == p.getId()).findFirst();
        if (optionalProduct.isPresent()) {
            throw new Exception("error: product already exist.");
        }
        products.add(p);
    }

    public Product getProductById(UUID id) throws Exception {
        for (Product p : products) {
            if (p.getId().equals(id)) {
                return p;
            }
        }
        throw new Exception("error: no product with the provided ID exists.");
    }



    public void deleteProductById(UUID id) throws Exception {
        for (Product p : products) {
            if (p.getId().equals(id)) {
                products.remove(p);
                return;
            }
        }
        throw new Exception("error: no product with the provided ID exists.");
    }

    public void updateProduct(UUID id, String name, String price, String expirationDate) throws Exception {
        Product product = getProductById(id);
        Product oldProduct = getProductById(id);
        if (!name.equals("")) {
            product.setName(name);
        }
        if (!price.equals("")) {
            product.setPrice(price);
        }
        if (!expirationDate.equals("")) {
            product.setExpirationDate(expirationDate);
        }
        int index = products.indexOf(oldProduct);
        products.set(index, product);
    }
}
