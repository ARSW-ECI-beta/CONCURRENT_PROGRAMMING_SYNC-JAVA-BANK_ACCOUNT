package edu.eci.arsw.samples;

import edu.eci.arsw.models.bank.Banco;


public class MainTransaccionesConcurrentes {

	public static void main(String[] args) {
		final int numHilos=100;
		
		Banco bnc=new Banco(10000);
		
		
		HiloTransaccion[] hilos=new HiloTransaccion[numHilos];
		
		for (int i=0;i<numHilos;i++){
			hilos[i]=new HiloTransaccion(i,bnc);
		}
		for (int i=0;i<numHilos;i++){
			hilos[i].start();
		}
		
		long tiempoPromedio=0;
		
		for (int i=0;i<numHilos;i++){
			tiempoPromedio+=hilos[i].getResultado();
		}

		System.out.println("El tiempo promedio de la ejecucion fue de:"+tiempoPromedio/numHilos);
		System.out.println("El saldo final del banco es:"+bnc.getTotalEnCaja());
	}
	
}
