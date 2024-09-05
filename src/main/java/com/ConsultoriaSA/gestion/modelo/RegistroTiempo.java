package com.ConsultoriaSA.gestion.modelo;

import java.util.*;

import javax.persistence.*;

import org.openxava.annotations.*;

import lombok.*;


@Embeddable
@Getter @Setter
public class RegistroTiempo {
    
    @Required
    private Date fecha;
    
    @Required
    private int horasTrabajadas;
}