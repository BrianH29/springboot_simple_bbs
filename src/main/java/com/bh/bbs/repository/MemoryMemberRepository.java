package com.bh.bbs.repository;

import com.bh.bbs.domain.Member;

import java.util.*;

public class MemoryMemberRepository implements MemberRepository{
    private static Map<Integer, Member> store = new HashMap<>();
    private static int sequence = 0;

    @Override
    public Member save(Member member) {
        member.setMemNo(++sequence);
        store.put(member.getMemNo(), member);
        return member;
    }

    @Override
    public Optional<Member> findById(int memNo) {
        return Optional.ofNullable(store.get(memNo));
    }

    @Override
    public Optional<Member> findByName(String memName) {
        return store.values().stream()
                .filter(member -> member.getMemName().equals(memName))
                .findAny();
    }

    @Override
    public List<Member> findAll() {
        List<Member> list = new ArrayList<>(store.values());
        return list;
    }

    @Override
    public Optional<Member> findByEmail(String email) {
        return store.values().stream()
                .filter(member -> member.getEmail().equals(email))
                .findAny();
    }

    public void clearStore(){
        store.clear();
    }
}
