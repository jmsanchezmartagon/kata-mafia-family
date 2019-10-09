package punisher;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class FamilyTreeImpl implements Family {

	private Set<Criminal> family = null;
	private Criminal lastSargeant = null;

	public FamilyTreeImpl() {
		family = new TreeSet<Criminal>();
	}

	public void add(Criminal criminal) {

		if (LevelEnum.BADASS.getLabel().equalsIgnoreCase(criminal.getLevel())) {
			if (lastSargeant.getBadass() == null) {
				lastSargeant.setBadass(new ArrayList<>());
			}
			lastSargeant.getBadass().add(criminal);
		} else {
			family.add(criminal);
			if (LevelEnum.SERGEANT.getLabel().equalsIgnoreCase(criminal.getLevel())) {
				lastSargeant = criminal;
			}
		}
	}

	public Iterator<Criminal> iterator() {
		return new FamilyIterator(family.iterator());
	}

	private final class FamilyIterator implements Iterator<Criminal> {
		private Iterator<Criminal> family;
		private Iterator<Criminal> badassIterator = null;

		public FamilyIterator(Iterator<Criminal> family) {
			this.family = family;
		}

		@Override
		public boolean hasNext() {
			return family.hasNext() || badassIterator != null && badassIterator.hasNext();
		}

		@Override
		public Criminal next() {
			Criminal criminal = null;
			if (badassIterator != null && badassIterator.hasNext()) {
				criminal = badassIterator.next();
			} else {
				criminal = family.next();
				if (criminal.getBadass() == null) {
					badassIterator = null;
				} else {
					badassIterator = criminal.getBadass().iterator();
				}
			}
			return criminal;
		}
	}

}
