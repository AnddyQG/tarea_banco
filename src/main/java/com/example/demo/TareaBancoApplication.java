package com.example.demo;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.repo.modelo.CuentaBancaria;
import com.example.demo.repo.modelo.Propietario;
import com.example.demo.repo.modelo.Transferencia;
import com.example.demo.service.ICuentaBancariaService;
import com.example.demo.service.IPropietarioService;
import com.example.demo.service.ITransferenciaService;

@SpringBootApplication
public class TareaBancoApplication implements CommandLineRunner{

	@Autowired
	private IPropietarioService iPropietarioService;
	
	@Autowired
	private ICuentaBancariaService bancariaService;
	
	@Autowired
	private ITransferenciaService iTransferenciaService;
	
	public static void main(String[] args) {
		SpringApplication.run(TareaBancoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
	
		//1. Guardar Cta Bancaria
		
		Propietario propietario=new Propietario();
		propietario.setNombre("Anddy");
		propietario.setApellido("Quisilema");
		propietario.setCedula("1721");
		this.iPropietarioService.agregar(propietario);
		
	Propietario propietarioO	= this.iPropietarioService.buscarCedula("1721");
	
	CuentaBancaria bancaria= new CuentaBancaria();
	bancaria.setNumero("123");
	bancaria.setPropietario(propietarioO);
	bancaria.setSaldo(new BigDecimal(5000));
	bancaria.setTipo("A");
	this.bancariaService.agregar(bancaria);
		
		
	Propietario propietario2=new Propietario();
		propietario2.setNombre("Mirian");
		propietario2.setApellido("Guacollante");
		propietario2.setCedula("1711");
		this.iPropietarioService.agregar(propietario2);
		
	Propietario propietarioO2	= this.iPropietarioService.buscarCedula("1711");	
	CuentaBancaria bancaria2= new CuentaBancaria();
	bancaria2.setNumero("456");
	bancaria2.setPropietario(propietarioO2);
	bancaria2.setSaldo(new BigDecimal(1000));
	bancaria2.setTipo("A");
	this.bancariaService.agregar(bancaria2);
	
	
		
		this.iTransferenciaService.realizarTransferencia("123", "456", new BigDecimal(200));
		
		
		this.iTransferenciaService.buscarTodos().stream().forEach(System.out::println);;
		
	}

}
