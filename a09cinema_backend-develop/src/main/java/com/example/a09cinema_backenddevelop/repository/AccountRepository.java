package com.example.a09cinema_backenddevelop.repository;

import com.example.a09cinema_backenddevelop.model.entity.Account;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;


@Repository
public interface AccountRepository extends JpaRepository<Account,Long> {
    @Query(
            value = "select * from account inner join account_role on account.id= account_role.account_id WHERE account.deleted=0 and account_role.role_id=2",
            countQuery = "select COUNT(*) from account inner join account_role on account.id= account_role.account_id where account.deleted=0 and account_role.role_id=2"
            ,nativeQuery = true)
    Page<Account> getAllEmployee(Pageable pageable);
    @Query(
            value = "select * from account inner join account_role on account.id= account_role.account_id " +
                    "where account.deleted=0 and account_role.role_id=2 and (account.id like concat(:search,'%') " +
                    "or account.fullname like concat('%',:search,'%') or account.id_card like concat(:search,'%') " +
                    "or account.email like concat(:search,'%') or account.phone like concat(:search,'%') " +
                    "or account.address like concat('%',:search,'%'))",
            countQuery = "select COUNT(*) from account inner join account_role on account.id= account_role.account_id " +
                    "where account.deleted=0 and account_role.role_id=2 and(account.id like concat(:search,'%') " +
                    "or account.fullname like concat('%',:search,'%') or account.id_card like concat(:search,'%')  " +
                    "or account.email like concat(:search,'%') or account.phone like concat(:search,'%') " +
                    "or account.address like concat('%',:search,'%'))"
            ,nativeQuery = true)
    Page<Account> getSearchAllEmployee(Pageable pageable, String search);

    @Transactional
    @Modifying
    @Query(value = "update `account` set account.deleted = true where account.id=?1", nativeQuery = true)
    void deleteEmployeeAccountById(Long id);

}
