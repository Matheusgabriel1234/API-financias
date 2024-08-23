package desafio.matheus.desafio_tabela_financias;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.any;


import java.util.List;
import java.util.Optional;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import desafio.matheus.desafio_tabela_financias.dto.UserDTO;
import desafio.matheus.desafio_tabela_financias.dto.UserViewDTO;
import desafio.matheus.desafio_tabela_financias.entities.DataUser;
import desafio.matheus.desafio_tabela_financias.exceptions.EmailAlreadyExistException;
import desafio.matheus.desafio_tabela_financias.exceptions.UserNotFoundException;
import desafio.matheus.desafio_tabela_financias.repository.UserRepository;
import desafio.matheus.desafio_tabela_financias.service.UserService;

public class UserServiceTest {

@Mock
private UserRepository userRepo;

@InjectMocks
private UserService userService;

@BeforeEach
void setUp() {
	MockitoAnnotations.openMocks(this);
}
	

@Test
void testGetAll() {
	Long userId = 1L;
	DataUser user = new DataUser();
	user.setId(userId);
	user.setFirstName("teste");
	user.setLastName("primeiro");
	user.setEmail("teste@gmail.com");
    
	UserViewDTO userViewDto = new UserViewDTO(user);
    
	when(userRepo.findAll()).thenReturn(List.of(user));
	
	List<UserViewDTO> result = userService.getAll();
	
	verify(userRepo,times(1)).findAll();
	
	assertEquals(1, result.size());
	assertEquals(userViewDto,result.get(0));
	
}

@Test
void testgetUserbyId() {
	Long userId = 1L;
    DataUser user = new DataUser();
    user.setId(userId);
    user.setFirstName("Matheus");
    user.setLastName("Gabriel");
    user.setEmail("magaje2005@gmail.com");
    
    when(userRepo.findById(userId)).thenReturn(Optional.of(user));
    
    UserViewDTO result = userService.getById(userId);
    
    assertEquals(userId, result.id());
    assertEquals("Matheus", result.firstName());
    assertEquals("Gabriel", result.lastName());
    assertEquals("magaje2005@gmail.com", result.email());
    
    
}


@Test
void testCreateUserEmailAlreadyRegistred() {

	
	 UserDTO userDto = new UserDTO("Gabriel", "Matheus", "already@registered.com", "password", null);
     when(userRepo.existsByEmail(userDto.email())).thenReturn(true);
      EmailAlreadyExistException thrown = assertThrows(EmailAlreadyExistException.class, () -> {
         userService.create(userDto);
     });

     assertEquals("The email: already@registered.com already exists", thrown.getMessage());


}
@Test
void testUserNotFound() {
	Long userId = 1L;
	when(userRepo.findById(userId)).thenReturn(Optional.empty());
	
	UserNotFoundException throwns =  assertThrows(UserNotFoundException.class, ()-> userService.getById(userId));
	
	assertEquals(userId, throwns.getUserId());
}



@Test
void testCreate_sucess() {
	 UserDTO userdto = new UserDTO("Gabriel","Matheus", "newUser@example.com", "Password", null);
	 
	 DataUser savedUserEntity = new DataUser();
	 savedUserEntity.setId(1L);
     savedUserEntity.setFirstName("Matheus");
     savedUserEntity.setLastName("Gabriel");
     savedUserEntity.setEmail("newuser@example.com");
     savedUserEntity.setPassword("password");
     
     when(userRepo.existsByEmail(userdto.email())).thenReturn(false);
     when(userRepo.save(any(DataUser.class))).thenReturn(savedUserEntity);
     
     UserDTO result = userService.create(userdto);
     assertEquals("Gabriel", result.firstName());
     assertEquals("Matheus", result.lastName());
     assertEquals("newuser@example.com", result.email());
     
     verify(userRepo).save(any(DataUser.class));

}





}
