package punisher;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;

public class FamilyTreeImpl implements Family {

	private Set<Criminal> family = null;
	private Criminal lastSargeant = null;
	private int counselorWigth = LevelEnum.COUNSELOR.getLevel();
	private int sergeantWeigth = LevelEnum.SERGEANT.getLevel();

	public FamilyTreeImpl() {
		family = new TreeSet<Criminal>(CriminalSort.LEVEL);
	}

	public void add(Criminal criminal) {

		Optional<LevelEnum> criminalLevel = LevelEnum.of(criminal.getLevel());
		if (criminalLevel.isPresent())
			switch (criminalLevel.get()) {
			case COUNSELOR:
				criminal.setWeight(counselorWigth--);
				family.add(criminal);
				break;
			case SERGEANT:
				lastSargeant = criminal;
				criminal.setWeight(sergeantWeigth--);
				family.add(criminal);
				break;
			case BADASS:
				if (lastSargeant.getBadass() == null) {
					lastSargeant.setBadass(new ArrayList<>());
				}
				lastSargeant.getBadass().add(criminal);
				break;
			default:
				criminal.setWeight(criminalLevel.get().getLevel());
				family.add(criminal);
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
