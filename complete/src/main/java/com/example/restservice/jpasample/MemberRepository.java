package com.example.restservice.jpasample;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@RepositoryRestResource
public interface MemberRepository extends JpaRepository<Member, Long> {

    Member findByName(String name);
}
