package org.hello.world.resource;


import org.hello.world.entity.Product;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.LinkedList;
import java.util.List;

@Path("/products")
@Transactional
public class ProductsResource {

    @Inject
    EntityManager entityManager;
    //quarkus doesn't recommend privete in injected attributes
    //then reflection will be avoided for injection


    @GET
    @Produces(value = MediaType.APPLICATION_JSON)
    public List<Product> getProducts(){
        return entityManager.createQuery("select p from Product p", Product.class).getResultList();
    }

    @POST
    @Consumes(value = MediaType.APPLICATION_JSON)
    public void addProduct(Product p){
        entityManager.persist(p);
    }
}
