package br.com.fiap.TwelveTools.model;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.hateoas.RepresentationModel;

@Entity
@Table(name="TB_FERRAMENTAS")
@SequenceGenerator(name = "ferramenta", sequenceName = "SQ_TB_FERRAMENTA",allocationSize = 1)
@NoArgsConstructor
@Setter
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getClassificacao() {
        return classificacao;
    }

    public void setClassificacao(String classificacao) {
        this.classificacao = classificacao;
    }

    public String getTamanho() {
        return tamanho;
    }

    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }
}
