package punisher;

import java.util.Optional;

enum LevelEnum {

	LEADER(1, "Leader"), COUNSELOR(2, "Counselor"), SERGEANT(4, "Sergeant"), BADASS(10, "Bad Ass");

	private int level;
	private String name;

	private LevelEnum(int level, String name) {
		this.level = level;
		this.name = name;
	}
	
	public int getLevel() {
		return level;
	}
	public String getLabel() {
		return name;
	}
	
	public static Optional<LevelEnum> of(String levelName) {
		for (LevelEnum level :LevelEnum.values()) {
			if (level.name.equalsIgnoreCase(levelName))
				return Optional.of(level);
		}
		return Optional.empty();
	}
}
