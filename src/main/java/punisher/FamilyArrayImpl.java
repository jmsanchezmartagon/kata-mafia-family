package punisher;

import java.util.ArrayList;
import java.util.Iterator;

public class FamilyArrayImpl implements Family{

	private static final int LEADER = 0;
	private static final int COUNSELOR1 = 1;
	private static final int COUNSELOR2 = 2;
	private static final int SERGEANT1 = 3;
	private static final int SERGEANT2 = 4;
	private static final int SERGEANT3 = 5;
	private static final int SERGEANT4 = 6;

	
	/**
	 * l0 C1 C4 S2 S3 S5 S6
	 */
	private Criminal[] family = null;
	private Criminal lastSargeant = null;
	private int max =0;

	public FamilyArrayImpl() {
		family = new Criminal[7];
	}

	public void add(Criminal criminal) {
		if (LevelEnum.LEADER.getLabel().equalsIgnoreCase(criminal.getLevel())) {
			lastSargeant = null;
			family[LEADER] = criminal;
			if (max<LEADER)
				max = LEADER;
		} else {
			if (LevelEnum.COUNSELOR.getLabel().equalsIgnoreCase(criminal.getLevel())) {
				lastSargeant = null;
				if (family[COUNSELOR1] == null) {
					family[COUNSELOR1] = criminal;
					if (max<COUNSELOR1)
						max = COUNSELOR1;
				} else {
					family[COUNSELOR2] = criminal;
					if (max<COUNSELOR2)
						max = COUNSELOR2;
				}
			} else {
				if (LevelEnum.SERGEANT.getLabel().equalsIgnoreCase(criminal.getLevel())) {
					lastSargeant = criminal;
					if (family[SERGEANT1] == null) {
						family[SERGEANT1] = criminal;
						if (max<SERGEANT1)
							max = SERGEANT1;
					} else {
						if (family[SERGEANT2] == null) {
							family[SERGEANT2] = criminal;
							if (max<SERGEANT2)
								max = SERGEANT2;
						} else {
							if (family[SERGEANT3] == null) {
								family[SERGEANT3] = criminal;
								if (max<SERGEANT3)
									max = SERGEANT3;
							} else {
								family[SERGEANT4] = criminal;
								if (max<SERGEANT4)
									max = SERGEANT4;
							}
						}
					}
				} else {
					if (lastSargeant.getBadass() == null) {
						lastSargeant.setBadass(new ArrayList<>());
					}
					lastSargeant.getBadass().add(criminal);
				}
			}
		}
	}

	public Iterator<Criminal> iterator() {
		return new FamilyIterator(family);
	}

	private final class FamilyIterator implements Iterator<Criminal> {
		private Criminal[] family;
		private int pointer = 0;
		private int max = 0;
		private Iterator<Criminal> badassIterator = null;

		public FamilyIterator(Criminal[] family) {
			this.family = family;
		}

		@Override
		public boolean hasNext() {
			return pointer <= max
			        || badassIterator != null && badassIterator.hasNext();
		}

		@Override
		public Criminal next() {
			Criminal criminal = null;
			if (badassIterator != null && badassIterator.hasNext()) {
				criminal = badassIterator.next();
			} else {
				criminal = family[pointer++];
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
