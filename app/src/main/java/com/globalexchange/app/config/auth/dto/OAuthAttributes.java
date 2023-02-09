/*

package com.globalexchange.app.config.auth.dto;

import com.globalexchange.app.domain.vo.MemberVO;
import lombok.Getter;

import java.util.Map;

@Getter
public class OAuthAttributes {
    private Map<String,Object> attributes;
    private String nameAttributeKey;
    private String name;
    private String email;
    private String picture;

    public OAuthAttributes(Map<String,Object> attributes, String nameAttributeKey, String name, String email, String picture){
        this.attributes=attributes;
        this.nameAttributeKey=nameAttributeKey;
        this.name=name;
        this.email=email;
        this.picture=picture;
    }

    public static OAuthAttributes of(String registrationId, String userNameAttributeName, Map<String,Object> attributes){
        return ofGoogle(userNameAttributeName, attributes);
    }

    private static OAuthAttributes ofGoogle(String userNameAttributeName , Map<String,Object> attributes){
        OAuthAttributes oAuthAttributes= new OAuthAttributes(attributes,userNameAttributeName,(String)attributes.get("name"),(String)attributes.get("email"),(String)attributes.get("picture"));

        return oAuthAttributes;
    }
    //이메일 찾기 실패. 즉 가입한적 없는 경우 실행할 함수
    public MemberVO makeMemberVO(){
        MemberVO memberVO= new MemberVO();
        memberVO.setMemberId(email);
        memberVO.setMemberNickname(name);
        memberVO.setMemberPassword("qwert2018!");
        memberVO.setMemberTeachingLang("KOREAN");
        memberVO.setMemberLearningLang("ENGLISH");
        memberVO.setMemberInteresting("GAME");
        memberVO.setMemberGender("W");
        memberVO.setMemberNationUrl("/images/nation/southKorea.png");
        memberVO.setMemberLearningUrl("/images/nation/america.png");



        return memberVO;
    }

}

*/
