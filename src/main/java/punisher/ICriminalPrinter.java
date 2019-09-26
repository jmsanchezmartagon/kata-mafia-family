package punisher;

import java.util.Iterator;

public interface ICriminalPrinter {
	
	/**
	 * Print a criminal family
	 * @param family
	 * @param collect list of criminals
	 */
	void print(String family, Iterator<Criminal> collect);
}
