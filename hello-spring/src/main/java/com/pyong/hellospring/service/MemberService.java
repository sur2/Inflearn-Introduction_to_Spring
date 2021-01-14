package com.pyong.hellospring.service;

import com.pyong.hellospring.domain.Member;
import com.pyong.hellospring.repository.MemberRepository;

import java.util.List;
import java.util.Optional;

public class MemberService {

    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    /**
     * 회원 가입
     */
    public Long join(Member member) {
        // 같은 이름이 중복될 수 없다.
        validateDuplicateMember(member);
        memberRepository.save(member);
        return member.getId();
    }

    // 회원 이름 중복 검출 메서드
    private void validateDuplicateMember(Member member) {
        // Optional이 제공하는 메서드 ifPresent
        memberRepository.findByName(member.getName())
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }

    /**
     * 전체 회원 조회
     */
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
