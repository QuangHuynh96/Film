package com.example.a09cinema_backenddevelop.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.example.a09cinema_backenddevelop.model.entity.Account;

import java.util.List;

@Repository
public interface AccountStatisticRepository extends JpaRepository<Account, Long> {

    @Query(value = "select a.fullname, a.account_code, count(b.booking_code) amount, sum(b.total_price) money, sum(a.total_point) point \n" +
            "      from account as a \n" +
            "      join booking as b on a.id = b.account_id\n" +
            "      where b.day_time_booking = curdate() group by b.day_time_booking", nativeQuery = true)
    List<Account> findAllByAccount();

}
