package com.uniamerica.lembretes.DTO;
import com.uniamerica.lembretes.entity.Pessoa;
public class LembreteDTO {
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRecado() {
        return recado;
    }

    public void setRecado(String recado) {
        this.recado = recado;
    }

    public Pessoa getPessoa_id() {
        return pessoa_id;
    }

    public void setPessoa_id(Pessoa pessoa_id) {
        this.pessoa_id = pessoa_id;
    }

    private String recado;
    private Pessoa pessoa_id;
}
