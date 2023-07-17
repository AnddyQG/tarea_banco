package com.example.demo.repo;

import com.example.demo.repo.modelo.CuentaBancaria;

public interface ICuentaBancariaRepo {

	public void insertar(CuentaBancaria bancaria);
	public CuentaBancaria encontrarPorNumero(String numero);
	public void actualizar(CuentaBancaria bancaria);
	
}
