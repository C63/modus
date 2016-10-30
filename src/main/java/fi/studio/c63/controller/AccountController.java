package fi.studio.c63.controller;

import fi.studio.c63.domain.Account;
import fi.studio.c63.exceptions.InvalidLoginException;
import fi.studio.c63.repository.AccountRepository;
import fi.studio.c63.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/accounts")
public class AccountController {

    private AccountService accountService;

    private AccountRepository accountRepository;

    @Autowired
    public AccountController(AccountService accountService, AccountRepository accountRepository) {
        this.accountService = accountService;
        this.accountRepository = accountRepository;
    }

    @RequestMapping()
    public
    @ResponseBody
    List<Account> getAllAccount() {
        return accountRepository.findAll();
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public
    @ResponseBody
    Account registerNewAccount(@RequestBody Account account) {

        return accountService.createAccount(account.getUsername(),
                account.getPassword(), account.getEmail());
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public
    @ResponseBody
    Account login(@RequestBody Account.LoginObject loginObject) {
        return accountService.login(loginObject)
                .orElseThrow(InvalidLoginException::new);
    }
}
