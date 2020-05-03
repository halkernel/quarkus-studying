###### Post /products
`curl -XPOST -H "Content-type: application/json" -d '{"id":3,"name":"Emerson"}' 'http://0.0.0.0:8080/products/'`

###### Creating native-image

`./mvnw clean package -Dquarkus.profile=dev -Pnative`