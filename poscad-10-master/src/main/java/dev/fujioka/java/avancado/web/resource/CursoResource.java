package dev.fujioka.java.avancado.web.resource;

import dev.fujioka.java.avancado.web.dto.CursoDTO;
import dev.fujioka.java.avancado.web.model.Curso;
import dev.fujioka.java.avancado.web.service.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/curso")
public class CursoResource {
    @Autowired
    private CursoService cursoService;

    @PostMapping
    public ResponseEntity<CursoDTO> adicionar(@RequestBody Curso curso) {
        return ResponseEntity.ok(cursoService.adicionar(curso));
    }

    @GetMapping
    public ResponseEntity<List<Curso>> getCursos() {
        return ResponseEntity.ok(cursoService.listarCursos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Curso> consultarPorId(@PathVariable int id) {
        return ResponseEntity.ok(cursoService.consultarPorId(id));
    }

    @GetMapping("/area/{area}")
    public ResponseEntity<List<Curso>> consultarPorArea(@PathVariable String area) {
        return ResponseEntity.ok(cursoService.consultarPorArea(area));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Curso> deletarPorId(@PathVariable int id) {
        cursoService.excluir(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Curso> alterarPorId(@RequestBody Curso curso) {
        return ResponseEntity.ok(cursoService.alterar(curso));
    }
}
