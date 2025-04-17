package me.dio.biblioteca.entity;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;
import lombok.Builder;
import lombok.Data;



@Entity
@Table(name = "tb_usuario")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @Column(unique = true, nullable = false)
    private String cpf;

}
