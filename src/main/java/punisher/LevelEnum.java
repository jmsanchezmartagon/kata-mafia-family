package punisher;

public enum LevelEnum {

	LEADER(1, "Leader"), COUNSELOR(2, "Counselor"), SERGEANT(3, "Sergeant"), BADASS(4, "Bad Ass");

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
	
	public static LevelEnum instanceOf(String levelName) {
		for (LevelEnum l :LevelEnum.values()) {
			if (l.name.equals(levelName))
				return l;
		}
		return null;
	}
}
