package org.hello.world.resource;


import org.hello.world.entity.Product;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/products")
public class ProductResource {

    @Inject
    EntityManager entityManager;
    //quarkus doesn't recommend privete in injected attributes
    //then reflection will be avoided for injection


    @GET
    @Produces(value = MediaType.APPLICATION_JSON)
    public List<Product> getProducts(){
        return entityManager.createQuery("select p from Product p", Product.class).getResultList();
    }
}
