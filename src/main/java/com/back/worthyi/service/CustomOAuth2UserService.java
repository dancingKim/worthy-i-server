package com.back.worthyi.service;

import com.back.worthyi.dao.UserDao;
import com.back.worthyi.dto.UserDto;
import com.back.worthyi.security.ApplicationOAuth2User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;
import com.fasterxml.jackson.databind.ObjectMapper;


@Slf4j
@Service
public class CustomOAuth2UserService extends DefaultOAuth2UserService {

    private UserDao userDao;

    private OAuth2User oAuth2User;

    @Autowired
    CustomOAuth2UserService(UserDao userDao){
        super();
        this.userDao = userDao;
    }

    public void setOAuth2User(OAuth2User oAuth2User) {
        this.oAuth2User = oAuth2User;
    }

    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        if (oAuth2User == null){
            oAuth2User = super.loadUser(userRequest);
        }
        try {
            log.info("OAuth2User attributes {} ", new ObjectMapper().writeValueAsString(oAuth2User.getAttributes()));
        } catch (Exception e){
            e.printStackTrace();
        }

        // 현재 로그인 진행 중인 서비스를 구분하는 코드
        String registrationId = userRequest
                .getClientRegistration()
                .getRegistrationId();

        String authProvider = userRequest.getClientRegistration().getClientName();
        String username = (String) oAuth2User.getAttributes().get("login");
        final String email = (String) oAuth2User.getAttributes().get("email");
        log.info("client name is {}, and id is {}",authProvider,registrationId);

        UserDto userDto = null;


        if(! userDao.existsByEid(email)){
            userDto = userDto.builder().eid(email).providerNm(authProvider).build();
            userDto = userDao.save(userDto);
        } else {
            userDto = userDao.findByEid(email);
        }



        log.info("Successfully pulled user info email {} authProvider {}", email, authProvider);
        return new ApplicationOAuth2User(
                userDto.getUserId(),
                oAuth2User.getAttributes()
        );
    }
}