/*
package com.globalexchange.app.config.auth;

import com.globalexchange.app.config.auth.dto.OAuthAttributes;
import com.globalexchange.app.domain.vo.FileProfileVO;
import com.globalexchange.app.domain.vo.MemberVO;
import com.globalexchange.app.service.MemberObjectificationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import java.util.Collections;
import javax.servlet.http.HttpSession;
@RequiredArgsConstructor
@Service
@Slf4j
public class CustomOAuth2UserService implements OAuth2UserService {

    private final MemberObjectificationService memberObjectificationService;
    private final HttpSession httpSession;



    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {

        OAuth2UserService<OAuth2UserRequest,OAuth2User> delegate= new DefaultOAuth2UserService();
        OAuth2User oAuth2User= delegate.loadUser(userRequest);

        String registrationId=userRequest.getClientRegistration().getRegistrationId();
        String userNameAttributeName= userRequest.getClientRegistration().getProviderDetails().getUserInfoEndpoint().getUserNameAttributeName();

        //구글 로그인한 사용자 정보 요소를 뽑는 클래스 임의로 만들기
        OAuthAttributes attributes=OAuthAttributes.of(registrationId,userNameAttributeName,oAuth2User.getAttributes());

        //id값이 있으면 db에 update, 없다면 insert
        MemberVO memberVO= insertOrUpdate(attributes);
        log.info("oauth한후 디비인서트또는 업데이트"+memberVO);
        httpSession.setAttribute("memberNumber",memberVO.getMemberNumber());
        httpSession.setAttribute("memberNickname",memberVO.getMemberNickname());
        return new DefaultOAuth2User(
                Collections.singleton(new SimpleGrantedAuthority("USER")),attributes.getAttributes(),attributes.getNameAttributeKey()
        );
    }

    private MemberVO insertOrUpdate(OAuthAttributes attributes){
        //객체 하나는 .stream(), .map() 적용안됨
        MemberVO memberVO=memberObjectificationService.findByEmail(attributes.getEmail());
        if(memberVO==null){
            MemberVO memberVO2=attributes.makeMemberVO();
            memberObjectificationService.insertByEmail(memberVO2);
            //리턴할값인 비어있는 객체를 새로 만든 객체로 대체하면 안됨.. 왜냐하면 insertByEmail할때 memberVO2에 시퀀스로 멤버넘버가 들어가있음.
            //memberVO=attributes.makeMemberVO();
            FileProfileVO fileProfileVO=new FileProfileVO();
            fileProfileVO.setMemberNumber(memberObjectificationService.currentJoinMemberNum2());
            fileProfileVO.setFileImageCheck(true);
            fileProfileVO.setFileName("aaa");
            fileProfileVO.setFileSize(0L);
            fileProfileVO.setFileUploadPath("aaa");
            fileProfileVO.setFileUuid("aaa");
            log.info("구글 로그인 프로필 초기세팅"+fileProfileVO);
            memberObjectificationService.profileDefaultInsert(fileProfileVO);

            return memberVO2;


        }
        else{
            memberObjectificationService.updateByEmail(attributes.getEmail());
            return memberVO;
        }


    }
}
*/
