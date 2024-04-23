package com.waste.ecosort_challenges.Userdetail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.waste.ecosort_challenges.Entity.User;
import com.waste.ecosort_challenges.Repository.UserRepository;

public class CustomeUserDetailservice implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       User user=userRepository.getUserByUserName(username);
       if(user==null)
       {
        throw new UsernameNotFoundException("User not found");
       }   
       CustomuserDetail customuserDetail=new CustomuserDetail(user);
       return customuserDetail;
    }
    
}
