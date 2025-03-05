package org.iesbelen.videoclub.controller;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.iesbelen.videoclub.domain.Actor;
import org.iesbelen.videoclub.service.ActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/actores")
public class ActorController {

    @Autowired
    private ActorService actorService;

    @GetMapping({"","/"})
    public List<Actor> all() {
        log.info("Accediendo a todos los actores");
        return this.actorService.all();
    }

    @PostMapping({"","/"})
    public Actor newActor(@Valid @RequestBody Actor actor, BindingResult result) {
        return this.actorService.save(actor);
    }

    @GetMapping("/{id}")
    public Actor one(@PathVariable("id") Long id) {
        return this.actorService.one(id);
    }

    @GetMapping("/{id}/numPeliculas")
    public int getNumPeliculas(@PathVariable("id") Long id) {
        return this.actorService.one(id).getPeliculas().size();
    }

    @PutMapping("/{id}")
    public Actor replaceActor(@PathVariable("id") Long id, @RequestBody Actor actor) {
        return this.actorService.replace(id, actor);
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void deleteActor(@PathVariable("id") Long id) {
        this.actorService.delete(id);
    }
}
