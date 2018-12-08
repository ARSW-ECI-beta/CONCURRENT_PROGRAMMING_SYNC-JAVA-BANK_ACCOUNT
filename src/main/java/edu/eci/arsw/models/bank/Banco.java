package edu.eci.arsw.models.bank;

import java.util.ArrayList;
import java.util.List;

public class Banco {
	/**
	 * Cantidad de dinero en caja del banco.
	 */
	private int enCaja;
	
	/**
	 * Lista de cuentas activas.
	 */
	private List <Cuenta> cuentas = new ArrayList <Cuenta> ();
	
	/**
	 * Crea un banco con saldo inicial en caja
	 * @param init
	 */
	public Banco(int initCaja) {
		enCaja = initCaja;
	}
	
	/**
	 * Agrega una cuenta al banco
	 * @param cuenta
	 */
	public void abrirCuenta(Cuenta cuenta){

			cuentas.add(cuenta);
			enCaja += cuenta.getSaldo();			

	}
	
	/**
	 * Cierra una cuenta (la retira del banco) y decrementa el dinero
	 * en caja del banco.
	 * @param cuenta
	 */
	public void cerrarCuenta(Cuenta cuenta){

			cuentas.remove(cuenta);
			retiro(cuenta.getSaldo());

	}

		
	/**
	 * Decrementa el dinero en caja
	 * @param cantidad
	 */
	protected void retiro(int cantidad) {
		enCaja-=cantidad;
	}
	
	/**
	 * Incrementa el dinero en caja del banco.
	 * @param cantidad
	 */
	protected void consignacion(int cantidad){
		enCaja += cantidad;
	}
	
	
	public int getTotalEnCaja(){
		return enCaja;
	}
	
}
