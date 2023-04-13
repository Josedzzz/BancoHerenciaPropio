package bancoHerencia.model;


public abstract class CuentaBancaria {

	protected float saldo;
	protected int numConsiganciones;
	protected int numRetiros;
	protected float tasaAnual;
	protected float comisionMensual;

	/**
	 *
	 * @param saldo
	 * @param numConsiganciones
	 * @param numRetiros
	 * @param tasaAnual
	 * @param comisionMensual
	 */
	public CuentaBancaria(float saldo, int numConsiganciones, int numRetiros, float tasaAnual, float comisionMensual) {
		super();
		this.saldo = saldo;
		this.numConsiganciones = numConsiganciones;
		this.numRetiros = numRetiros;
		this.tasaAnual = tasaAnual;
		this.comisionMensual = comisionMensual;
	}

	public CuentaBancaria() {

	}

	public float getSaldo() {
		return saldo;
	}

	public void setSaldo(float saldo) {
		this.saldo = saldo;
	}

	public int getNumConsiganciones() {
		return numConsiganciones;
	}

	public void setNumConsiganciones(int numConsiganciones) {
		this.numConsiganciones = numConsiganciones;
	}

	public int getNumRetiros() {
		return numRetiros;
	}

	public void setNumRetiros(int numRetiros) {
		this.numRetiros = numRetiros;
	}

	public float getTasaAnual() {
		return tasaAnual;
	}

	public void setTasaAnual(float tasaAnual) {
		this.tasaAnual = tasaAnual;
	}

	public float getComisionMensual() {
		return comisionMensual;
	}

	public void setComisionMensual(float comisionMensual) {
		this.comisionMensual = comisionMensual;
	}

	@Override
	public String toString() {
		return "CuentaBancaria [saldo=" + saldo + ", numConsiganciones=" + numConsiganciones + ", numRetiros="
				+ numRetiros + ", tasaAnual=" + tasaAnual + ", comisionMensual=" + comisionMensual + "]";
	}

	//--------------------------------------------------------------------------------------------------------------------
	/**
	 *
	 * @param cuentaBancaria
	 * @param dinero
	 */
	public void consignarDinero(CuentaBancaria cuentaBancaria, float dinero) {
		float total = cuentaBancaria.getSaldo();
		total = total + dinero;
		cuentaBancaria.setSaldo(total);
	}

	/**
	 *
	 * @param cuentaBancaria
	 * @param dineroRetiro
	 * @return
	 */
	public boolean verificarSaldo(CuentaBancaria cuentaBancaria, float dineroRetiro) {
		if(dineroRetiro <= cuentaBancaria.getSaldo()) {
			return true;
		}
		return false;
	}

	/**
	 *
	 * @param cuentaBancaria
	 * @param dineroRetiro
	 * @throws Exception
	 */
	public void retirarDinero(CuentaBancaria cuentaBancaria, float dineroRetiro) throws Exception {
		float total = 0;
		if(cuentaBancaria.verificarSaldo(cuentaBancaria, dineroRetiro)) {
			total = cuentaBancaria.getSaldo() - dineroRetiro;
			cuentaBancaria.setSaldo(total);
		} else {
			throw new Exception("La cuenta no tiene el saldo solicitado");
		}
	}

	/**
	 *
	 * @param cuentaBancaria
	 */
	public float calcularInteresMensual(CuentaBancaria cuentaBancaria) {
		float tasaInteresMensual = (cuentaBancaria.getTasaAnual() / 12) / 100; //Calculo la tasa de interes mensual
		float interesMensual = cuentaBancaria.getSaldo() * tasaInteresMensual; //Calculo el interes mensual
		float total = cuentaBancaria.getSaldo() - interesMensual; //Le resto a la cuenta el interes mensual
		cuentaBancaria.setSaldo(total); //Actualizo el saldo de la cuenta
		return total;
	}

	/**
	 *
	 * @param cuentaBancaria
	 * @return
	 */
	public String obtenerExtractoMensual(CuentaBancaria cuentaBancaria) {
		float saldoInicial = cuentaBancaria.getSaldo();
		calcularInteresMensual(cuentaBancaria);
		float interesMensual = cuentaBancaria.getSaldo() - saldoInicial;
		String extractoMensual = "El estracto del mes: \n";
	    extractoMensual += "- Saldo inicial: $" + saldoInicial + "\n";
	    extractoMensual += "- Saldo final: $" + cuentaBancaria.getSaldo() + "\n";
	    extractoMensual += "- Interés del mes: $" + interesMensual + "\n";
	    return extractoMensual;
	}

	/**
	 *
	 * @param cuentaBancaria
	 */
	public void imprimirDatosCuenta(CuentaBancaria cuentaBancaria) {
		System.out.println(cuentaBancaria.toString());
	}

}
