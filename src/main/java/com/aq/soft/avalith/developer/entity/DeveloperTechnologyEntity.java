package com.aq.soft.avalith.developer.entity;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

/**
 * @author aquingaluisa
 * Entidad relacion de la tecnologia  con el usuario
 */
@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
@Entity
@Table(name = "developer_technology")
public class DeveloperTechnologyEntity extends SuperEntity {
    private static final long serialVersionUID = -2444889826395807531L;
    @Basic(optional = false)
    @NotNull
    @Column(name = "descripcion")
    private String descripcion;

    @Basic(optional = false)
    @Column(name = "id_developer", nullable = false)
    private Integer idDeveloper;

    @JoinColumn(name = "id_developer", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private DeveloperEntity developer;

}