package com.bh.bbs.repository;

import com.bh.bbs.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {

    //회원저장
    Member save(Member member);

    //아이디로 찾기
    Optional<Member> findById(int memNo);

    //회원 이름으로 찾기
    Optional<Member> findByName(String memName);

    //회원 전체 출력
    List<Member> findAll();

    //이메일 회원 찾기
    Optional<Member> findByEmail(String email);

}
