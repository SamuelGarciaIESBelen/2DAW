package org.iesbelen.examensgz.controller;

import lombok.extern.slf4j.Slf4j;
import org.iesbelen.examensgz.domain.Product;
import org.iesbelen.examensgz.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) { this.productService = productService; }

    @GetMapping(value = {"", "/"}, params = {"!pagina", "!tamano", "!ordenar", "!buscar"})
    public List<Product> all() { return this.productService.all(); }

    @GetMapping(value = {"", "/"}, params = {"!pagina", "!tamano", "!ordenar"})
    public List<Product> allFiltered(@RequestParam(name = "buscar") String[] buscar) {
        return this.productService.allFiltered(buscar);
    }

    @GetMapping(value = {"", "/"}, params = {"!ordenar", "!buscar"})
    public ResponseEntity<Map<String, Object>> allPaginado(@RequestParam(name = "pagina", defaultValue = "0") int pagina,
                                                   @RequestParam(name = "tamano", defaultValue = "1") int tamano) {

        Map<String, Object> responseAll = this.productService.allPaginado(pagina, tamano);
        return ResponseEntity.ok(responseAll);
    }

    @GetMapping(value = {"", "/"}, params = {"!pagina", "!tamano", "!buscar"})
    public ResponseEntity<List<Product>> allOrdered(@RequestParam(name = "ordenar") String[] ordenar) {
        List<Product> productos = this.productService.allOrdered(ordenar);

        return ResponseEntity.ok(productos);
    }

    @PostMapping({"", "/"})
    public Product add(@RequestBody Product product) { return this.productService.add(product); }

    @GetMapping("/{id}")
    public Product find(@PathVariable("id") Long id) {
        return this.productService.find(id);
    }

    @PutMapping("/{id}")
    public Product update(@PathVariable("id") Long id, @RequestBody Product product) {
        return this.productService.update(id, product);
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable("id") Long id) {
        this.productService.delete(id);
    }
}
