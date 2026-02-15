package com.even.exercice.Repository;

import com.even.exercice.Dto.DailyAvgDto;
import com.even.exercice.Entity.Seller;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface SellerRepository extends CrudRepository<Seller, Integer> {
    @Query("SELECT new com.even.exercice.Dto.DailyAvgDto(se.sellerName, COUNT(sa.id)) " +

            "FROM Sale sa INNER JOIN Seller se " +
            "     ON sa.seller.sellerId = se.sellerId " +

            "WHERE sa.saleDate BETWEEN ?1 AND ?2 " +

            "GROUP BY se.sellerId, se.sellerName")
    public List<DailyAvgDto> getSaleRange(LocalDate begin, LocalDate end);
}
