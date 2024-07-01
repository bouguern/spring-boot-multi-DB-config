package bouguern.tuto.demo.user;

import org.springframework.stereotype.Service;

import bouguern.tuto.demo.exceptions.ResourceNotFoundException;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {
	
	private final UserRepository userRepository;

	@Override
	public UserDto createUser(UserDto userDto) {
		
		log.info("Creating a new User -> {}", userDto);

		return UserMapper.toUserDto(userRepository.save(UserMapper.toUserEntity(userDto)));
	}

	@Override
	public UserDto getByUserId(Long userId) throws ResourceNotFoundException {
		
		log.info("Finding the user with userID : {}", userId);
		return UserMapper.toUserDto(userRepository.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User with id " + userId + " not found")));
	}


}
