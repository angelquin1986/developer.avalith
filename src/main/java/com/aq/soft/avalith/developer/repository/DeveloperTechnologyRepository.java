package com.aq.soft.avalith.developer.repository;

import com.aq.soft.avalith.developer.entity.DeveloperEntity;
import com.aq.soft.avalith.developer.entity.DeveloperTechnologyEntity;
import com.aq.soft.avalith.developer.util.ConstantesUtil;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @author aquingaluisa
 * Repositorio para consultas de la tabla DeveloperTechnology
 */
public interface DeveloperTechnologyRepository extends JpaRepository<DeveloperTechnologyEntity, Integer> {

    @Modifying
    @Query("update DeveloperTechnologyEntity dt set dt.estado=" + ConstantesUtil.ESTADO_INACTIVO + " where dt.idDeveloper = :idDeveloper")
    void deleteDeveloperTechnologyEntitiesByDeveloper(@Param("idDeveloper") long idDeveloper);


}
