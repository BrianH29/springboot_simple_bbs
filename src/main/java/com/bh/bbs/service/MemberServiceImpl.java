package com.bh.bbs.service;

import com.bh.bbs.domain.Member;
import com.bh.bbs.repository.MemberRepository;
import com.bh.bbs.repository.MemoryMemberRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public class MemberServiceImpl implements MemberService {

    public final MemberRepository mr;

    public MemberServiceImpl(MemberRepository mr) {
        this.mr = mr;
    }

    @Override
    public int join(Member member) {
       validateMember(member);
        mr.save(member);
        return member.getMemNo();
    }

    @Override
    public void validateMember(Member member){
        Optional<Member> result = mr.findByEmail(member.getEmail());
        result.ifPresent(m -> {
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        });
    }

    @Override
    public List<Member> findMembers() {
        return mr.findAll();
    }

    @Override
    public Optional<Member> findOne(int memNo) {
        return mr.findById(memNo);
    }
}
