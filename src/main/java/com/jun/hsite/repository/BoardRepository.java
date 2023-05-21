package com.jun.hsite.repository;

import com.jun.hsite.domain.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface BoardRepository extends JpaRepository<Board, Long> {

    @Modifying
    @Query("update Board b set b.viewCount = b.viewCount + 1 where b.id = :id")
    int updateViewCount(@Param("id")Long id);
}
