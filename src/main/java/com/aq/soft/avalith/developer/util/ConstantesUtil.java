package com.aq.soft.avalith.developer.util;

import com.aq.soft.avalith.developer.dto.DeveloperDTO;
import com.aq.soft.avalith.developer.entity.DeveloperEntity;

/**
 * @author aquingaluisa
 * <p>
 * Clase para manejo de constantes
 */
public class ConstantesUtil {
    public static final int ESTADO_ACTIVO = 1;
    public static final int ESTADO_INACTIVO = 0;
    private static final ConstantesUtil INSTANCE = new ConstantesUtil();

    /**
     * obtener la instancia de la clase
     *
     * @return
     */
    public static ConstantesUtil getInstance() {
        return INSTANCE;
    }

    /**
     * Armar el objeto developer
     *
     * @return
     */
    public DeveloperEntity armarObjetoDeveloper(DeveloperDTO developerDTO, Integer id) {
        //crear el objeto principal
        DeveloperEntity developerEntity = DeveloperEntity.builder()
                .nombreCompletos(developerDTO.getNombres_completos())
                .linkGitHub(developerDTO.getLink_github()).build();
        developerEntity.setId(id);
        //crear los detalles
        developerEntity.setDeveloperTechnology(String.join(",", developerDTO.getTecnologias_conocidas()));
        return developerEntity;
    }
}