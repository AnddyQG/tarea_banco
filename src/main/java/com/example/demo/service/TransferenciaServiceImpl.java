package com.example.demo.service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repo.ICuentaBancariaRepo;
import com.example.demo.repo.ITransferenciaRepo;
import com.example.demo.repo.modelo.CuentaBancaria;
import com.example.demo.repo.modelo.Transferencia;
@Service
public class TransferenciaServiceImpl implements ITransferenciaService{

	@Autowired
	private ITransferenciaRepo iTransferenciaRepo;
	@Autowired
	private ICuentaBancariaRepo bancariaRepo;
	
	@Override
	public void realizarTransferencia(String numeroOrigen, String numeroDestino, BigDecimal montoT) {
		// TODO Auto-generated method stub
		CuentaBancaria bancariaO=this.bancariaRepo.encontrarPorNumero(numeroOrigen);
		CuentaBancaria bancariaD=this.bancariaRepo.encontrarPorNumero(numeroDestino);
		
		Transferencia transferencia= new Transferencia();
		transferencia.setFecha(LocalDate.now());
		transferencia.setMonto(montoT);
		transferencia.setCuentaBancariaO(bancariaO);
		transferencia.setCuentaBancariaD(bancariaD);
		
		if(bancariaO.getSaldo().compareTo(montoT)>=0) {
			
		bancariaO.setSaldo(bancariaO.getSaldo().subtract(montoT));
		this.bancariaRepo.actualizar(bancariaO);
		
		bancariaD.setSaldo(bancariaD.getSaldo().add(montoT));
		this.bancariaRepo.actualizar(bancariaD);
		
		this.iTransferenciaRepo.insertarTransferencia(transferencia);
		
			
			
		}else {
			System.out.println("NO SE PUEDE REALIZAR LA TRANSFERENCIA");
			System.out.println("SALDO INSUFICIENTE");
		}
		
		
	}

	@Override
	public List<Transferencia> buscarTodos() {
		// TODO Auto-generated method stub
		System.out.println("---REPORTE DE TRANSFERENCIAS-----");
		
		return this.iTransferenciaRepo.encontrarTodos();
	}

}
