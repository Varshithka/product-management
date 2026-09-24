package ProductMangement.controller;



import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import ProductMangement.entity.Product;
import ProductMangement.service.ProductService;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;

    // Constructor Injection
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    // CREATE PRODUCT
    @PostMapping
    public ResponseEntity<Product> addProduct(@RequestBody Product product) {

        Product savedProduct = productService.addProduct(product);

        return new ResponseEntity<>(savedProduct, HttpStatus.CREATED);
    }

    // GET ALL PRODUCTS
    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() {

        List<Product> products = productService.getAllProducts();

        return ResponseEntity.ok(products);
    }

    // GET PRODUCT BY ID
    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id) {

        return productService.getProductById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // UPDATE PRODUCT
    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(
            @PathVariable Long id,
            @RequestBody Product product) {

        Product updatedProduct = productService.updateProduct(id, product);

        return ResponseEntity.ok(updatedProduct);
    }

    // DELETE PRODUCT
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable Long id) {

        productService.deleteProduct(id);

        return ResponseEntity.ok("Product deleted successfully");
    }
}
