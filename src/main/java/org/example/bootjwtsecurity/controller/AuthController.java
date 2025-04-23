package org.example.bootjwtsecurity.controller;

import lombok.RequiredArgsConstructor;
import org.apache.coyote.BadRequestException;
import org.example.bootjwtsecurity.model.dto.UserRegisterDTO;
import org.example.bootjwtsecurity.service.AccountService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AccountService accountService;

    @PostMapping("/register") //등록
    public ResponseEntity<Void> register(@RequestBody UserRegisterDTO dto) throws BadRequestException {
        accountService.register(dto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PostMapping("/token")
    public ResponseEntity<String> getToken(@RequestBody UserRegisterDTO dto){
        return ResponseEntity.ok().body("token");
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<String> handleBadRequestException(BadRequestException e){
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
