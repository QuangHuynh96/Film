package com.example.a09cinema_backenddevelop.repository;

import com.example.a09cinema_backenddevelop.model.entity.Account;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account,Long> {
    @Query(value= "select * from account left join account_role on account.id = account_role.account_id where account_role.role_id = 1",
            nativeQuery = true)
    Page<Account> findAll(@Param("fullname") String fullname, Pageable pageable);

    @Query(value= "select * from account where id = :id", nativeQuery = true)
    Account findAccountId(@Param("id") long id);
}
