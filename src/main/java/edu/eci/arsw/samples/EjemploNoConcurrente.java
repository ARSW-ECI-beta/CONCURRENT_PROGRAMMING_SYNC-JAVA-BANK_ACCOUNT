package edu.eci.arsw.samples;

import edu.eci.arsw.models.bank.Banco;
import edu.eci.arsw.models.bank.Cuenta;


public class EjemploNoConcurrente {

	public static void main(String[] args) {
		Banco bnc=new Banco(10000);
		Cuenta c=new Cuenta(10000, bnc);
		Cuenta c2=new Cuenta(5000, bnc);
		Cuenta c3=new Cuenta(3000, bnc);
		
		bnc.abrirCuenta(c);
		bnc.abrirCuenta(c2);
		bnc.abrirCuenta(c3);
		
		System.out.println("Saldo:"+bnc.getTotalEnCaja());
				
		c3.retiro(2000);
		
		System.out.println("Saldo:"+bnc.getTotalEnCaja());
		
			

	}
	
}
