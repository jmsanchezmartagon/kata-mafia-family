package punisher;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
	private static Logger logger = Logger.getLogger(Main.class.getName());
	
	private enum FieldName {
		NAME, LAST_NAME, NICK, FAMILY, LEVEL
	}
	
	private ICriminalPrinter printer = null;
	public Main() {
//		printer = new CriminalPrinterConsoleJson();
		printer = new CriminalPrinterFileJson();
	}

	public static void main(String[] args) {
		Main app = new Main();
		
		Map<String, Set<Criminal>> map =app.splitAndSort(args[0]);
		
		if (map != null) {
			map.entrySet().parallelStream().forEach(item -> app.printer.print(item.getKey(),item.getValue().iterator()));
		}
	}


	public Map<String, Set<Criminal>> splitAndSort(String filename) {
		Map<String, Set<Criminal>> map = null;
		BufferedReader b = null;
		try {
			String line = null;
			Criminal criminal = null;
			Set<Criminal> tree = null;
			String[] fields = null;

			File f = new File(filename);
			b = new BufferedReader(new FileReader(f));

			map = new HashMap<>();
			while ((line = b.readLine()) != null) {
				fields = line.split(";");
				criminal = new Criminal(fields[FieldName.NAME.ordinal()], fields[FieldName.LAST_NAME.ordinal()],
				        fields[FieldName.NICK.ordinal()], fields[FieldName.FAMILY.ordinal()],
				        fields[FieldName.LEVEL.ordinal()]);
				tree = map.computeIfAbsent(criminal.getFamily(), k -> new TreeSet<Criminal>(CriminalSort.LEVEL));
				tree.add(criminal);
			}
		} catch (IOException e) {
			logger.log(Level.SEVERE, e.getMessage(),e);
		} finally {
			if (b != null) {
				try {
					b.close();
				} catch (IOException e) {
					logger.log(Level.SEVERE, e.getMessage(),e);
				}
			}
		}
		return map;
		
	}

	
}