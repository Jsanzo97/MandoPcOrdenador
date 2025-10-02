/**
 * Clase que permite mover el raton y clickar de forma remota desde la aplicacion movil
 */
package raton;

import java.awt.Robot;
import java.awt.event.InputEvent;

public class ControlRaton{
	
	private static int origenX = 500;
	private static int origenY = 500;
	private static int despX = 0;
	private static int despY = 0;
	
	/**
	 * Realiza la accion de click izquierdo
	 * @param bot robot asociado
	 */
	public static void clickarI(final Robot bot) {
		try {
			bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
			bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		}catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	/**
	 * Realiza la accion de click derecho
	 * @param bot robot asociado
	 */

	public static void clickarD(final Robot bot) {
		try {
			bot.mousePress(InputEvent.BUTTON3_DOWN_MASK);
			bot.mouseRelease(InputEvent.BUTTON3_DOWN_MASK);
		}catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	/**
	 * Realiza la accion de mover el cursor
	 * @param bot robot asociado
	 * @param s coordenadas donde mover el cursor
	 */
	public static void mover(final Robot bot, final String s) {
		if(s.equals("Mov restart")) {
			origenX += despX;
			origenY += despY;

			despX = 0;
			despY = 0;
		}else {
			String [] coordenadas = s.substring(4).split(",");
			
			despX = Integer.parseInt(coordenadas[0]);
			despY = Integer.parseInt(coordenadas[1]);
						
			try {
				// Move to new position
	            int newX = origenX + despX;
	            int newY = origenY + despY;
	            
	            bot.mouseMove(newX, newY);
			}catch(Exception ex) {
				ex.printStackTrace();
			}
		}
	}
	
	/**
	 * Realiza la accion de scroll
	 * @param bot robot asociado
	 * @param s cuanto mover la barra con el scroll
	 */
	public static void scroll(final Robot bot, final String s) {
		String [] coordenadas = s.substring(7).split(",");
		
		//int movX = Integer.parseInt(coordenadas[0]);
		int movY = Integer.parseInt(coordenadas[1]);
		
		if(movY > 0) {
			try {
				bot.mouseWheel(1);
			}catch (Exception ex) {
				ex.printStackTrace();
			}
		} else if(movY < 0) {
			try {
				bot.mouseWheel(-1);
			}catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}
}