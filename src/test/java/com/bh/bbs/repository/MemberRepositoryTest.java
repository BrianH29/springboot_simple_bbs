/*
package com.bh.bbs.repository;

import com.bh.bbs.domain.Member;
import com.bh.bbs.service.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional(readOnly = true)
class MemberRepositoryTest {

    @Autowired MemberService ms;
    @Autowired MemberRepository mr;

    @Test
    @Transactional
    void save() throws Exception{
        //Given
        Member m = new Member();
        m.setName("Tom");

        //When
        Member saveId = mr.save(m);

        //Then
        Member findMember = mr.findOne(saveId);
        Assertions.assertThat(findMember.getId()).isEqualTo(m.getId());
        Assertions.assertThat(findMember.getName()).isEqualTo(m.getName());
    }

}
*/