package com.bh.bbs.service;

import com.bh.bbs.domain.Member;
import com.bh.bbs.repository.MemberRepository;
import com.bh.bbs.repository.MemoryMemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class MemberServiceImplTest {

    MemberService memberService;
    MemoryMemberRepository mmr;

    @BeforeEach
    public void beforeEach(){
        mmr = new MemoryMemberRepository();
        memberService = new MemberServiceImpl(mmr);
    }
    @AfterEach
    public void afterEach() {
        mmr.clearStore();
    }

    @Test
    void join() {
        //given
        Member member = new Member();
        member.setMemName("Tom");
        member.setEmail("tom@gmail.com");

        //when
        int memNo = memberService.join(member);

        //then
        Member findMember = memberService.findOne(memNo).get();
        assertThat(member.getMemName()).isEqualTo(findMember.getMemName());
    }

    @Test
    void validateMember() {
        //given
        Member mem1 = new Member();
        mem1.setEmail("tom@gmail.com");

        Member mem2 = new Member();
        mem2.setEmail("tom@gmail.com");

        //when
        memberService.join(mem1);

        //then
       IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(mem2));
       assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
    }

}