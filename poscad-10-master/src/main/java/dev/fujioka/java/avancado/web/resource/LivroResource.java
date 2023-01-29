package dev.fujioka.java.avancado.web.resource;

import dev.fujioka.java.avancado.web.dto.LivroDTO;
import dev.fujioka.java.avancado.web.model.Livro;
import dev.fujioka.java.avancado.web.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/livro")
public class LivroResource {
    @Autowired
    private LivroService livroService;

    @PostMapping
    public ResponseEntity<LivroDTO> adicionar(@RequestBody Livro livro) {
        return ResponseEntity.ok(livroService.adicionar(livro));
    }

    @GetMapping
    public ResponseEntity<List<Livro>> getLivros() {
        return ResponseEntity.ok(livroService.listarLivros());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Livro> consultarPorId(@PathVariable int id) {
        return ResponseEntity.ok(livroService.consultarPorId(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Livro> deletarPorId(@PathVariable int id) {
        livroService.excluir(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Livro> alterarPorId(@RequestBody Livro livro) {
        return ResponseEntity.ok(livroService.alterar(livro));
    }
}
