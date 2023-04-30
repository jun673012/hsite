package com.jun.hsite.repository;

import com.jun.hsite.domain.Board;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board, Long> {
}
