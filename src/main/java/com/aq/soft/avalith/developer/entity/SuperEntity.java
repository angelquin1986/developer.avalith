package com.aq.soft.avalith.developer.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author aquingaluisa
 * Clase abstracta para  las entidades
 */
@Data
@MappedSuperclass
public abstract class SuperEntity implements Serializable {
    private static final long serialVersionUID = -7446603921108618349L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;

    @Basic(optional = false)
    @Column(name = "estado", nullable = false)
    private int estado;

}
