package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repo.IPropietarioRepo;
import com.example.demo.repo.modelo.Propietario;
@Service

public class PropietarioServiceImpl implements IPropietarioService{

	@Autowired
	private IPropietarioRepo iPropietarioRepo;
	
	@Override
	public void agregar(Propietario propietario) {
		// TODO Auto-generated method stub
		this.iPropietarioRepo.insertar(propietario);
	}

	@Override
	public Propietario buscarCedula(String cedula) {
		// TODO Auto-generated method stub
		return this.iPropietarioRepo.encontraCedula(cedula);
	}

}
