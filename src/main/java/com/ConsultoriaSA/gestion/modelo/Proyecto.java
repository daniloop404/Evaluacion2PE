package com.ConsultoriaSA.gestion.modelo;

import java.util.*;

import javax.persistence.*;
import javax.persistence.CascadeType;
import javax.persistence.Entity;

import org.hibernate.annotations.*;
import org.openxava.annotations.*;

import lombok.*;

@Entity
@Getter @Setter
@View(members="nombre, descripcion, fechaInicio, fechaFin, estado; cliente; tareas")
public class Proyecto {
    
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
    private Date fechaInicio;
    
    private Date fechaFin;
    
    @Required
    @Enumerated(EnumType.STRING)
    private Estado estado;
    
    @ManyToOne(fetch=FetchType.LAZY)
    @Required
    private Cliente cliente;
    
    @OneToMany(mappedBy="proyecto", cascade=CascadeType.ALL)
    @ListProperties("nombre, descripcion, estado, registroTiempo.fecha, registroTiempo.horasTrabajadas")
    private Collection<Tarea> tareas;
}
