/**
 * Clase que permite subir y bajar el volumen del ordenador desde la aplicacion movil
 */
package volumenYbrillo;

import java.io.IOException;

public class ControlVolumen {
	
	/**
	 * Ejecuta el srcipt de subir el volumen
	 */
	public static void subirVolumen() {
		//Cambiar la ruta del Srcipt
		try {
	       Runtime.getRuntime().exec( "wscript C:/MandoPC/Scripts/SubirVol.vbs" );
	    } catch( IOException e ) {
	      e.printStackTrace();
	    }
	}
	
	/**
	 * Ejecuta el srcipt de bajar el volumen
	 */
	public static void bajarVolumen() {
		//Cambiar la ruta del Srcipt
	    try {
	       Runtime.getRuntime().exec( "wscript C:/MandoPC/Scripts/BajarVol.vbs" );
	    } catch( IOException e ) {
	      e.printStackTrace();
	    }
	}
}