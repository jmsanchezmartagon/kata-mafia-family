package punisher;

import java.util.Comparator;

public enum CriminalSort implements Comparator<Criminal> {
	LEVEL;

	public int compare(Criminal o1, Criminal o2) {
		if (o1 != o2 &&!o1.getLevel().equals(o2.getLevel())) {
					return Integer.compare(LevelEnum.instanceOf(o1.getLevel()).getLevel(),
					        LevelEnum.instanceOf(o2.getLevel()).getLevel()) ;
		}
		return 0;
	}

}
