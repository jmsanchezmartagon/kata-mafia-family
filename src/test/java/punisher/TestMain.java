package punisher;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.net.URL;
import java.util.Iterator;
import java.util.Map;

import org.junit.Test;

public class TestMain {

	private URL findFile(String name) {
		URL file = this.getClass().getResource(name);
		if (file == null)
			file = this.getClass().getClassLoader().getResource(name);
		if (file == null)
			Thread.currentThread().getContextClassLoader().getResource(name);
		if (file == null)
			ClassLoader.getPlatformClassLoader().getResource(name);
		return file;
	}

	@Test
	public void testFile1() {
		Main app = new Main();
		URL fileTest = findFile("gangs.csv");
		assertNotNull("File not found!", fileTest);
		Map<String, Family> map = app.collectFamilies(fileTest.getPath());

		assertNotNull("Empty", map);
		assertTrue("Empty", map.size() > 0);

		//
		map.values().stream().forEach(family -> {
			Criminal parent = null;
			Criminal criminal = null;
			Iterator<Criminal> list = family.iterator();
			while (list.hasNext()) {
				criminal = list.next();
				if (parent != null)
					assertTrue("No Order", CriminalSort.LEVEL.compare(parent, criminal) < 0);
				parent = criminal;
			}
		});
	}

}
