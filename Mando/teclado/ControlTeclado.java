/**
 * Clase que permite usar el teclado del ordenador desde la aplicacion movil
 */
package teclado;

import static java.awt.event.KeyEvent.VK_0;
import static java.awt.event.KeyEvent.VK_1;
import static java.awt.event.KeyEvent.VK_2;
import static java.awt.event.KeyEvent.VK_3;
import static java.awt.event.KeyEvent.VK_4;
import static java.awt.event.KeyEvent.VK_5;
import static java.awt.event.KeyEvent.VK_6;
import static java.awt.event.KeyEvent.VK_7;
import static java.awt.event.KeyEvent.VK_8;
import static java.awt.event.KeyEvent.VK_9;
import static java.awt.event.KeyEvent.VK_A;
import static java.awt.event.KeyEvent.VK_B;
import static java.awt.event.KeyEvent.VK_C;
import static java.awt.event.KeyEvent.VK_D;
import static java.awt.event.KeyEvent.VK_E;
import static java.awt.event.KeyEvent.VK_F;
import static java.awt.event.KeyEvent.VK_G;
import static java.awt.event.KeyEvent.VK_H;
import static java.awt.event.KeyEvent.VK_I;
import static java.awt.event.KeyEvent.VK_J;
import static java.awt.event.KeyEvent.VK_K;
import static java.awt.event.KeyEvent.VK_L;
import static java.awt.event.KeyEvent.VK_M;
import static java.awt.event.KeyEvent.VK_N;
import static java.awt.event.KeyEvent.VK_O;
import static java.awt.event.KeyEvent.VK_P;
import static java.awt.event.KeyEvent.VK_Q;
import static java.awt.event.KeyEvent.VK_R;
import static java.awt.event.KeyEvent.VK_S;
import static java.awt.event.KeyEvent.VK_T;
import static java.awt.event.KeyEvent.VK_U;
import static java.awt.event.KeyEvent.VK_V;
import static java.awt.event.KeyEvent.VK_W;
import static java.awt.event.KeyEvent.VK_X;
import static java.awt.event.KeyEvent.VK_Y;
import static java.awt.event.KeyEvent.VK_Z;

import java.awt.Robot;
import java.awt.event.KeyEvent;

public class ControlTeclado {
	
	/**
	 * Crea la combinacion de teclas para teclear el caracter
	 * @param bot robot asociado
	 * @param c caracter a teclear
	 */
	public static void escribir(final Robot bot, char c) {
		switch (c) {
	        case 'a': teclear(VK_A, false, false, bot); break;
	        case 'b': teclear(VK_B, false, false, bot); break;
	        case 'c': teclear(VK_C, false, false, bot); break;
	        case 'd': teclear(VK_D, false, false, bot); break;
	        case 'e': teclear(VK_E, false, false, bot); break;
	        case 'f': teclear(VK_F, false, false, bot); break;
	        case 'g': teclear(VK_G, false, false, bot); break;
	        case 'h': teclear(VK_H, false, false, bot); break;
	        case 'i': teclear(VK_I, false, false, bot); break;
	        case 'j': teclear(VK_J, false, false, bot); break;
	        case 'k': teclear(VK_K, false, false, bot); break;
	        case 'l': teclear(VK_L, false, false, bot); break;
	        case 'm': teclear(VK_M, false, false, bot); break;
	        case 'n': teclear(VK_N, false, false, bot); break;
	        case 'ñ': teclear(192, false, false, bot); break;
	        case 'o': teclear(VK_O, false, false, bot); break;
	        case 'p': teclear(VK_P, false, false, bot); break;
	        case 'q': teclear(VK_Q, false, false, bot); break;
	        case 'r': teclear(VK_R, false, false, bot); break;
	        case 's': teclear(VK_S, false, false, bot); break;
	        case 't': teclear(VK_T, false, false, bot); break;
	        case 'u': teclear(VK_U, false, false, bot); break;
	        case 'v': teclear(VK_V, false, false, bot); break;
	        case 'w': teclear(VK_W, false, false, bot); break;
	        case 'x': teclear(VK_X, false, false, bot); break;
	        case 'y': teclear(VK_Y, false, false, bot); break;
	        case 'z': teclear(VK_Z, false, false, bot); break;
	        
	        case 'A': teclear(VK_A, true, false, bot); break; 
	        case 'B': teclear(VK_B, true, false, bot); break;
	        case 'C': teclear(VK_C, true, false, bot); break;
	        case 'D': teclear(VK_D, true, false, bot); break;
	        case 'E': teclear(VK_E, true, false, bot); break;
	        case 'F': teclear(VK_F, true, false, bot); break;
	        case 'G': teclear(VK_G, true, false, bot); break;
	        case 'H': teclear(VK_H, true, false, bot); break;
	        case 'I': teclear(VK_I, true, false, bot); break;
	        case 'J': teclear(VK_J, true, false, bot); break;
	        case 'K': teclear(VK_K, true, false, bot); break;
	        case 'L': teclear(VK_L, true, false, bot); break;
	        case 'M': teclear(VK_M, true, false, bot); break;
	        case 'N': teclear(VK_N, true, false, bot); break;
	        case 'Ñ': teclear(192, true, false, bot); break;
	        case 'O': teclear(VK_O, true, false, bot); break;
	        case 'P': teclear(VK_P, true, false, bot); break;
	        case 'Q': teclear(VK_Q, true, false, bot); break;
	        case 'R': teclear(VK_R, true, false, bot); break;
	        case 'S': teclear(VK_S, true, false, bot); break;
	        case 'T': teclear(VK_T, true, false, bot); break;
	        case 'U': teclear(VK_U, true, false, bot); break;
	        case 'V': teclear(VK_V, true, false, bot); break;
	        case 'W': teclear(VK_W, true, false, bot); break;
	        case 'X': teclear(VK_X, true, false, bot); break;
	        case 'Y': teclear(VK_Y, true, false, bot); break;
	        case 'Z': teclear(VK_Z, true, false, bot); break;
	            
	        case '0': teclear(VK_0, false, false, bot); break;
	        case '=': teclear(VK_0, true, false, bot); break;
	        
	        case '1': teclear(VK_1, false, false, bot); break;
	        case '!': teclear(VK_1, true, false, bot); break;
	        case '|': teclear(VK_1, false, true, bot); break;
	        
	        case '2': teclear(VK_2, false, false, bot); break;
	        case '\"': teclear(VK_2, true, false, bot); break;
	        case '@': teclear(VK_2, false, true, bot); break;
	        
	        case '3': teclear(VK_3, false, false, bot); break;
	        case '·': teclear(VK_3, true, false, bot); break; //Existe en android??
	        case '#': teclear(VK_3, false, true, bot); break;
	        
	        case '4': teclear(VK_4, false, false, bot); break;
	        case '$': teclear(VK_4, true, false, bot); break;
	        case '~': teclear(VK_4, false, true, bot); break;
	        
	        case '5': teclear(VK_5, false, false, bot); break;
	        case '€': teclear(VK_5, true, false, bot); break;
	        case '%': teclear(VK_5, false, true, bot); break;
	        
	        case '6': teclear(VK_6, false, false, bot); break;
	        case '&': teclear(VK_6, true, false, bot); break;
	        case '¬': teclear(VK_6, false, true, bot); break;
	        
	        case '7': teclear(VK_7, false, false, bot); break;
	        case '/': teclear(VK_7, true, false, bot); break;
	        
	        case '8': teclear(VK_8, false, false, bot); break;
	        case '(': teclear(VK_8, true, false, bot); break;
	        
	        case '9': teclear(VK_9, false, false, bot); break;
	        case ')': teclear(VK_9, true, false, bot); break;
	        
	        case '\'': teclear(222, false, false, bot); break;
	        case '?': teclear(222, true, false, bot); break;
	        
	        case '<': teclear(KeyEvent.VK_LESS, false, false, bot); break;
	        case '>': teclear(KeyEvent.VK_LESS, true, false, bot); break;
	        
	        case ' ': teclear(KeyEvent.VK_SPACE, false, false, bot); break;
	        
	        case '.': teclear(KeyEvent.VK_DECIMAL, false, false, bot); break;
	        case ':': teclear(KeyEvent.VK_DECIMAL, true, false, bot); break;
	        
	        case ',': teclear(KeyEvent.VK_COMMA, false, false, bot); break;
	        case ';': teclear(KeyEvent.VK_COMMA, true, false, bot); break;
	        
	        case '-': teclear(45, false, false, bot); break;
	        case '_': teclear(45, true, false, bot); break;

	        case '+': teclear(KeyEvent.VK_PLUS, false, false, bot); break;
	        case '*': teclear(KeyEvent.VK_PLUS, true, false, bot); break;
	        case ']': teclear(KeyEvent.VK_PLUS, false, true, bot); break;
	        
	        case '`': teclear(128, false, false, bot); break;
	        case '^': teclear(128, true, false, bot); break;
	        case '[': teclear(128, false, true, bot); break;
	        
	        case '´': teclear(129, false, true, bot); break;
	        case '¨': teclear(129, true, false, bot); break;
	        case '{': teclear(129, false, true, bot); break;
	        
	        case 'ç': teclear(0, false, false, bot); break;
	        case 'Ç': teclear(0, false, false, bot); break;
	        case '}': teclear(0, false, true, bot); break;
	        
	        default: break;
	        
	 	}  
	}
	
	/**
	 * Teclea el caracter
	 * @param code codigo del caracter
	 * @param mayuscula true si el caracter necesita la tecla Shift para ser tecleado
	 * @param altgr true si el caracter necesita la tecla AltGr para ser tecleado
	 * @param bot robot asociado
	 */
	private static void teclear(final int code, final boolean mayuscula, final boolean altgr, final Robot bot) {
		if (mayuscula) {
            bot.keyPress(KeyEvent.VK_SHIFT);
        }
		
		if(altgr) {
			bot.keyPress(KeyEvent.VK_ALT);
			bot.keyPress(KeyEvent.VK_CONTROL);
		}
		
        bot.keyPress(code);
        bot.keyRelease(code);

        if (mayuscula) {
            bot.keyRelease(KeyEvent.VK_SHIFT);
        } 
        
        if(altgr) {
			bot.keyRelease(KeyEvent.VK_ALT);
			bot.keyRelease(KeyEvent.VK_CONTROL);
		}
	}
	
	/**
	 * Simula la tecla Enter
	 * @param bot robot asociado
	 */
	public static void enter(final Robot bot) {
		bot.keyPress(KeyEvent.VK_ENTER);
		bot.keyRelease(KeyEvent.VK_ENTER);
	}
	 /**
	  * Simula la tecla de borrar
	  * @param bot robot asociado
	  */
	public static void borrar(final Robot bot) {
		bot.keyPress(KeyEvent.VK_BACK_SPACE);
		bot.keyRelease(KeyEvent.VK_BACK_SPACE);
	}
}