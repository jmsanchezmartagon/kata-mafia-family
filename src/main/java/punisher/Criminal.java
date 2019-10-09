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
	private List<Criminal> badass;
}
