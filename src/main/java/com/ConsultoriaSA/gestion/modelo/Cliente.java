package com.ConsultoriaSA.gestion.modelo;

import javax.persistence.*;
import javax.persistence.Entity;

import org.hibernate.annotations.*;
import org.openxava.annotations.*;

import lombok.*;

@Entity
@Getter @Setter
@View(name="Simple", members="nombre, direccion, email, telefono")
public class Cliente {
    
    @Id
    @GeneratedValue(generator="system-uuid")
    @Hidden
    @GenericGenerator(name="system-uuid", strategy="uuid")
    private String codigo;
    
    @Column(length=50)
    @Required
    private String nombre;
    
    @Column(length=100)
    private String direccion;
    
    @Column(length=50)
    private String email;
    
    @Column(length=20)
    private String telefono;
}
