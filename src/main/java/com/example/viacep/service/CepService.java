package com.example.viacep.service;
import com.example.viacep.model.CepModel;
import com.example.viacep.model.Retorno;
import com.example.viacep.repositorio.CepRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CepService {

    @Autowired
    CepRepo cepRepo;

    @Autowired
    DownloadViaCep download;


    public Map<String, Object> cep(String cep) {

        CepModel cepModel = new CepModel();

        Retorno mensagem = new Retorno();
        List<CepModel> listCepDB = cepRepo.localizar(arrumaCep(cep));
        List<CepModel> listViaCep = download.download(cep);

        String cepDB = "";
        String cepViaCep = "";

        //se existir no banco, verifico se os dados estao atualizados
        if (listCepDB.size() != 0) {
            //vou verificar todos os campos, e se tiver alteração, ja altera
            for (CepModel model : listCepDB) {
                if (model.getCep() == null) {
                    cepDB += "";
                } else {
                    cepDB += model.getCep();
                }
                if (model.getBairro() == null) {
                    cepDB += "";
                } else {
                    cepDB += model.getBairro();
                }
                if (model.getComplemento() == null) {
                    cepDB += "";
                } else {
                    cepDB += model.getComplemento();
                }
                if (model.getDdd() == null) {
                    cepDB += "";
                } else {
                    cepDB += model.getDdd();
                }
                if (model.getIbge() == null) {
                    cepDB += "";
                } else {
                    cepDB += model.getIbge();
                }
                if (model.getLocalidade() == null) {
                    cepDB += "";
                } else {
                    cepDB += model.getLocalidade();
                }
                if (model.getLogradouro() == null) {
                    cepDB += "";
                } else {
                    cepDB += model.getLogradouro();
                }
                if (model.getSiafi() == null) {
                    cepDB += "";
                } else {
                    cepDB += model.getSiafi();
                }
                if (model.getUf() == null) {
                    cepDB += "";
                } else {
                    cepDB += model.getUf();
                }
                if (model.getGia() == null) {
                    cepDB += "";
                } else {
                    cepDB += model.getGia();
                }

            }
            for (CepModel model : listViaCep) {
                if (model.getCep() == null) {
                    cepViaCep += "";
                } else {
                    cepViaCep += model.getCep();
                }
                if (model.getBairro() == null) {
                    cepViaCep += "";
                } else {
                    cepViaCep += model.getBairro();
                }
                if (model.getComplemento() == null) {
                    cepViaCep += "";
                } else {
                    cepViaCep += model.getComplemento();
                }
                if (model.getDdd() == null) {
                    cepViaCep += "";
                } else {
                    cepViaCep += model.getDdd();
                }
                if (model.getIbge() == null) {
                    cepViaCep += "";
                } else {
                    cepViaCep += model.getIbge();
                }
                if (model.getLocalidade() == null) {
                    cepViaCep += "";
                } else {
                    cepViaCep += model.getLocalidade();
                }
                if (model.getLogradouro() == null) {
                    cepViaCep += "";
                } else {
                    cepViaCep += model.getLogradouro();
                }
                if (model.getSiafi() == null) {
                    cepViaCep += "";
                } else {
                    cepViaCep += model.getSiafi();
                }
                if (model.getUf() == null) {
                    cepViaCep += "";
                } else {
                    cepViaCep += model.getUf();
                }
                if (model.getGia() == null) {
                    cepViaCep += "";
                } else {
                    cepViaCep += model.getGia();
                }
            }
            //se for diferente, ira fazer o UPDATE no BD
            if (!cepDB.equals(cepViaCep)) {
                System.out.println("NAO E IGUAL E IGUAL");
                for (CepModel model : listViaCep) {
                    cepRepo.save(model);
                    mensagem.setMensagem("Divergencia encontrada!, banco de dados atualizado");
                    cepModel = model;


                }
                //faz o SELECT dos dados
            } else {
                listCepDB = cepRepo.localizar(arrumaCep(cep));
                for (CepModel model : listCepDB) {
                    cepModel = model;
                }
                mensagem.setMensagem("nenhuma Divergencia localizada, Dados do banco estao iguais ao VIACEP");

            }
        }
        //caso nao existir, faz o INSERT

        else {

            for (CepModel model : listViaCep) {
                cepRepo.save(model);
                listCepDB = cepRepo.localizar(cep);
                mensagem.setMensagem("CEP nao encontrado no Banco de dados, Inserido com sucesso!");
                cepModel = model;

            }
        }


        Map<String, Object> mapFinal = new HashMap<>();
        mapFinal.put("msg", mensagem);
        mapFinal.put("inf", cepModel);
        return mapFinal;

    }
    public String arrumaCep(String cep){
        String cepconvertido = "";
        String primeiroParte ="";
        String segundoParte ="";

        if (cep.contains("-")){
            cepconvertido = cep;
        }
        else {
            primeiroParte = cep.substring(0,5);
            segundoParte = cep.substring(5,8);
             System.out.println(primeiroParte+"-"+segundoParte);
            cepconvertido =  primeiroParte+"-"+segundoParte;

        }

        return cepconvertido;
    }

}
