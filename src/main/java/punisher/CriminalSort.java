package punisher;

import java.util.Comparator;
import java.util.Optional;

enum CriminalSort implements Comparator<Criminal> {
	LEVEL;

	public int compare(Criminal o1, Criminal o2) {
		if (o1 != o2 && !o1.getLevel().equals(o2.getLevel())) {
			
			Optional<LevelEnum> levelCriminal1 = LevelEnum.of(o1.getLevel());
			Optional<LevelEnum> levelCriminal2 = LevelEnum.of(o2.getLevel());
			if (levelCriminal1.isEmpty() && levelCriminal2.isPresent()) {
				return -1;
			} else {
				if (levelCriminal1.isPresent() && levelCriminal2.isEmpty()) {
					return 1;
				} else {
					if (levelCriminal1.isPresent() && levelCriminal2.isPresent()) {
						return Integer.compare(levelCriminal1.get().getLevel(), levelCriminal2.get().getLevel());
					}
				}
			}
		}
		
		if (o1.getWeight() !=o2.getWeight()) {
			return o1.getWeight().compareTo(o2.getWeight());
		}
		return 0;
	}

}
