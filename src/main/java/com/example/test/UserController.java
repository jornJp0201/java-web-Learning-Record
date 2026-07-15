package com.example.test;



import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;




@Controller
@RequestMapping("/users")
public class UserController{

  private final UserService userService;

  
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public String createUser(
      @ModelAttribute UserEntity newUser,
       Model model) {
        String username=userService.saveUser(newUser); // Serviceに指示を出す
        model.addAttribute("username",username);
        return "date";
    }

    @PostMapping("/login_chack")
    public String login_chack(
        @RequestParam("userid")String userid,
        @RequestParam("pas")String pas,
         HttpSession session,
         Model model ) {
        try {
         
         if(pas.equals(userService.getUserByPas(userid))){
             model.addAttribute("userName",userService.getUserById(userid));
             UserEntity username = userService.getUserByIdEntity(userid);
             session.setAttribute("loginUser", username);
            
             
             return "redirect:/taxt/main";
         }else if(userid ==null) {
               String miss_java="ID does not exist";
               model.addAttribute("miss",miss_java);
               return "login";
         }else{
            
              String miss_java="The password is wrong";
               model.addAttribute("miss",miss_java);
               return "login";
         }
     }catch (Exception e) {
               String miss_java="An error";
               model.addAttribute("miss",miss_java);
               return "login";
     }
        
    }
    

}


@Service 
class UserService {

    
    private final UserRepository userRepository;

  
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public String saveUser(UserEntity newuser) {
        
        UserEntity savedUser = userRepository.save(newuser);
        return savedUser.getUsername();
    }

    public String getUserByPas(String id) {
       
        UserEntity user = userRepository.findById(id).orElse(null);
        return user.getPassword();
    }

    public String getUserById(String id) {
       
        UserEntity user = userRepository.findById(id).orElse(null);
        return user.getUsername();
    }

    public UserEntity getUserByIdEntity(String id) {
        return userRepository.findById(id).orElse(null);
    }

   

   
}