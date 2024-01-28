package com.br.adapters.inbound.entity;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.math.BigDecimal;


@Document(collection = "gastos")
public class Gastos {

    @Id
    private String id;

    @Field(name = "nome")
    private String nome;

    @Field(name = "valor")
    private BigDecimal valor;

    @Field(name = "ano")
    private Integer ano;

    @Field(name = "mes")
    private  Integer mes;

    @Field(name = "parcelaAtual")
    private Integer parcelaAtual;

    @Field(name = "parcelaFinal")
    private Integer parcelaFinal;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public Integer getAno() {
        return ano;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }

    public Integer getMes() {
        return mes;
    }

    public void setMes(Integer mes) {
        this.mes = mes;
    }

    public void setParcelaAtual(Integer parcelaAtual) {
        this.parcelaAtual = parcelaAtual;
    }

    public void setParcelaFinal(Integer parcelaFinal) {
        this.parcelaFinal = parcelaFinal;
    }

    public Integer getParcelaAtual() {
        return parcelaAtual;
    }

    public Integer getParcelaFinal() {
        return parcelaFinal;
    }
}