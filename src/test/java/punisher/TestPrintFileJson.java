package punisher;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Optional;
import java.util.Set;

import org.junit.Test;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class TestPrintFileJson {


	@Test
	public void testPrintConsoleJson() {
		Criminal c = new Criminal("Alphonse Grabriel", "Capone", "Scarface", "PrintConsoleJson",
		        LevelEnum.LEADER.getLabel());

		ICriminalPrinter printer = new CriminalPrinterFileJson();
		printer.print(c.getFamily(), Arrays.asList(c).iterator());

		File f = new File("PrintConsoleJson.json");
		assertTrue("File not found!", f.exists());
		ObjectMapper omap = new ObjectMapper();
		Set<Criminal> family = null;
		try {
			family = omap.readValue(f, new TypeReference<Set<Criminal>> () {});
		} catch (IOException e) {
			fail(e.getMessage());
		}
		assertNotNull(family);
		Optional<Criminal> rc = family.stream().findFirst();
		assertTrue(rc.isPresent());
		assertTrue(rc.get().equals(c));
		
		f.delete();
	}
}
