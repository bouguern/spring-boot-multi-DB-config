package bouguern.tuto.demo.user;

import org.springframework.stereotype.Component;

@Component
public class UserMapper {

	public static UserDto toUserDto(User userEntity) {

		if (userEntity == null)
			return null;

		return UserDto.builder()
				.userId(userEntity.getUserId())
				.username(userEntity.getUsername())
				.birthDay(userEntity.getBirthDay())
				.build();
	}

	public static User toUserEntity(UserDto userDto) {

		if (userDto == null)
			return null;

		return User.builder()
				.userId(userDto.getUserId())
				.username(userDto.getUsername())
				.birthDay(userDto.getBirthDay())
				.build();
	}

}
