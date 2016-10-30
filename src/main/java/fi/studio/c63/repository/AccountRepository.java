package fi.studio.c63.repository;

import fi.studio.c63.domain.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account, Long> {
    Optional<Account> findOneByEmail(String email);

    Optional<Account> findOneById(Long userId);
}
