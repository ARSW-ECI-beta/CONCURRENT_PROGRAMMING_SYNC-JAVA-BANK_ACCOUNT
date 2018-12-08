package edu.eci.arsw.models.bank;

public class Cuenta {
	/**
	 * Banco al cual pertenece la cuenta.
	 */
	private Banco agencia;

	/**
	 * Saldo
	 */
	private int saldo;

	public Cuenta(int saldo, Banco agencia) {
		this.saldo = saldo;
		this.agencia = agencia;
	}

	/**
	 * Consigna dinero en la cuenta
	 * 
	 * @param cantidad
	 */
	public void consignacion(int cantidad) {
		saldo += cantidad;
		agencia.consignacion(cantidad);
	}

	/**
	 * Retira dinero de la cuenta, sin exceder el saldo.
	 * 
	 * @param cantidad
	 */
	public void retiro(int cantidad) {
		if (cantidad < saldo) {
			saldo -= cantidad;
			agencia.retiro(cantidad);
		} else {
			throw new RuntimeException("No se puede retirar la cantidad $"
					+ cantidad + " de la cuenta. Saldo:$" + saldo);
		}

	}

	/**
	 * Retorna el saldo.
	 * 
	 * @return
	 */
	public int getSaldo() {
		return saldo;
	}

}
