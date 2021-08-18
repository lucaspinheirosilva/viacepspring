package com.example.viacep.service;
import com.example.viacep.model.CepModel;
import com.example.viacep.model.EnderecoLink;
import org.json.JSONObject;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@Service
public class DownloadViaCep {

    public List<CepModel> download(String cep) {

        EnderecoLink enderecoLink = new EnderecoLink();
        List<CepModel> listViaCep = new ArrayList<>();


        //Pego os dados atualizados e comparo com o que esta no banco de dados
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        //headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<CepModel> entity = new HttpEntity(headers);
        URI uri = null;
        try {
            uri = new URI(enderecoLink.link(cep));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        try {

            //pega a resposta e transporma em ResponseEntity<String>
            assert uri != null;
            ResponseEntity<String> response = restTemplate.exchange(uri, HttpMethod.GET, entity, String.class);

            //Mapeia o JSON e guarda as informaçoes nas variavies
            JSONObject object = new JSONObject(response.getBody());
            //JSONArray array = object.getJSONArray();

            for (int i = 0; i < 1; i++) {
                CepModel cepModel = new CepModel();

                cepModel.setCep(object.get("cep").toString());
                cepModel.setLogradouro(object.get("logradouro").toString());
                cepModel.setComplemento(object.get("complemento").toString());
                cepModel.setBairro(object.get("bairro").toString());
                cepModel.setLocalidade(object.get("localidade").toString());
                cepModel.setUf(object.get("uf").toString());
                cepModel.setIbge(object.get("ibge").toString());
                cepModel.setGia(object.get("gia").toString());
                cepModel.setDdd(object.get("ddd").toString());
                cepModel.setSiafi(object.get("siafi").toString());

                listViaCep.add(cepModel);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return listViaCep;
    }

}
