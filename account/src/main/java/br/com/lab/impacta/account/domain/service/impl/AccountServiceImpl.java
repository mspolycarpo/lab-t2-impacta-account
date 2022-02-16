package br.com.lab.impacta.account.domain.service.impl;

import br.com.lab.impacta.account.domain.exception.AccountNotFoundException;
import br.com.lab.impacta.account.domain.exception.AccountWithoutBalanceException;
import br.com.lab.impacta.account.domain.model.Account;
import br.com.lab.impacta.account.domain.service.AccountService;
import br.com.lab.impacta.account.infrastructure.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import java.util.Optional;


//Implementação está para domain layer service na arquitetura hexagonal
public class AccountServiceImpl implements AccountService {


    @Autowired
    private AccountRepository accountRepository;

    @Value("$lab.account.exception.account-dont-exists-message")
    private String messageExceptionAccountNotFound;

    @Value("$lab.account.exception.account-dont-exists-description")
    private String descriptionExceptionAccountNotFound;

    @Value("$lab.account.exception.account-dont-exists-message")
    private String messageExceptionAccountWithoutBalance;

    @Value("$lab.account.exception.account-dont-exists-description")
    private String descriptionExceptionAccountWithoutBalance;

    @Override
    public Account find(Long accountId) {
        Optional<Account> account = accountRepository.findById(accountId);
        if (account.isEmpty()){
            throw new AccountNotFoundException(messageExceptionAccountNotFound,descriptionExceptionAccountNotFound);
        }

        return account.get();
    }

    @Override
    public void debit(Long accountId, Double valueOfDebit) {
        Account account = this.find(accountId);

        boolean debited = account.debit(valueOfDebit);

        if(!debited)
            throw new AccountWithoutBalanceException(messageExceptionAccountWithoutBalance,descriptionExceptionAccountWithoutBalance);

        this.accountRepository.save(account);
    }
}
