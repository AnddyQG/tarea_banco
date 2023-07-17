package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repo.ICuentaBancariaRepo;
import com.example.demo.repo.modelo.CuentaBancaria;
@Service
public class CuentaBancariaServiceImpl implements ICuentaBancariaService{

	@Autowired
	private ICuentaBancariaRepo bancariaRepo;
	
	@Override
	public void agregar(CuentaBancaria bancaria) {
		// TODO Auto-generated method stub
		this.bancariaRepo.insertar(bancaria);
	}

	@Override
	public CuentaBancaria buscarPorNumero(String numero) {
		// TODO Auto-generated method stub
		return this.bancariaRepo.encontrarPorNumero(numero);
	}

	@Override
	public void actualizar(CuentaBancaria bancaria) {
		// TODO Auto-generated method stub
		this.bancariaRepo.actualizar(bancaria);
	}

}
