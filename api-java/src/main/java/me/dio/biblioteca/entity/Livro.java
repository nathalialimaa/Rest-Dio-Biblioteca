package me.dio.biblioteca.entity;

import jakarta.persistence.*;
import lombok.*;
import me.dio.biblioteca.enums.StatusLivro;
import java.time.LocalDate;
import lombok.Builder;
import lombok.Data;

@Data
@Entity(name = "tb_livro")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String titulo;

    @Column(nullable = false)
    private String autor;

    @Column(nullable = false)
    private String editora;

    @Column(nullable = false, unique = true)
    private Integer codigoBarras;

    @Column(name = "data_publicacao")
    private LocalDate dataPublicacao;

    @Column(name = "status", nullable = false)
    @Enumerated(EnumType.STRING)
    private StatusLivro status;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuarioEmprestimo;
}