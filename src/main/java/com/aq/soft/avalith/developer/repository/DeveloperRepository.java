package com.aq.soft.avalith.developer.repository;

import com.aq.soft.avalith.developer.entity.DeveloperEntity;
import com.aq.soft.avalith.developer.util.ConstantesUtil;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author aquingaluisa
 * Repositorio para consultas de la tabla Developer
 */
@Repository
public interface DeveloperRepository extends JpaRepository<DeveloperEntity, Integer> {
    /**
     * Retorna todos los regiustros developer con estado activo
     *
     * @return
     */
    @Query("select d from DeveloperEntity d " +
            "left  join  fetch  d.developerTechnology dt" +
            " where  d.estado=" + ConstantesUtil.ESTADO_ACTIVO)
    List<DeveloperEntity> findAll();
}
