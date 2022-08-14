package com.example.a09cinema_backenddevelop.repository;

import com.example.a09cinema_backenddevelop.model.entity.Account;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<Account,Long> {
    @Query(value= "select * from account left join account_role on account.id = account_role.account_id where account_role.role_id = 1",
            nativeQuery = true)
    Page<Account> findAll(Pageable pageable);

    @Query(value= "select * from account where id = :id", nativeQuery = true)
    Optional<Account> findAccountId(@Param("id") long id);

//    @Modifying
//    @Query(value= "update Account set fullname = :fullname, password = :password, birthday = :birthday, gender = :gender, email = :email, phone = :phone, address = :address where id = :id",
//            nativeQuery = true)
//    void editMember(Long id, String fullname, String password, LocalDate birthday, String gender, String email, String phone, String address);
}
