package org.iesbelen.examensgz.service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.iesbelen.examensgz.domain.Product;
import org.iesbelen.examensgz.repository.ProductRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final EntityManager em;

    public ProductService(ProductRepository productRepository, EntityManager em) {
        this.productRepository = productRepository;
        this.em = em;
    }

    public List<Product> all() {
        return productRepository.findAll();
    }

    public Product add(Product product) {
        return productRepository.save(product);
    }

    public Product find(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    public Product update(Long id, Product product) {
        return this.productRepository.findById(id).filter(p -> id.equals(product.getId())).map(p ->
                this.productRepository.save(product)).orElse(null);
    }

    public void delete(long id) {
        this.productRepository.findById(id).map(p -> {
            this.productRepository.delete(p);
            return p;
        });
    }

    public List<Product> allFiltered(String[] buscar) {
        Query query = em.createQuery("SELECT p FROM Product p " + "WHERE :campo like :valor");

        // No entiendo por qué no funciona, creo que es por poner solo :campo en vez de p.campo
        // pero no sé como ponerlo al ser una variable

        query.setParameter("campo", buscar[0]);
        if (!"product_id".equals(buscar[0]) && !"descrip".equals(buscar[0]) && !"image_url".equals(buscar[0]) &&
                !"name".equals(buscar[0]) && !"price".equals(buscar[0]) && !"quantity".equals(buscar[0]) && !"category_id".equals(buscar[0])) {
            query.setParameter("campo", "name");
        }
        query.setParameter("valor", "%" + buscar[1] + "%");

        return query.getResultList();
    }


    public Map<String, Object> allPaginado(int pagina, int tamano) {
        Pageable paginado = PageRequest.of(pagina, tamano, Sort.by("id").ascending());

        Page<Product> pageAll = this.productRepository.findAll(paginado);

        Map<String, Object> response = new HashMap<>();

        response.put("products", pageAll.getContent());
        response.put("currentPage", pageAll.getNumber());
        response.put("totalItems", pageAll.getTotalElements());
        response.put("totalPages", pageAll.getTotalPages());

        return response;
    }

    public List<Product> allOrdered(String[] ordenar) {
        Sort sort = null;

        String col;
        if ("price".equalsIgnoreCase(ordenar[0])) {
            col = "price";
        } else if ("name".equalsIgnoreCase(ordenar[0])) {
            col = "name";
        } else {
            col = "name";
        }

        if (ordenar.length == 1) {
            sort = Sort.by(col).ascending();
        }
        if ("asc".equalsIgnoreCase(ordenar[1])) {
            sort = Sort.by(col).ascending();
        } else if ("desc".equalsIgnoreCase(ordenar[1])) {
            sort = Sort.by(col).descending();
        } else {
            sort = Sort.by(col).ascending();
        }

        return productRepository.findAll(sort);
    }
}
