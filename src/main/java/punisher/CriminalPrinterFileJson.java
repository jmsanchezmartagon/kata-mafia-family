package punisher;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;

public class CriminalPrinterFileJson implements ICriminalPrinter {
	private static Logger logger = Logger.getLogger(CriminalPrinterFileJson.class.getName());
	
	@Override
	public void print(String family, Iterator<Criminal> collect)   {
		ObjectMapper omap = new ObjectMapper();
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream(new File(family + ".json"));
			omap.writeValue(fos, collect);
			fos.flush();
		} catch (IOException  e) {
			logger.log(Level.SEVERE, e.getMessage(), e);
		}  finally {
			if (fos != null) {
				try {
				fos.close();
				} catch (IOException  e) {
					logger.log(Level.SEVERE, e.getMessage(), e);
				}
			}
		}
	}
}
