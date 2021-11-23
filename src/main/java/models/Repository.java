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
        return "Repository{" +
                "products=" + products +
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
        Optional<Product> optionalProduct = products.stream().filter(product -> product.getId() == id).findFirst();
        if (optionalProduct.isPresent()) {
            return optionalProduct.get();
        }
        throw new Exception("error: no product with the provided ID exists.");
    }

    public void deleteProductById(UUID id) throws Exception {
        if (!products.removeIf(product -> product.getId() == id)) {
            throw new Exception("error: no product with the provided ID exists.");
        }
    }

    public void updateProduct(UUID id, String name, double price, Date expirationDate) throws Exception {
        Product product = getProductById(id);
        Product oldProduct = getProductById(id);
        if (!name.equals("")) {
            product.setName(name);
        }
        if (price != -1) {
            product.setPrice(price);
        }
        if (expirationDate != null) {
            product.setExpirationDate(expirationDate);
        }
        int index = products.indexOf(oldProduct);
        products.set(index, product);
    }

    public void updateProduct(UUID id, String name) throws Exception {
        updateProduct(id, name, -1, null);
    }

    public void updateProduct(UUID id, double price) throws Exception {
        updateProduct(id,"", price, null);
    }

    public void updateProduct(UUID id, Date expirationDate) throws Exception {
        updateProduct(id,"", -1, expirationDate);
    }

    public void updateProduct(UUID id, String name, double price) throws Exception {
        updateProduct(id,name, price, null);
    }

    public void updateProduct(UUID id, String name, Date expirationDate) throws Exception {
        updateProduct(id,name, -1, expirationDate);
    }

    public void updateProduct(UUID id, double price, Date expirationDate) throws Exception {
        updateProduct(id,"", price, expirationDate);
    }
}
