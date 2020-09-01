package com.aq.soft.avalith.developer.servicio;

import com.aq.soft.avalith.developer.entity.DeveloperEntity;
import com.aq.soft.avalith.developer.repository.DeveloperRepository;
import com.aq.soft.avalith.developer.repository.DeveloperTechnologyRepository;
import com.aq.soft.avalith.developer.util.ConstantesUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Servicio para las transacciones de Developer
 */
@Service
public class DeveloperService {

    @Autowired
    private DeveloperRepository developerRepository;

    @Autowired
    private DeveloperTechnologyRepository developerTechnologyRepository;

    /**
     * Retorna lista de desarrolladores activos
     *
     * @return
     */
    public List<DeveloperEntity> findAllDeveloperList() {
        return this.developerRepository.findAll();
    }


    /**
     * Almacena un nuevo developer
     *
     * @return
     */
    @Transactional
    public DeveloperEntity save(DeveloperEntity developerEntity) {
        //nuevo
        if (developerEntity.getId() != null) {
            this.developerTechnologyRepository.deleteDeveloperTechnologyEntitiesByDeveloper(developerEntity.getId());
        }
        developerEntity.setEstado(ConstantesUtil.ESTADO_ACTIVO);
        this.developerRepository.saveAndFlush(developerEntity);
        developerEntity.getDeveloperTechnology().forEach(x -> {
            x.setEstado(ConstantesUtil.ESTADO_ACTIVO);
            x.setIdDeveloper(developerEntity.getId());
            this.developerTechnologyRepository.saveAndFlush(x);
        });

        return this.developerRepository.saveAndFlush(developerEntity);
    }

    /**
     * ELiminar un developer logicamente
     *
     * @param idDeveloper
     * @return
     */
    @Transactional
    public DeveloperEntity delete(Integer idDeveloper) {
        DeveloperEntity developerEntity = this.developerRepository.findById(idDeveloper).orElse(null);
        developerEntity.setEstado(ConstantesUtil.ESTADO_INACTIVO);
        return this.save(developerEntity);
    }
}
