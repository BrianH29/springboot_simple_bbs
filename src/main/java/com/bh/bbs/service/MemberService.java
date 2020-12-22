package com.bh.bbs.service;

import com.bh.bbs.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberService {

    /**
     * 회원가입
     */
    public int join(Member member);

    /**
     * 회원 이메일로 중복 조회
     */
    public void validateMember(Member member);

    /**
     * 전체회원조회
     */
    public List<Member> findMembers();
    public Optional<Member> findOne(int memNo);


}
