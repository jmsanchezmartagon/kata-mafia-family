package punisher;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.net.URL;
import java.util.Map;
import java.util.Set;

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
		Map<String, Set<Criminal>> map = app.collectFamilies(fileTest.getPath());

		assertNotNull("Empty", map);
		assertTrue("Empty", map.size() > 0);

		//
		map.values().stream().forEach(tree -> {
			Criminal parent = null;
			for (Criminal item : tree) {
				if (parent != null)
					assertTrue("No Order", CriminalSort.LEVEL.compare(parent, item) < 0);
				parent = item;
			}
		});
	}

}
