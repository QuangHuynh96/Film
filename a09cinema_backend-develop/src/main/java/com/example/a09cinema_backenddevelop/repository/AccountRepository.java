package com.example.a09cinema_backenddevelop.repository;

import com.example.a09cinema_backenddevelop.model.entity.Account;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

@Repository
public interface AccountRepository extends JpaRepository<Account,Long> {
    @Query(value= "select * from a0921i1_cinema.account " +
            "left join a0921i1_cinema.account_role " +
            "on a0921i1_cinema.account.id = a0921i1_cinema.account_role.account_id " +
            "where account_role.role_id = 1 and account.username like concat('%', :username , '%')",
           countQuery = "select count(*) from a0921i1_cinema.account left join a0921i1_cinema.account_role on a0921i1_cinema.account.id = a0921i1_cinema.account_role.account_id where account_role.role_id = 1 and account.username like concat('%', :username , '%')",
            nativeQuery = true)
    Page<Account> findAll(@Param("username") String username, Pageable pageable);


//    findByNameContaining
//    Page<Account> findByUsernameContaining (String username, Pageable pageable);

//    @Query(value= "select * from account where id = :id", nativeQuery = true)
//    Account findAccountId(@Param("id") long id);

//    @Modifying
//    @Query(value= "update Account set fullname = :fullname, password = :password, birthday = :birthday, gender = :gender, email = :email, phone = :phone, address = :address where id = :id",
//            nativeQuery = true)
//    void editMember(Long id, String fullname, String password, LocalDate birthday, String gender, String email, String phone, String address);

    @Modifying
    @Transactional
    @Query(value = "UPDATE Account SET fullname = :fullName, birthday = :date, gender = :gender, " +
            "email = :email, id_card = :idCard, phone = :phone, address = :address" +
            " WHERE id = :id", nativeQuery = true)
    void updateInfo(Long id, String fullName, LocalDate date, String gender, String email, String idCard, String phone, String address);

    Account findByUsername(String username);
    Boolean existsByUsername(String username);
    Boolean existsByEmail(String email);

    @Modifying
    @Transactional
    @Query(value ="update account set verification_code = :code where username = :username",nativeQuery = true)
    void addVerificationCode(@Param("code") String code,@Param("username") String username);

    @Query(value = "select * from account where verification_code = :code",nativeQuery = true)
    Account findAccountByVerificationCode(@Param("code") String code);

    @Modifying
    @Transactional
    @Query(value = " update account set password = :password where verification_code= :code",nativeQuery = true)
    void saveNewPassword(@Param("password") String password,@Param("code") String code);

    @Modifying
    @Transactional
    @Query(value = "UPDATE Account SET password = :newPassword WHERE id = :id", nativeQuery = true)
    void updatePassword(Long id, String newPassword);

}
