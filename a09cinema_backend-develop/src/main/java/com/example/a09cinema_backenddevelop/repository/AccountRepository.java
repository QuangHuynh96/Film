package com.example.a09cinema_backenddevelop.repository;

import com.example.a09cinema_backenddevelop.model.entity.Account;
import org.springframework.data.domain.*;
import org.springframework.data.jpa.repository.*;

import org.springframework.data.repository.query.*;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
    @Query(value = "select * from account left join account_role on account.id = account_role.account_id where account_role.role_id = 1",
            nativeQuery = true)
    Page<Account> findAll(Pageable pageable);

    @Query(value = "select * from account where id = :id", nativeQuery = true)
    Optional<Account> findAccountId(@Param("id") long id);

}
