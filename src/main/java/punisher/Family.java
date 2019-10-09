package punisher;

import java.util.Iterator;

interface Family {

	void add(Criminal criminal) ;

	Iterator<Criminal> iterator();
}
