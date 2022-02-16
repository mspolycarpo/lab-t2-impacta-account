package br.com.lab.impacta.account.infrastructure.repository;

import br.com.lab.impacta.account.domain.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


//Essa interface está para um port de repositorio de dados

@Repository
public interface AccountRepository  extends JpaRepository<Account,Long> {

}
