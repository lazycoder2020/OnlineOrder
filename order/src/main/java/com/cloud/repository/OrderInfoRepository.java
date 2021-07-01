package com.cloud.repository;

import com.cloud.entity.Order;
import com.cloud.entity.OrderInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

public interface OrderInfoRepository extends JpaRepository<OrderInfo, Long> {

    @Query(value = "select new com.cloud.entity.Order(oi, u, a, m) from OrderInfo oi " +
            "left join Menu m ON oi.mid = m.id " +
            "left join User u on oi.uid = u.id " +
            "left join Admin a on oi.aid = a.id where oi.uid = ?1  order by oi.id")
    public Page<Order> findAllByUid(long uid, Pageable pageable);

    @Query(value = "select new com.cloud.entity.Order(oi, u, a, m) from OrderInfo oi " +
            "left join Menu m ON oi.mid = m.id " +
            "left join User u on oi.uid = u.id " +
            "left join Admin a on oi.aid = a.id where oi.state = ?1  order by oi.id")
    public Page<Order> findAllByState(int state, Pageable pageable);

    @Modifying
    @Transactional
    @Query(value = "delete from t_order where mid = ?1", nativeQuery = true)
    public void deleteByMid(long mid);

    @Modifying
    @Transactional
    @Query(value = "delete from t_order where uid = ?1", nativeQuery = true)
    public void deleteByUid(long uid);

    @Modifying
    @Transactional
    @Query(value = "update t_order set aid = ?2, state = ?3 where id = ?1", nativeQuery = true)
    public void updateState(long id, long aid, long state);
}
