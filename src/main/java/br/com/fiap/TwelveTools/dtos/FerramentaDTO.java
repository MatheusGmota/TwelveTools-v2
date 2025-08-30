package br.com.fiap.TwelveTools.dtos;

import lombok.*;


@AllArgsConstructor(access = AccessLevel.PROTECTED)
@NoArgsConstructor
@Getter @Setter
public class FerramentaDTO {

    private @NonNull String nome;

    private @NonNull String tipo;

    private @NonNull String classificacao;

    private @NonNull String tamanho;

    private @NonNull Double preco;

    public @NonNull String getNome() {
        return nome;
    }

    public void setNome(@NonNull String nome) {
        this.nome = nome;
    }

    public @NonNull String getTipo() {
        return tipo;
    }

    public void setTipo(@NonNull String tipo) {
        this.tipo = tipo;
    }

    public @NonNull String getClassificacao() {
        return classificacao;
    }

    public void setClassificacao(@NonNull String classificacao) {
        this.classificacao = classificacao;
    }

    public @NonNull String getTamanho() {
        return tamanho;
    }

    public void setTamanho(@NonNull String tamanho) {
        this.tamanho = tamanho;
    }

    public @NonNull Double getPreco() {
        return preco;
    }

    public void setPreco(@NonNull Double preco) {
        this.preco = preco;
    }
}
