package mvc1.utilerias;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import mvc1.controllers.HomeController;

public class Log {
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	private static boolean visible = true;
	
	public static void logError(String mensaje) {
		if(visible) {
			logger.error("Programacion JJE: ", mensaje);
		}
		
	}
	
	public static void logInfo(String mensaje) {
		if(visible) {
			logger.info("Programacion JJE: ", mensaje);
		}
	}
	
	public static void logWarning(String mensaje) {
		if(visible) {
			logger.warn("Programacion JJE: ", mensaje);
		}
	}
	
}
