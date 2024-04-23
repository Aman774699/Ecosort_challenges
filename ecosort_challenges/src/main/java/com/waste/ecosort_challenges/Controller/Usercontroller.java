package com.waste.ecosort_challenges.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import com.waste.ecosort_challenges.Entity.User;
import com.waste.ecosort_challenges.Repository.UserRepository;

import jakarta.validation.Valid;

@Controller
public class Usercontroller {
    
    @Autowired
    private UserRepository UserRepository;
    
    @GetMapping("/userRegistration")
    public String userRegistration()
    {
        return "Users/Registration";
    }

    
    @PostMapping("/registration")
    public ResponseEntity<RedirectView> postUserData(@Valid @ModelAttribute("user") User user,BindingResult result)
    {
        
       try{
        if(result.hasErrors())
        {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
          User add=this.UserRepository.save(user);
          RedirectView redirectView=new RedirectView();
          redirectView.setUrl("/Users/RegistrationSuccess.html");
          return ResponseEntity.ok(redirectView);
       }
       catch(Exception e)
       {
        e.printStackTrace();
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
       }    
    }
}
