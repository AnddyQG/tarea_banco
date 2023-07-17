package com.example.demo.repo;

import com.example.demo.repo.modelo.Propietario;

public interface IPropietarioRepo {

	public void insertar(Propietario propietario);
	public Propietario encontraCedula(String cedula);
}
