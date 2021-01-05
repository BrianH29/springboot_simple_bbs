package com.bh.bbs.service;

import com.bh.bbs.domain.Member;
import com.bh.bbs.repository.MemberRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import org.assertj.core.api.Assertions;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;


@SpringBootTest
@Transactional
class MemberServiceTest {

    @Autowired MemberService ms;
    @Autowired MemberRepository mr;

    @Test
    void join() throws Exception{
        //Given
        Member m = new Member();
        m.setName("Tom");

        //when
        Long saveId = ms.join(m);

        //then
        Assertions.assertThat(m).isEqualTo(mr.findOne(saveId));
    }

    @Test
    void validateMember() throws Exception{
        Member m1 = new Member();
        m1.setName("Tom");

        Member m2 = new Member();
        m2.setName("Tom");

        ms.join(m1);
        try{
            ms.join(m2);
        }catch(IllegalStateException e){
            return;
        }

        fail("예외가 발생했습니다.");
    }

}