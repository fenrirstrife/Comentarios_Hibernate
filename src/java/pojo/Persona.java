/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author RigoBono
 * @Entity es un objeto persistente de peso ligero que generalmente se refiere a una tabla en un sistema de base de datos.
 */

@Entity
@Table(name="Persona",catalog="generationHibernate")
public class Persona {
    /**
     * La etiqueta @Id hace referencia a la Primary Key dentro del documento.
     * @GeneratedValue hace referencia a la propiedad de auto-incrementar un elemento.
     * @Column es la comlumna dentro de nues@GeneratedValue hace referencia a la propiedad de auto-incrementar un elementotra tabla.
     * nullable, dependiendo si su valor es true o false, puede permitir o no que un espacio esté vacío.
     */
    @Id @GeneratedValue
    @Column(name="idPersona")
    private int idPersona;
    /**
     * Cada columna que está acontinuación representa un atributo en nuestra tabla.
     */
    @Column(name="Nombre",nullable=true)
    private String Nombre;
    
    @Column(name="Paterno")
    private String Paterno;
    
     @Column(name="Materno")
    private String Materno;
     
     @Column(name="Telefono")
    private String Telefono;
    
     
     /**
      * @ManyToOne es una etiqueta que representa una relación de muchos elementos hacia uno solo.
      */
     @ManyToOne
     @JoinColumn(name="idTipoPersona")
    private TipoPersona tipoPersona;

    /**
     * @return the idPersona
     */
    public int getIdPersona() {
        return idPersona;
    }

    /**
     * @param idPersona the idPersona to set
     */
    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }

    /**
     * @return the Nombre
     */
    public String getNombre() {
        return Nombre;
    }

    /**
     * @param Nombre the Nombre to set
     */
    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    /**
     * @return the Paterno
     */
    public String getPaterno() {
        return Paterno;
    }

    /**
     * @param Paterno the Paterno to set
     */
    public void setPaterno(String Paterno) {
        this.Paterno = Paterno;
    }

    /**
     * @return the Materno
     */
    public String getMaterno() {
        return Materno;
    }

    /**
     * @param Materno the Materno to set
     */
    public void setMaterno(String Materno) {
        this.Materno = Materno;
    }

    /**
     * @return the Telefono
     */
    public String getTelefono() {
        return Telefono;
    }

    /**
     * @param Telefono the Telefono to set
     */
    public void setTelefono(String Telefono) {
        this.Telefono = Telefono;
    }

    /**
     * @return the tipoPersona
     */
    public TipoPersona getTipoPersona() {
        return tipoPersona;
    }

    /**
     * @param tipoPersona the tipoPersona to set
     */
    public void setTipoPersona(TipoPersona tipoPersona) {
        this.tipoPersona = tipoPersona;
    }
     
     
    
}
