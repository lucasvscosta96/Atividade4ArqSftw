package br.usjt.arqsw.dao;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.usjt.arqsw.entity.Chamado;
import br.usjt.arqsw.entity.Fila;

@Repository
public class ChamadoDAO {

	@PersistenceContext
	EntityManager manager;

	
	public ChamadoDAO (EntityManager manager) {
		this.manager = manager;
	}

	@SuppressWarnings("unchecked")
	public ArrayList<Chamado> listarChamados(Fila fila) {
		return (ArrayList<Chamado>) manager.createQuery("select * from chamado where c.fila.id = :id_fila").getResultList();
		
	}

}
