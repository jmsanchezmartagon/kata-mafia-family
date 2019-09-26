package punisher;

import java.io.IOException;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;

public class CriminalPrinterConsoleJson implements ICriminalPrinter {
	private static Logger logger = Logger.getLogger(CriminalPrinterConsoleJson.class.getName());

	@Override
	public void print(String family, Iterator<Criminal> collect)   {
		ObjectMapper omap = new ObjectMapper();
		try {
			System.out.println(omap.writeValueAsString(omap.writeValueAsString(collect)));
		} catch (IOException  e) {
			logger.log(Level.SEVERE, e.getMessage(), e);
		}
	}
}
