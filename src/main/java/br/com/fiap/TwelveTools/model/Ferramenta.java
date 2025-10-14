package br.com.fiap.TwelveTools.model;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.hateoas.RepresentationModel;

@Entity
@Table(name="TB_FERRAMENTAS")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SequenceGenerator(name = "ferramenta", sequenceName = "SQ_TB_FERRAMENTA",allocationSize = 1)
public class Ferramenta extends RepresentationModel<Ferramenta> {

    @Id
    @Column(name = "id_ferramenta")
    @GeneratedValue(generator = "ferramenta", strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column
    private String nome;

    @Column
    private String tipo;

    @Column
    private String classificacao;

    @Column
    private String tamanho;

    @Column
    private Double preco;

}
