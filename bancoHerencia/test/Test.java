package bancoHerencia.test;

import bancoHerencia.model.CuentaAhorros;

public class Test {

	public static void main(String[] args) {
		CuentaAhorros cuentaAhorros1 = new CuentaAhorros(500000, 0, 0, 15, 0, true);

		System.out.println("Pruebo si la cuenta esta activa: ");
		cuentaAhorros1.verificarActiva(cuentaAhorros1);
		cuentaAhorros1.imprimirDatosCuentaAhorros(cuentaAhorros1);

		System.out.println("Pruebo consignar dinero: ");
		try {
			cuentaAhorros1.consignarDineroCuentaAhorros(cuentaAhorros1, 500);
		} catch (Exception e) {
			e.printStackTrace();
		}
		cuentaAhorros1.imprimirDatosCuentaAhorros(cuentaAhorros1);

		System.out.println("Pruebo retirar dinero de la cuenta: ");
		try {
			cuentaAhorros1.retirarDinero(cuentaAhorros1, 500);
		} catch (Exception e) {
			e.printStackTrace();
		}
		cuentaAhorros1.imprimirDatosCuentaAhorros(cuentaAhorros1);

		System.out.println("Pruebo la cantidad de retiros: ");
		cuentaAhorros1.darCantidadRetiros(cuentaAhorros1);
		cuentaAhorros1.imprimirDatosCuentaAhorros(cuentaAhorros1);
	}

}
