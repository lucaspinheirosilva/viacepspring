package com.example.viacep.model;

public class EnderecoLink {
    final String linkViacep = "https://viacep.com.br/ws/";

    public String link(String cep) {
        return linkViacep + cep + "/json";
    }


}
