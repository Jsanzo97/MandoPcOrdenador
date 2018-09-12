/**
 * Clase que permite subir y bajar el brillo del ordenador desde la aplicacion movil
 */
package volumenYbrillo;

import java.io.IOException;

public class ControlBrillo {
	
	public static int brilloActual;

	/**
	 * Aumenta el brillo actual
	 * @throws IOException
	 */
	public static void subirBrillo() throws IOException {
		if(brilloActual < 100) {
			brilloActual += 10;
			cambio();
		}
	}
	
	/**
	 * Disminuye el brillo actual
	 * @throws IOException
	 */
	public static void bajarBrillo() throws IOException {
		if(brilloActual > 0) {
			brilloActual -= 10;
			cambio();
		}
	}
	
	/**
	 * Cambia el brillo actual mediante comandos de powershell
	 * @throws IOException
	 */
	private static void cambio() throws IOException {
		String command = "powershell.exe "
				+ "$delay = 5; "
				+ "$brillo = " + brilloActual + "; "
				+ "$myMonitor = Get-WmiObject -Namespace root\\wmi -Class WmiMonitorBrightnessMethods; "
				+ "$myMonitor.wmisetbrightness($delay, $brillo)";
		Process powerShellProcess = Runtime.getRuntime().exec(command);
		powerShellProcess.getOutputStream().close();
	}
}