package fi.studio.c63.service;

import fi.studio.c63.domain.Account;
import fi.studio.c63.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class AccountService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AccountRepository accountRepository;

    public Optional<Account> requestPasswordReset(String email) {
        return accountRepository.findOneByEmail(email)
                .map(account -> {
                    //TODO: set logic to reset password here.
                    return account;
                });
    }

    public Account createAccount(String username, String password, String email) {
        Account account = new Account();
        String passwordHash = passwordEncoder.encode(password);
        account.setEmail(email);
        account.setPassword(passwordHash);
        account.setUsername(username);
        accountRepository.save(account);
        return account;
    }

    public Optional<Account> updateAccount(Long accountId, String username) {
        return accountRepository.findOneById(accountId)
                .map(account -> {
                    account.setUsername(username);
                    accountRepository.save(account);
                    return account;
                });
    }

    public void changePassword(String password, String email) {
        accountRepository.findOneByEmail(email)
                .map(account -> {
                    account.setPassword(passwordEncoder.encode(password));
                    accountRepository.save(account);
                    return account;
                });
    }

    public Optional<Account> login(Account.LoginObject loginObject) {
        return accountRepository.findOneByEmail(loginObject.getEmail())
                .map(account -> {
                    if (passwordEncoder.matches(loginObject.getPassword(), account.getPassword())) {
                        return account;
                    }
                    return null;
                });
    }
}
