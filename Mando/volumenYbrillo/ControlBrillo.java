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
	public static void subirBrillo() {
		if(brilloActual < 100) {
			brilloActual += 10;
			cambio();
		}
	}
	
	/**
	 * Disminuye el brillo actual
	 * @throws IOException
	 */
	public static void bajarBrillo() {
		if(brilloActual > 0) {
			brilloActual -= 10;
			cambio();
		}
	}
	
	/**
	 * Cambia el brillo actual mediante comandos de powershell
	 * @throws IOException
	 */
	private static void cambio() {
		try {
			String powershellScript = 
				    "$delay = 5; " +
				    "$brillo = " + brilloActual + "; " +
				    "$myMonitor = Get-WmiObject -Namespace root\\wmi -Class WmiMonitorBrightnessMethods; " +
				    "$myMonitor.wmisetbrightness($delay, $brillo)";

				ProcessBuilder processBuilder = new ProcessBuilder(
				    "powershell.exe",
				    "-Command",
				    powershellScript
				);

				Process powerShellProcess = processBuilder.start();
				powerShellProcess.getOutputStream().close();
		} catch (IOException exception) {
			System.err.println(exception);
		}
		
	}
}