package ru.geekbrains.SB4.servise;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import ru.geekbrains.SB4.model.Product;
import ru.geekbrains.SB4.repositories.IProductRepo;

import java.util.List;

@Service
public class ProductService {

    IProductRepo productRepo;
    List<Product> products;


    @Autowired
    public void setProductRepo(IProductRepo productRepo) {
        this.productRepo = productRepo;
        products = productRepo.getProducts();
    }

    public IProductRepo getProductRepo() {
        return productRepo;
    }

    public double averageCost (){
        int quantity = 0;
        int sum = 0;
        quantity = products.size();
        for (Product p: products ) {
            sum += p.getCost();
        }
        System.out.println("averageCost = " + sum/quantity);
        return sum/quantity;
    }

    public int quantityGoods (){
        System.out.println("quantityGoods " + products.size());
        return products.size();
    }



}