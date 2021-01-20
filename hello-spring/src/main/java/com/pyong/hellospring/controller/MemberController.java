package com.pyong.hellospring.controller;

import com.pyong.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class MemberController {

    /**
     * DI 필드 주입
     * 권장하지 않음
     * */
    //@Autowired
    private final MemberService memberService;

    /**
     * DI Setter 주입
     * 주의! 스프링 빈으로 등록이 되면 변경할 일이 거의 없다.
     * 그러나 setter는 접근지정자가 public이여서 공개적으로 접근 가능하기 때문에 객체가 변경될 수 있다.
     * 의도와 다르게 변경될 경우 에러를 야기한다.
     * */
//    @Autowired
//    public void setMemberService(MemberService memberService) {
//        this.memberService = memberService;
//    }

    /**
     * DI 생성자 주입
     * 기본적으로 권장하는 방식
     * */
    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }
}
