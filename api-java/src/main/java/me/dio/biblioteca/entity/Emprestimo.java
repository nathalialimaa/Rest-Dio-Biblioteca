package me.dio.biblioteca.entity;

import jakarta.persistence.*;
import lombok.*;
import me.dio.biblioteca.enums.StatusEmprestimo;
import java.time.LocalDate;
import lombok.Builder;
import lombok.Data;

@Data 
@Entity(name = "tb_emprestimo")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Emprestimo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "livro_id", nullable = false)
    private Livro livro;

    @Column(name = "data_emprestimo", nullable = false)
    private LocalDate dataEmprestimo;

    @Column(name = "data_devolucao_prevista", nullable = false)
    private LocalDate dataDevolucaoPrevista;

    @Column(name = "data_devolucao_real")
    private LocalDate dataDevolucaoReal;

    @Column(name = "status", nullable = false)
    @Enumerated(EnumType.STRING)
    private StatusEmprestimo status;
}