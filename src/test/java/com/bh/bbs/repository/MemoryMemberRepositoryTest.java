package com.bh.bbs.repository;

import com.bh.bbs.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class MemoryMemberRepositoryTest {

    MemoryMemberRepository repository = new MemoryMemberRepository();

    @AfterEach
    public void afterEach(){
        repository.clearStore();
    }

    @Test
    void save() {
        Member member = new Member();
        member.setMemName("Tom");
        member.setEmail("tom@gmail.com");

        repository.save(member);

        Member result = repository.findById(member.getMemNo()).get();
        assertThat(member).isEqualTo(result);

    }

    @Test
    void findByName() {
        Member mem1 = new Member();
        mem1.setMemName("Tom");
        repository.save(mem1);

        Member mem2 = new Member();
        mem2.setMemName("Jerry");
        repository.save(mem2);

        Member result = repository.findByName("Tom").get();
        assertThat(result).isEqualTo(mem1);
    }


    @Test
    void findAll() {
        Member mem1 = new Member();
        mem1.setMemName("Tom");
        repository.save(mem1);

        Member mem2 = new Member();
        mem2.setMemName("Jerry");
        repository.save(mem2);

        List<Member> list = repository.findAll();
        assertThat(list.size()).isEqualTo(2);
    }

    @Test
    void findByEmail(){
        Member mem1 = new Member();
        mem1.setEmail("tom@gmail.com");
        repository.save(mem1);

        Member mem2 = new Member();
        mem2.setEmail("jerry@gmail.com");
        repository.save(mem2);

        Member result = repository.findByEmail("tom@gmail.com").get();
        assertThat(result).isEqualTo(mem1);
    }
}