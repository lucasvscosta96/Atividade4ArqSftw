package br.usjt.arqsw.dao;

import java.io.IOException;
import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.usjt.arqsw.entity.Fila;
/**
 * 
 * @author asbonato
 *
 */
@Repository
public class FilaDAO {

	@PersistenceContext
	EntityManager  manager;

	
	public FilaDAO(EntityManager manager)  {
		this.manager = manager;
	}
	/**
	 * 
	 * @return
	 * @throws IOException
	 */
	@SuppressWarnings("unchecked")
	public ArrayList<Fila> listarFilas() throws IOException {
		
		return (ArrayList<Fila>) manager.createQuery("select id_fila, nm_fila from fila").getResultList();
	}
	
	/**
	 * 
	 * @param id
	 * @return
	 * @throws IOException
	 */
	public Fila carregar(int id) {
		
		return manager.find(Fila.class, "select nm_fila from fila where id_fila=?");

	}

}
