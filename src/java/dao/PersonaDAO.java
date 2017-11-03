/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import hbm.HibernateUtil;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import pojo.Persona;
import pojo.TipoPersona;

/**
 *
 * @author RigoBono
 */
public class PersonaDAO {
    Session session;
    
    public PersonaDAO(){
        session=HibernateUtil.getLocalSession();
    }
    
    public  Persona getPersonaById(int id){
        return (Persona)session.load(Persona.class, id);
    }
    /**
     * Se llama a nuestra lista para poder obtener a nuestro elemento persona con el método 
     * getPersonaByName siempre que nuestro criterio de búsqueda coinsida.
     * @param nombre
     * @return 
     */
    public List<Persona>  getPersonaByName(String nombre){
        List<Persona> listaDePersonas=(List<Persona>)
                session.createCriteria(Persona.class)
                .add(Restrictions.eq("Nombre", nombre));
        return listaDePersonas;
    }
    /**
     * UpdateById nos permite atraer a un elemento de ntro de nuestra lista por el Id que se le ha determinado
     * y podemos actualizar o cambiar la información de nuestro elemento en la lista.
     * @param id
     * @param persona
     * @return 
     */
    public boolean updateById(int id,Persona persona){
        Persona personaAModificar=getPersonaById(id);
        try{
            Transaction transaccion=session.beginTransaction();
            personaAModificar.setNombre(persona.getNombre());
            session.update(personaAModificar);
            transaccion.commit();
            return true;
        }catch(Exception e){
            return false;
        }
    }
    /**
     * El método savePersona se va a encargar de capturar un nuevo registro de persona con cada uno de sus atribubtos.
     * El método transacción es el que se va a encargar de añadir el nuevo registro en la lista
     * 
     * @param nombre
     * @param materno
     * @param paterno
     * @param telefono
     * @param idTipoPersona
     * @return 
     */
    public boolean savePersona(String nombre,String materno,String paterno,String telefono,int idTipoPersona){
        Persona personaDeTanque=new Persona();
        TipoPersona tipoDeTanque=(TipoPersona)session.load(TipoPersona.class, idTipoPersona);
        personaDeTanque.setNombre(nombre);
        personaDeTanque.setMaterno(materno);
        personaDeTanque.setPaterno(paterno);
        personaDeTanque.setTelefono(telefono);
        personaDeTanque.setTipoPersona(tipoDeTanque);
        try{
            Transaction transaccion=session.beginTransaction();
            session.save(personaDeTanque);
            transaccion.commit();
            return true;
        }catch(Exception e){
            
        }finally{
            
        }
        return true;
    }
    
}
