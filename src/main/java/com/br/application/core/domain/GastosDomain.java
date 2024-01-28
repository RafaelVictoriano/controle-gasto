package com.br.application.core.domain;


import java.math.BigDecimal;


public class GastosDomain {

    private String id;


    private String nome;

    private BigDecimal valor;

    private Integer ano;

    private Integer mes;

    private Integer parcelaAtual;

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
