package com.example.demo.service;

import java.math.BigDecimal;
import java.util.List;

import com.example.demo.repo.modelo.Transferencia;



public interface ITransferenciaService {

	public void realizarTransferencia(String numeroOrigen, String numeroDestino,BigDecimal montoT);

	public List<Transferencia> buscarTodos();
}
