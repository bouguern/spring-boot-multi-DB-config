package bouguern.tuto.demo.user;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDto {

	private Long userId;
	private String username;
	private LocalDate birthDay; // 2023-06-12 = 'yyyy-MM-dd'

}
