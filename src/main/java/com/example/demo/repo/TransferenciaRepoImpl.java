package com.example.demo.repo;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.repo.modelo.Transferencia;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
@Repository
@Transactional
public class TransferenciaRepoImpl implements ITransferenciaRepo{

	@PersistenceContext
	private EntityManager entityManager;
	
	
	@Override
	public void insertarTransferencia(Transferencia transferencia) {
		// TODO Auto-generated method stub
		this.entityManager.persist(transferencia);
	}


	@Override
	public List<Transferencia> encontrarTodos() {
		TypedQuery<Transferencia>query=this.entityManager.createQuery("SELECT t FROM Transferencia t",Transferencia.class);
		
		
		return query.getResultList();
	}

}
