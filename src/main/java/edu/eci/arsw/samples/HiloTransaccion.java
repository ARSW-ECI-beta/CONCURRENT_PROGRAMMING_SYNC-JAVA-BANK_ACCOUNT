package edu.eci.arsw.samples;

import edu.eci.arsw.models.bank.Banco;
import edu.eci.arsw.models.bank.Cuenta;


public class HiloTransaccion extends Thread{

	int waitPeriod=0;
	int idHilo=0;
	long resultado=0;
	Banco b;
	
	public HiloTransaccion(int id,Banco b){
		this.b=b;
		waitPeriod=Math.abs(RandomGenerator.nextInt(50));
		idHilo=id;
	}
	
	public void run(){
		int numit=idHilo;
		long startTime=System.currentTimeMillis();
		Cuenta c=new Cuenta(1000, b);
		b.abrirCuenta(c);
		
		for (int i=0;i<numit;i++){
			
			c.consignacion(1000);
			
			System.out.println("Soy el hilo "+idHilo+" y voy en el "+((float)((float)(i+1)/(float)numit)*100)+"% de mi tarea. P:"+waitPeriod);
			try {
				Thread.sleep(waitPeriod);
			} catch (InterruptedException e) {
				throw new RuntimeException(e);
			}
		}
		
		b.cerrarCuenta(c);
		resultado=System.currentTimeMillis()-startTime;
	}
	
	

	public long getResultado() {
		return resultado;
	}
}
