package bouguern.tuto.demo.user;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bouguern.tuto.demo.exceptions.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequestMapping("/users")
@RestController
@RequiredArgsConstructor
@Slf4j
public class UserController {

	private final UserService userService;

	@PostMapping
	public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto) {
		log.info("Creating a new User -> {}", userDto);
		UserDto savedUser = userService.createUser(userDto);
		log.info("User created successfully -> {}", savedUser);
		return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
	}

	@GetMapping("/{userId}")
	public ResponseEntity<UserDto> getByUserId(@PathVariable("userId") Long userId) 
			throws ResourceNotFoundException {
		log.info("Searching the user with userId -> {}", userId);
		UserDto returnedUser = userService.getByUserId(userId);
		log.info("The user with userId : {} is found", userId);
		return new ResponseEntity<>(returnedUser, HttpStatus.OK);

	}

}
