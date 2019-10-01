package punisher;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
class Criminal {

	@Getter
	private String name;
	@Getter
	private String lastName;
	@Getter
	private String nick;
	@Getter
	private String family;
	@Getter
	private String level;

//	public Criminal() {
//	}
//
//	public Criminal(String name, String lastName, String nick, String family, String level) {
//		super();
//		this.name = name;
//		this.lastName = lastName;
//		this.nick = nick;
//		this.family = family;
//		this.level = level;
//	}

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

}
