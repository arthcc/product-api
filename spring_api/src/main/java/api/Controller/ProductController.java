package api.Controller;

import api.Model.Product;
import api.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    @ResponseStatus(HttpStatus.FOUND)
    public List<Product> findAll(){
        return productService.findAll();
    }

    // Definindo o endpoint para requisições GET para obter um produto por ID
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Product findById(@PathVariable Long id){
        return productService.findById(id);
    }

    @PostMapping // Definindo o endpoint para requisições POST para criar um novo produto
    @ResponseStatus(HttpStatus.CREATED)
    public Product create(@RequestBody Product product){
        return productService.save(product);
    }

    @PutMapping("/{id}") // Definindo o endpoint para requisições PUT para atualizar um produto existente por ID
    @ResponseStatus(HttpStatus.OK)
    public Product update(@PathVariable Long id, @RequestBody Product product){
        return productService.update(id, product);
    }

    @DeleteMapping("/{id}") // Definindo o endpoint para requisições DELETE para excluir um produto por ID
    public void delete(@PathVariable Long id){
        productService.deleteById(id);
    }
}