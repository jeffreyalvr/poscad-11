package dev.fujioka.java.avancado.web.repository;

import dev.fujioka.java.avancado.web.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Integer> {
    @Query("select l from Livro l order by l.nome ASC")
    public List<Livro> listarOrdenadoPorNome();

    public List<Livro> findAllByOrderByNomeAsc();

    @Query("select l from Livro l where l.nome like %:nome%")
    public List<Livro> buscarLivroPorNomeLike(@Param("nome") String nome);

    @Query("select l from Livro l where l.genero like %:genero%")
    public List<Livro> buscarLivroPorGeneroLike(@Param("genero") String genero);

    public Livro findByGeneroAndNome(String genero, String nome);
}
