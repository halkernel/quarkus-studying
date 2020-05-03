package org.hello.world.service;

import org.eclipse.microprofile.opentracing.Traced;
import org.hello.world.entity.Product;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
@Traced
public class ProductService {

    @Inject
    EntityManager entityManager;

    public List<Product> getProducts(){
        return entityManager.createQuery("select p from Product p", Product.class).getResultList();
    }

    public void addProduct(Product p){
        entityManager.persist(p);
    }
}
