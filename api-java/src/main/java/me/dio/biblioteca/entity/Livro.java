package me.dio.biblioteca.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;
import lombok.Builder;
import lombok.Data;

@Entity
@Table(name = "tb_livro")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;

    private String autor;

}
