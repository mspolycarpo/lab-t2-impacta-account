package br.com.lab.impacta.account.application.impl;

import br.com.lab.impacta.account.application.AccountApplication;
import br.com.lab.impacta.account.application.dto.request.DebitAccountRequest;
import br.com.lab.impacta.account.application.dto.response.AccountBalanceResponse;
import br.com.lab.impacta.account.application.dto.response.DebitAccountResponse;
import br.com.lab.impacta.account.domain.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;

public class AccountApplicationImpl implements AccountApplication {


    @Autowired
    private AccountService accountService;

    @Override
    public AccountBalanceResponse getBalance(Long accountId) {
        return null;
    }

    @Override
    public DebitAccountResponse debit(Long accountId, DebitAccountRequest debitAccountRequest) {
        accountService.debit(accountId,debitAccountRequest.getValueOfDebit());

        return new DebitAccountResponse(true);
    }
}
