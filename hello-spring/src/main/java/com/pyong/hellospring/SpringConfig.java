package com.pyong.hellospring;

import com.pyong.hellospring.repository.MemberRepository;
import com.pyong.hellospring.repository.MemoryMemberRepository;
import com.pyong.hellospring.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }
}
