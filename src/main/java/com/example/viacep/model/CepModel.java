package com.example.viacep.model;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.lang.Nullable;

import javax.persistence.*;

@Getter
@Setter
@Entity(name = "cep")
@Table(name = "cep")
public class CepModel{
    @Id
    private String cep;
    private String logradouro;
    private String complemento;
    private String bairro;
    private String localidade;
    private String uf;
    private String ibge;
    private String gia;
    private String ddd;
    private String siafi;

    public CepModel(CepModel c) {
        this.cep = c.cep;
        this.logradouro = c.logradouro;
        this.complemento = c.complemento;
        this.bairro = c.bairro;
        this.localidade = c.localidade;
        this.uf = c.uf;
        this.ibge = c.ibge;
        this.gia = c.gia;
        this.ddd = c.ddd;
        this.siafi = c.siafi;
    }

    public CepModel() {

    }
}