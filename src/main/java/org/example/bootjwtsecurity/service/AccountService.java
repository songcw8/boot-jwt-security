package org.example.bootjwtsecurity.service;

import lombok.RequiredArgsConstructor;
import org.apache.coyote.BadRequestException;
import org.example.bootjwtsecurity.auth.JwtProvider;
import org.example.bootjwtsecurity.model.dto.UserRegisterDTO;
import org.example.bootjwtsecurity.model.entity.Account;
import org.example.bootjwtsecurity.repository.AccountRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountService {
    private final AccountRepository accountRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtProvider jwtProvider;

    public void register(UserRegisterDTO dto) throws BadRequestException {
        if(dto.username().isEmpty() || dto.password().isEmpty()){
            throw new BadRequestException("잘못된 입력!");
        }
        Account account = new Account();
        account.setUsername(dto.username());
        account.setPassword(passwordEncoder.encode(dto.password()));
        accountRepository.save(account);
    }

    public String login(UserRegisterDTO dto) throws BadRequestException{
        if(dto.username().isEmpty() || dto.password().isEmpty()){
            throw new BadRequestException("잘못된 입력!");
        }
        return "";
    }
}
