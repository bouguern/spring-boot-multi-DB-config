package bouguern.tuto.demo.user;

import bouguern.tuto.demo.exceptions.ResourceNotFoundException;

public interface UserService {

	public UserDto createUser(UserDto userDto);

	public UserDto getByUserId(Long userId) throws ResourceNotFoundException;

}
