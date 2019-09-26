package punisher;

public class Criminal {

	private String name;
	private String lastName;
	private String nick;
	private String family;
	private String level;

	public Criminal() {
	}

	public Criminal(String name, String lastName, String nick, String family, String level) {
		super();
		this.name = name;
		this.lastName = lastName;
		this.nick = nick;
		this.family = family;
		this.level = level;
	}

	@Override
	public int hashCode() {
		return super.hashCode();
	}

	@Override
	public boolean equals(Object o) {
		if (o == this) {
			return true;
		}
		if (!(o instanceof Criminal)) {
			return false;
		}
		Criminal c = (Criminal) o;

		return (name == c.name || name != null && c.name != null && name.equals(c.name))
		        && (lastName == c.lastName || lastName != null && c.lastName != null && lastName.equals(c.lastName))
		        && (nick == c.nick || nick != null && c.nick != null && nick.equals(c.nick))
		        && (family == c.family || family != null && c.family != null && family.equals(c.family))
		        && (level == c.level || level != null && c.level != null && level.equals(c.level));
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFamily() {
		return family;
	}

	public void setFamily(String family) {
		this.family = family;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

}
