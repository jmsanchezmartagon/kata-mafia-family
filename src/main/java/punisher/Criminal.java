package punisher;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
	@Getter
	@Setter
	@JsonIgnore
	private Integer weight;
	@Getter
	@Setter
	@JsonIgnore
	private List<Criminal> badass;

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Criminal criminal = (Criminal) obj;

		return (name == criminal.name || name != null && name.equals(criminal.name))
		        && (lastName == criminal.lastName || lastName != null && lastName.equals(criminal.lastName))
		        && (nick == criminal.nick || nick != null && nick.equals(criminal.nick))
		        && (family == criminal.family || family != null && family.equals(criminal.family))
		        && (level == criminal.level || level != null && level.equals(criminal.level))
		        && (weight == criminal.weight || weight != null && weight.equals(criminal.weight))
		        && (badass == criminal.badass || badass != null && badass.equals(criminal.badass));
	}
}
