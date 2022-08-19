package com.example.a09cinema_backenddevelop.repository;

import com.example.a09cinema_backenddevelop.model.entity.Account;
import com.example.a09cinema_backenddevelop.model.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
    @Modifying
    @Transactional
    @Query(value = "UPDATE Account SET password = :newPassword WHERE id = :id", nativeQuery = true)
    void updatePassword(Long id, String newPassword);

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

}
