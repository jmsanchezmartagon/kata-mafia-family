package punisher;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
	private static Logger LOGGER = Logger.getLogger(Main.class.getName());

	private enum FieldName {
		NAME, LAST_NAME, NICK, FAMILY, LEVEL
	}

	private ICriminalPrinter printer = null;

	public Main() {
		printer = new CriminalPrinterConsoleJson();
	}

	public static void main(String[] args) {
		Main app = new Main();

		Map<String, Family> map = app.collectFamilies(args[0]);
		if (map != null) {
			map.entrySet().parallelStream()
			        .forEach(item -> app.printer.print(item.getKey(), item.getValue().iterator()));
		}
	}

	public Map<String, Family> collectFamilies(String filename) {
		Map<String, Family> map = null;
		BufferedReader buffeReader = null;
		try {
			String line = null;
			Criminal criminal = null;
			Family family = null;
			String[] fields = null;

			File sourceFile = new File(filename);
			buffeReader = new BufferedReader(new FileReader(sourceFile));

			map = new HashMap<>();
			while ((line = buffeReader.readLine()) != null) {
				fields = line.split(";");
				criminal = Criminal.builder().name(fields[FieldName.NAME.ordinal()])
				        .lastName(fields[FieldName.LAST_NAME.ordinal()]).nick(fields[FieldName.NICK.ordinal()])
				        .family(fields[FieldName.FAMILY.ordinal()]).level(fields[FieldName.LEVEL.ordinal()]).build();

				
				family = map.computeIfAbsent(criminal.getFamily(), k -> new FamilyTreeImpl());
				family.add(criminal);
			}
		} catch (IOException e) {
			LOGGER.log(Level.SEVERE, e.getMessage(), e);
		} finally {
			if (buffeReader != null) {
				try {
					buffeReader.close();
				} catch (IOException e) {
					LOGGER.log(Level.SEVERE, e.getMessage(), e);
				}
			}
		}
		return map;

	}

}