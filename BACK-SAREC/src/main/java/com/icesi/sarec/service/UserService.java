package com.icesi.sarec.service;



import com.icesi.sarec.dto.UserDTO;
import com.icesi.sarec.error.exception.ApplicationError;
import com.icesi.sarec.error.exception.ApplicationException;
import com.icesi.sarec.error.exception.ErrorCode;
import com.icesi.sarec.mapper.UserMapper;
import com.icesi.sarec.model.Role;
import com.icesi.sarec.model.SarecUser;
import com.icesi.sarec.repository.RoleRepository;
import com.icesi.sarec.repository.UserRepository;
import com.icesi.sarec.security.SarecSecurityContext;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Random;
import java.util.UUID;
import org.springframework.security.crypto.password.PasswordEncoder;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import static com.icesi.sarec.error.util.ErrorManager.createDetail;
import static com.icesi.sarec.error.util.ErrorManager.sendDetails;


@Service
@AllArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final UserMapper mapper;
    private final PasswordEncoder encoder;
    private final SarecSecurityContext securityContext;

    public UserDTO save(UserDTO dto){

        // Validations
        boolean emailExist = userRepository.findByEmail(dto.getEmail()).isPresent();
        boolean phoneExist = userRepository.findByPhoneNumber(dto.getPhoneNumber()).isPresent();
        boolean notPassword = dto.getPassword() == null || dto.getPassword().isEmpty();
        boolean notRole = dto.getRole() == null || dto.getRole().getName() == null || dto.getRole().getName().isEmpty();

        if(emailExist && phoneExist){
            throw new RuntimeException("This email and phone already exist: "+dto.getEmail()+" and "+dto.getPhoneNumber());
        } else if (emailExist) {
            throw new RuntimeException("This email already exist: "+dto.getEmail());
        } else if (phoneExist) {
            throw new RuntimeException("This phone already exist: "+dto.getPhoneNumber());
        } else if (notPassword) {
            throw new RuntimeException("No password provided");
        } else if (notRole) {
            throw new RuntimeException("No role provided");
        }

        SarecUser sarecUser = mapper.fromUserDto(dto);
        sarecUser.setPassword(encoder.encode(dto.getPassword()));
        sarecUser.setId(new Random().nextLong());
        sarecUser.setBalance(0L);

        Role roleRelation  = roleRepository.findByName(sarecUser.getRole().getName()).orElseThrow(() -> new RuntimeException("This role doesn't exist") );

        sarecUser.setRole(roleRelation);
        userRepository.save(sarecUser);
        roleRepository.save(roleRelation);
        return mapper.fromUser(sarecUser);

    }

//    private void checkUserToCreate(UserDTO dto){
//        var currentRole = securityContext.getCurrenUserRole();
//        if(dto.getRole().getName().equalsIgnoreCase("ADMIN") && currentRole.equalsIgnoreCase("BANK")){
//            throw createApplicationException().get();
//        }
//
//    }

    public List<SarecUser> getUsers(){
        return userRepository.findAll();
    }

    private static Supplier<ApplicationException> createApplicationException() {
        return () -> new ApplicationException("Cant create the user", ApplicationError.builder()
                .details(List.of(sendDetails(createDetail("You cant create an user with ADMIN ROLE", ErrorCode.ERROR_USER_TO_CREATE))))
                .status(HttpStatus.FORBIDDEN)
                .build());
    }



}