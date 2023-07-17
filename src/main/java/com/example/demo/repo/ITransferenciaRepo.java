package com.example.demo.repo;

import java.util.List;

import com.example.demo.repo.modelo.Transferencia;

public interface ITransferenciaRepo {

	public void insertarTransferencia(Transferencia transferencia);
	
	public List<Transferencia> encontrarTodos();
	
}
