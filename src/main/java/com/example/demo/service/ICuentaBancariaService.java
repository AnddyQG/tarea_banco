package com.example.demo.service;

import com.example.demo.repo.modelo.CuentaBancaria;

public interface ICuentaBancariaService {

	public void agregar(CuentaBancaria bancaria);
	public CuentaBancaria buscarPorNumero(String numero);
	public void actualizar(CuentaBancaria bancaria);
	
}
