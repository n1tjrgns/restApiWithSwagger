package com.example.restservice.jpasample;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
@RepositoryRestResource // 기본 rest api 기능 지원, (collectionResourceRel = "account", path = "account") 옵션으로 키값 url 지정가능
public interface MemberRepository extends JpaRepository<Member, Long> {

    Member findByName(String name);
}
