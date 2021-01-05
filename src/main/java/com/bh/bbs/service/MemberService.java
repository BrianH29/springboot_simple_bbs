package com.bh.bbs.service;

import com.bh.bbs.domain.Member;
import com.bh.bbs.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MemberService {

    public final MemberRepository mr;

    @Transactional
    public Long join(Member member) {
       validateMember(member);
        mr.save(member);
        return member.getId();
    }

    public void validateMember(Member member){
        List<Member> result = mr.findByName(member.getName());
        if(!result.isEmpty()){
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        }
    }

    public Member findOne(Long id) {
        return mr.findOne(id);
    }

    public List<Member> findMembers(){
        return mr.findAll();
    }
}
