package bancoHerencia.model;

public class CuentaAhorros extends CuentaBancaria{

	private boolean cuentaActiva;

	public CuentaAhorros(float saldo, int numConsiganciones, int numRetiros, float tasaAnual, float comisionMensual,
			boolean cuentaActiva) {
		super(saldo, numConsiganciones, numRetiros, tasaAnual, comisionMensual);
		this.cuentaActiva = cuentaActiva;
	}

	public CuentaAhorros() {

	}

	public boolean isCuentaActiva() {
		return cuentaActiva;
	}

	public void setCuentaActiva(boolean cuentaActiva) {
		this.cuentaActiva = cuentaActiva;
	}



	@Override
	public String toString() {
		return "CuentaAhorros [cuentaActiva=" + cuentaActiva + ", saldo=" + saldo + ", numConsiganciones="
				+ numConsiganciones + ", numRetiros=" + numRetiros + ", comisionMensual=" + comisionMensual + "]";
	}

	//--------------------------------------------------------------------------------------------------------------------
	/**
	 *
	 * @param cuentaAhorros
	 * @return
	 */
	public void verificarActiva(CuentaAhorros cuentaAhorros) {
		float saldo = cuentaAhorros.getSaldo();
		if(saldo < 10000) {
			cuentaAhorros.setCuentaActiva(false);
		} else {
			cuentaAhorros.setCuentaActiva(true);
		}
	}

	/**
	 *
	 * @param cuentaAhorros
	 * @param dinero
	 * @throws Exception
	 */
	public void consignarDineroCuentaAhorros(CuentaAhorros cuentaAhorros, float dinero) throws Exception {
		if(cuentaAhorros.isCuentaActiva()) {
			cuentaAhorros.consignarDinero(cuentaAhorros, dinero);
			int consignacionesAux = cuentaAhorros.getNumConsiganciones();
			consignacionesAux = consignacionesAux + 1;
			cuentaAhorros.setNumConsiganciones(consignacionesAux);
		} else {
			throw new Exception("La cuenta no esta activa, por lo que no se puede realizar el proceso");
		}
	}

	/**
	 *
	 * @param cuentaAhorros
	 * @param dineroRetiro
	 * @throws Exception
	 */
	public void retirarDineroCuentaAhorros(CuentaAhorros cuentaAhorros, float dineroRetiro) throws Exception {
		if(cuentaAhorros.isCuentaActiva()) {
			cuentaAhorros.retirarDinero(cuentaAhorros, dineroRetiro);
			int retirosAux = cuentaAhorros.getNumRetiros();
			retirosAux = retirosAux + 1;
			cuentaAhorros.setNumRetiros(retirosAux);
		} else {
			throw new Exception("La cuenta no esta activa, por lo que no se puede realizar el proceso");
		}
	}

	/**
	 *
	 * @param cuentaAhorros
	 * @return
	 */
	public int darCantidadRetiros(CuentaAhorros cuentaAhorros) {
		return cuentaAhorros.getNumRetiros();
	}

	public float darEstractoMensual(CuentaAhorros cuentaAhorros) {
		float extractoMensual = cuentaAhorros.getComisionMensual();
		float interesMensual = cuentaAhorros.calcularInteresMensual(cuentaAhorros);
		float saldo = cuentaAhorros.getSaldo();
		float numRetiros = cuentaAhorros.getNumRetiros();
		if(numRetiros > 4) {
			float aumentoTotal = (numRetiros - 4) * 1000;
			extractoMensual = extractoMensual + aumentoTotal;
		}

		if(saldo > 0) {
			extractoMensual = extractoMensual + saldo * interesMensual;
		}

		return extractoMensual;
	}

	/**
	 * Debe imprimir el saldo, la comision mensual y num de transacciones(cantidad de consignaciones y retiros)
	 * @param cuentaAhorros
	 */
	public void imprimirDatosCuentaAhorros(CuentaAhorros cuentaAhorros) {
		System.out.println(cuentaAhorros.toString());
	}





}
