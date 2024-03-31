package Controller;

import Model.Product;
import Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public ResponseEntity<List<Product>> findAll(){
        List<Product> products = productService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(products);
    }


    @GetMapping("/{id}") // Definindo o endpoint para requisições GET para obter um produto por ID
    public ResponseEntity<Optional<Object>> findById(@PathVariable Long id){
        Optional<Product> product = productService.findById(id);
        if (product.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body(Optional.of(product));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Optional.ofNullable(null)); // Retornando 404 se o produto não for encontrado
        }
    }

    @PostMapping // Definindo o endpoint para requisições POST para criar um novo produto
    public ResponseEntity<Object> create(@RequestBody Product product){
        Product createdProduct = productService.save(product);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdProduct);
    }

    @PutMapping("/{id}") // Definindo o endpoint para requisições PUT para atualizar um produto existente por ID
    public ResponseEntity<Object> update(@PathVariable Long id, @RequestBody Product product){
        product.setId(id); // Definindo o ID do produto baseado no path da URL
        Product updatedProduct = productService.update(product);
        return ResponseEntity.status(HttpStatus.OK).body(updatedProduct);
    }

    @DeleteMapping("/{id}") // Definindo o endpoint para requisições DELETE para excluir um produto por ID
    public ResponseEntity<?> delete(@PathVariable Long id){
        productService.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}