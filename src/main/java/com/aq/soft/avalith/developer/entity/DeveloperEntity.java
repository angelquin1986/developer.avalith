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
 * Entidad developer
 */
@Data
@Entity
@AllArgsConstructor
@Builder
@NoArgsConstructor
@Table(name = "developer")
public class DeveloperEntity extends SuperEntity {
    private static final long serialVersionUID = -2007868527746646009L;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nombres_completos")
    private String nombreCompletos;

    @Basic(optional = false)
    @NotNull
    @Column(name = "link_github")
    private String linkGitHub;

    @Basic(optional = false)
    @NotNull
    @Column(name = "tecnologias_conocidas")
    private String developerTechnology;


}