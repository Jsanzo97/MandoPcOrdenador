/**
 * Clase principal que permite utilizar el ordenador de forma remota desde la aplicacion movil MandoPc
 */
package server;

import java.awt.AWTException;
import java.awt.Image;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.Robot;
import java.awt.SystemTray;
import java.awt.Toolkit;
import java.awt.TrayIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.BindException;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.Enumeration;

import javax.swing.JOptionPane;

import raton.ControlRaton;
import teclado.ControlTeclado;
import volumenYbrillo.ControlBrillo;
import volumenYbrillo.ControlVolumen;

public class Main implements ActionListener{
	
	private static ServerSocket server;
	private static Robot bot;
		
	/**
	 * Crea una notificacion en windows que informa sobre la ip actual del ordenador
	 * @param s1 cadena de texto 1 para mostrar en el contenido de la notificacion
	 * @param s2 cadena de texto 2 para mostrar en el menu pop up
	 */
	public static void notificacion(String s1, String s2) {
		Image img = Toolkit.getDefaultToolkit().getImage("Resources/logoNotificacion.png");
		PopupMenu pm = crearMenu();
		
		TrayIcon icono = new TrayIcon(img, s2, pm);
		icono.setImageAutoSize(true);
	    
		try {
			SystemTray.getSystemTray().add(icono);
		} catch (AWTException e1) {
			e1.printStackTrace();
		}
	    
		icono.addActionListener(new ActionListener(){
	        @Override
	        public void actionPerformed(ActionEvent e){
	        	Object[] options = { "Aceptar", "Salir" };
	        	int opcion = JOptionPane.showOptionDialog(null, s1, "Informacion",JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,null, options, options[0]);
	        	
	        	if(opcion == 1){
                    System.exit(0);
                }
	        }
	    });
	    
	    icono.displayMessage("Direccion IP", s2, TrayIcon.MessageType.INFO);
	}

	public static PopupMenu crearMenu(){
	    PopupMenu menu = new PopupMenu();
	    
	    MenuItem salir = new MenuItem("Salir");
	    salir.addActionListener(new ActionListener(){
	        @Override
	        public void actionPerformed(ActionEvent e){
	            System.exit(0);
	        }
	    });
	    
	    menu.add(salir);
	    return menu;
	}
	
	public static String obtenerIpLocal() {
        try {
            Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();
            
            while (interfaces.hasMoreElements()) {
                NetworkInterface interfaz = interfaces.nextElement();
                
                if (interfaz.isLoopback() || !interfaz.isUp()) {
                    continue;
                }
                
                Enumeration<InetAddress> addresses = interfaz.getInetAddresses();
                while (addresses.hasMoreElements()) {
                    InetAddress addr = addresses.nextElement();
                    
                    if (addr instanceof Inet4Address && !addr.isLoopbackAddress()) {
                        String ip = addr.getHostAddress();
                        
                        // Priorizar direcciones de red local común
                        if (ip.startsWith("192.168.") || 
                            ip.startsWith("10.") || 
                            ip.startsWith("172.")) {
                            return ip;
                        }
                    }
                }
            }
        } catch (SocketException e) {
            e.printStackTrace();
        }
        return null;
    }
	
	public static void main(String [] args) throws IOException {
		/* Crea el bot */
		try {
			bot = new Robot();
		} catch (AWTException e1) {
			e1.printStackTrace();
		}
		
		/* Obtiene el brillo inicial */
		String command = "powershell.exe  Get-Ciminstance -Namespace root/WMI -ClassName WmiMonitorBrightness";
		Process powerShellProcess = Runtime.getRuntime().exec(command);
		powerShellProcess.getOutputStream().close();
		String linea;
		BufferedReader stdout = new BufferedReader(new InputStreamReader(powerShellProcess.getInputStream()));
		while ((linea = stdout.readLine()) != null) {
			if(linea.startsWith("Current")) {
				ControlBrillo.brilloActual = Integer.parseInt(linea.substring(20));
			}
		}
		stdout.close();
		
		/* Obtiene las ip de wifi y cable */
		String localIp = obtenerIpLocal();
		
		String texto =  "<html><div style='text-align: center;'>&nbsp;&nbsp;&nbsp;&nbsp;Introduzca la IP en la app del movil.<br>" + localIp + "<br>NO CIERRE esta ventana mientras usa la app</div></html>";
		String texto2 = "Direccion IP: " + localIp;
		
		notificacion(texto, texto2);
		
		boolean activo = true;
		Socket client;
		BufferedReader r;
		String line;
		
		try {
			server = new ServerSocket(7070);
			while(activo) {
				client = server.accept();
				r = new BufferedReader(new InputStreamReader(client.getInputStream()));
				line = r.readLine();

				if(line != null) {
					if(line.equals("SubirVol")) {
						ControlVolumen.subirVolumen();
					}else if(line.equals("BajarVol")) {
						ControlVolumen.bajarVolumen();
					}else if(line.equals("ClickarI")) {
						ControlRaton.clickarI(bot);
					}else if(line.equals("ClickarD")) {
						ControlRaton.clickarD(bot);
					}else if(line.startsWith("Mov")) {
						ControlRaton.mover(bot, line);
					}else if(line.startsWith("Scroll")){
						ControlRaton.scroll(bot, line);
					}else if(line.startsWith("Tec")) {
						ControlTeclado.escribir(bot, line.charAt(4));
					}else if(line.startsWith("Enter")) {
						ControlTeclado.enter(bot);
					}else if(line.startsWith("Borrar")) {
						ControlTeclado.borrar(bot);
					}else if(line.startsWith("SubirBrillo")) {
						ControlBrillo.subirBrillo();
					}else if(line.startsWith("BajarBrillo")) {
						ControlBrillo.bajarBrillo();
					}
				}else {
					client.close();
				}
				client.close();
			}
		} catch (BindException e) {
			System.exit(0);
		} catch (Exception err) {
			err.printStackTrace();
		}
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		System.exit(0);
	}
}