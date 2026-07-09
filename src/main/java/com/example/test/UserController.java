package com.example.test;


//import org.springframework.data.jpa.repository.query.EqlParser;
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

   // @Autowired
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


@Service // 新しく作るクラスにこれを付ける
class UserService {

    // 先ほど作ったRepositoryをここに用意する
    private final UserRepository userRepository;

   // @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // ★ここにRepositoryを呼び出す処理（ビジネスロジック）を書く！
    public String saveUser(UserEntity newuser) {
        // Repositoryのメソッドを呼び出して、DBに保存（登録）させる
        UserEntity savedUser = userRepository.save(newuser);
        return savedUser.getUsername();
    }

    public String getUserByPas(String id) {
        // findById() を使うと、結果が「Optional」という箱に包まれて返ってきます
        UserEntity user = userRepository.findById(id).orElse(null);
        return user.getPassword();
    }

    public String getUserById(String id) {
        // findById() を使うと、結果が「Optional」という箱に包まれて返ってきます
        UserEntity user = userRepository.findById(id).orElse(null);
        return user.getUsername();
    }

    public UserEntity getUserByIdEntity(String id) {
        return userRepository.findById(id).orElse(null);
    }

   

    /*public List<UserEntity> getAllUsers() {
        // ここで、JpaRepositoryが最初から持っている「findAll()」を呼び出す！
        return userRepository.findAll(); 
    }*/
}