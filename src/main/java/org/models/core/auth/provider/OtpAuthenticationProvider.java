package org.models.core.auth.provider;

import org.models.core.auth.JwtTokenUtil;
import org.models.core.dao.OtpRepository;
import org.models.core.dao.UsersRepository;
import org.models.core.domain.Otp;
import org.models.core.users.RegisteredUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class OtpAuthenticationProvider implements AuthenticationProvider {


    @Autowired
    OtpRepository otpRepository;

    @Autowired
    UsersRepository usersRepository;

    @Autowired
    JwtTokenUtil jwtTokenUtil;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        Integer otp = (Integer) authentication.getCredentials();

        Otp otpObject = otpRepository.findByUsername(username);
        RegisteredUser user= usersRepository.findOneByEmail(username);
        if(user ==null){
            user = usersRepository.findOneByMobile(username);
        }
        if(user==null){
            throw new BadCredentialsException(":(");
        }

        if (otpObject.getOtp().equals(otp)) {
            OtpAuthentication auth = new OtpAuthentication(username, bCryptPasswordEncoder.encode(user.getPassword()));
            auth.setDetails(user);
            return auth;
        }

        throw new BadCredentialsException(":(");
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return OtpAuthentication.class.equals(authentication);
    }
}
