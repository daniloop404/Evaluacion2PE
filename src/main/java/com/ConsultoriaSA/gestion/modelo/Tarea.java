package com.ConsultoriaSA.gestion.modelo;

import javax.persistence.*;
import javax.persistence.Entity;

import org.hibernate.annotations.*;
import org.openxava.annotations.*;

import lombok.*;

@Entity
@Getter @Setter
public class Tarea {
    
    @Id
    @GeneratedValue(generator="system-uuid")
    @Hidden
    @GenericGenerator(name="system-uuid", strategy="uuid")
    private String codigo;
    
    @Column(length=100)
    @Required
    private String nombre;
    
    @Column(length=500)
    @Stereotype("MEMO")
    private String descripcion;
    
    @Required
    @Enumerated(EnumType.STRING)
    private Estado estado;
    
    @ManyToOne(fetch=FetchType.LAZY)
    @Required
    private Proyecto proyecto;
    
    @Embedded
    @Required
    private RegistroTiempo registroTiempo;
}