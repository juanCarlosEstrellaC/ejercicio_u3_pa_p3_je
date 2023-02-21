package com.example.demo.repository;

import com.example.demo.modelo.Factura;

public interface IFacturaRepository {

	public void realizarFactura(Factura factura);
	public Factura buscarPorNumero(Integer numero);

}
