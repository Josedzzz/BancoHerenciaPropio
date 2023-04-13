package bancoHerencia.model;

public class CuentaCorriente extends CuentaBancaria{

	private float sobreGiro;

	public CuentaCorriente(float saldo, int numConsiganciones, int numRetiros, float tasaAnual, float comisionMensual,
			float dobreGiro) {
		super(saldo, numConsiganciones, numRetiros, tasaAnual, comisionMensual);
		this.sobreGiro = dobreGiro;
	}

	public CuentaCorriente() {

	}

	public float getSobreGiro() {
		return sobreGiro;
	}

	public void setSobreGiro(float sobreGiro) {
		this.sobreGiro = sobreGiro;
	}





	@Override
	public String toString() {
		return "CuentaCorriente [sobreGiro=" + sobreGiro + ", saldo=" + saldo + ", numConsiganciones="
				+ numConsiganciones + ", numRetiros=" + numRetiros + ", comisionMensual=" + comisionMensual + "]";
	}

	//--------------------------------------------------------------------------------------------------------------------
	/**
	 *
	 * @param cuentaCorriente
	 * @param dineroRetiro
	 */
	public void retirarDineroCuentaCorriente(CuentaCorriente cuentaCorriente, float dineroRetiro) {
		if(dineroRetiro <= cuentaCorriente.getSaldo()) {
			cuentaCorriente.setSaldo(cuentaCorriente.getSaldo() - dineroRetiro);
		} else {
			float sobreGiroAux = dineroRetiro - cuentaCorriente.getSaldo();
			cuentaCorriente.setSobreGiro(sobreGiroAux);
			cuentaCorriente.setSaldo(0);
		}
	}

	/**
	 * Se tiene que actualizar el sobreGiro
	 * @param cuentaCorriente
	 * @param dinero
	 */
	public void consignarDineroCuentaCorriente(CuentaCorriente cuentaCorriente, float dinero) {
		if(cuentaCorriente.getSobreGiro() > 0) {
			if(dinero <= cuentaCorriente.getSobreGiro()) {
				cuentaCorriente.setSobreGiro(cuentaCorriente.getSobreGiro() - dinero);
			} else {
				float total = dinero - cuentaCorriente.getSobreGiro();
				cuentaCorriente.setSobreGiro(0);
				cuentaCorriente.consignarDinero(cuentaCorriente, total);
			}
		} else {
			cuentaCorriente.consignarDinero(cuentaCorriente, dinero);
		}
	}

	/**
	 *
	 * @param cuentaCorriente
	 * @return
	 */
	public String obtenerExtractoMensualCuentaCorriente(CuentaCorriente cuentaCorriente) {
		String extractoMensual = cuentaCorriente.obtenerExtractoMensual(cuentaCorriente);
		return extractoMensual;
	}

	/**
	 * Debe imprimir el saldo, la comision mensual, numero de transaciones realizadas y sobregiro
	 * @param cuentaCorriente
	 */
	public void imprimirDatosCuentaCorriente(CuentaCorriente cuentaCorriente) {
		System.out.println(cuentaCorriente.toString());
	}


}
