package com.bh.bbs;

import com.bh.bbs.repository.MemberRepository;
import com.bh.bbs.repository.MemoryMemberRepository;
import com.bh.bbs.service.MemberServiceImpl;
import org.springframework.context.annotation.Bean;

public class SpringConfig {

    private final MemberRepository mr;

    public SpringConfig(MemberRepository mr) {
        this.mr = mr;
    }

    @Bean
    public MemberServiceImpl ms(){
        return new MemberServiceImpl(mr);
    }

    @Bean
    public MemberRepository memberRepository(){
        return new MemoryMemberRepository();
    }
}
