package com.example.viacep.repositorio;

import com.example.viacep.model.CepModel;
import com.sun.istack.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface CepRepo extends JpaRepository<CepModel, String> {

    @Query(value = "SELECT * FROM cep WHERE cep = :cep", nativeQuery = true)
    List<CepModel> localizar(@Param("cep") String cep);


}
