package com.hks.yellowumbrella.repository;

import com.hks.yellowumbrella.domain.Hello;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HelloRepository extends JpaRepository<Hello, Long> {
}
