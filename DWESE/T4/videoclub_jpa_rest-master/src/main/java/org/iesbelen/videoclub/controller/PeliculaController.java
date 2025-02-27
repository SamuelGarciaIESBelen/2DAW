package org.iesbelen.videoclub.controller;

import lombok.extern.slf4j.Slf4j;
import org.iesbelen.videoclub.domain.Pelicula;
import org.iesbelen.videoclub.service.CategoriaService;
import org.iesbelen.videoclub.service.PeliculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Slf4j
@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/peliculas")
public class PeliculaController {

    private final PeliculaService peliculaService;

    @Autowired
    private CategoriaService categoriaService;

    public PeliculaController(PeliculaService peliculaService) {
        this.peliculaService = peliculaService;
    }

    @GetMapping(value = {"","/"}, params = {"!buscar", "!ordenar", "!pagina", "!tamanio"})
    public List<Pelicula> all() {
        log.info("Accediendo a todas las películas");
        return this.peliculaService.all();
    }

    @GetMapping(value = {"/order"})
    public List<Pelicula> allOrdered() {
        log.info("Accediendo a todas las películas ordenadas");
        return this.peliculaService.findAllByOrderByTituloAsc();
    }

    @GetMapping(value = {"","/"}, params = {"!pagina", "!tamanio"})
    public List<Pelicula> all(@RequestParam("buscar") Optional<String> buscarOptional,
                              @RequestParam("ordenar") Optional<String> ordenarOptional) {
        log.info("Accediendo a todas las películas con filtro buscar: %s y ordenar: %s",
                buscarOptional.orElse(""),
                ordenarOptional.orElse(""));
        return this.peliculaService.findAllByQueryFilters(buscarOptional, ordenarOptional);
    }

    // Versión antigua
    /*@GetMapping(value = {"","/"}, params = {"!buscar", "!ordenar"})
    public ResponseEntity<Map<String, Object>> all(@RequestParam(value = "pagina", defaultValue = "0") int pagina,
                                                   @RequestParam(value = "tamanio", defaultValue = "3") int tamanio) {
        log.info("Accediendo a todas las películas con paginación");

        Map<String, Object> responseAll = this.peliculaService.all(pagina, tamanio);

        return ResponseEntity.ok(responseAll);
    }*/

    @GetMapping(value = {"", "/"}, params = {"!buscar", "!ordenar"})
    public ResponseEntity<Map<String, Object>> all(@RequestParam(value = "paginado", required = false) String[] paginado,
                                                   @RequestParam(value = "orden", required = false) String[] orden) {
        log.info("Accediendo a todas las películas con paginación y ordenación");

        int pagina = 0;
        int tamanio = 3;
        if (paginado != null && paginado.length == 2) {
            try {
                pagina = Integer.parseInt(paginado[0]);
                tamanio = Integer.parseInt(paginado[1]);
            } catch (NumberFormatException e) {
                return ResponseEntity.badRequest().body(Map.of("error", "Parámetros de paginación inválidos"));
            }
        }

        List<Sort.Order> ordenes = new ArrayList<>();
        if (orden != null) {
            for (String ordenStr : orden) {
                String[] partes = ordenStr.split(",");
                if (partes.length == 2) {
                    Sort.Direction direccion = "desc".equalsIgnoreCase(partes[1]) ? Sort.Direction.DESC : Sort.Direction.ASC;
                    ordenes.add(new Sort.Order(direccion, partes[0]));
                }
            }
        }

        Map<String, Object> responseAll = this.peliculaService.all(pagina, tamanio, ordenes);

        return ResponseEntity.ok(responseAll);
    }

    @PostMapping({"","/"})
    public Pelicula newPelicula(@RequestBody Pelicula pelicula) {
        return this.peliculaService.save(pelicula);
    }

    @GetMapping("/{id}")
    public Pelicula one(@PathVariable("id") Long id) {
        return this.peliculaService.one(id);
    }

    @PutMapping("/{id}")
    public Pelicula replacePelicula(@PathVariable("id") Long id, @RequestBody Pelicula pelicula) {
        return this.peliculaService.replace(id, pelicula);
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void deletePelicula(@PathVariable("id") Long id) {
        this.peliculaService.delete(id);
    }

    @PostMapping("/{id}/addCategoria/{id_categoria}")
    public Pelicula addCategoria(@PathVariable("id") Long id, @PathVariable("id_categoria") Long idCategoria) {
        return this.peliculaService.addCategoria(id, idCategoria);
    }

}
