package com.example.test;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpSession;



@Controller
@RequestMapping("/taxt")
public class TaxtController{

  private final TaxtService TaxtService;

   // @Autowired
    public TaxtController(TaxtService taxtService) {
        this.TaxtService = taxtService;
    }

    

    @PostMapping("/add")
     public String settext(
     @ModelAttribute TaxtEntity taxt,
     HttpSession session,
     Model model){
        UserEntity username_maked = (UserEntity) session.getAttribute("loginUser");
     
        if (username_maked == null) {
            return "redirect:/login";
        }
       
        taxt.set_username(username_maked);
        
        if(TaxtService.countTaxt()>=0){
           TaxtService.saveTaxt(taxt);
        }
         return "redirect:/taxt/main";
    }
   

   @GetMapping("/main")
      public String mainpage(
        Model model,
        HttpSession session
      ){
        List<TaxtEntity>taxt_All=TaxtService.getTaxt_All();
        List<String> titleList =TaxtService.getTitle_All();
        UserEntity loginUserName = (UserEntity)session.getAttribute("loginUser");
       
    
         if (loginUserName == null) {
        // もしログインせずに直接URLを叩いてきたら、ログイン画面に強制送還する（セキュリティ対策）
             return "redirect:/login"; 
    }
     String username = (String)loginUserName.getUsername();
         model.addAttribute("taxt",taxt_All);
         model.addAttribute("title",titleList);
         model.addAttribute("username",username);
         return "main";
  }


}


@Service 
class TaxtService {

    
    private final TaxtRepository TaxtRepository;

   
    public TaxtService(TaxtRepository taxtRepository) {
        this.TaxtRepository = taxtRepository;
    }

 
    public void saveTaxt(TaxtEntity taxt) {
        // Repositoryのメソッドを呼び出して、DBに保存（登録）させる
        TaxtRepository.save(taxt); 
    }

    public long countTaxt(){
        long userCount = TaxtRepository.count();
        return userCount;
    }

    public String getTitle(String taxt){
        TaxtEntity Taxt = TaxtRepository.findById(taxt).orElse(null);
        if (Taxt != null) {
            return Taxt.getTaxt(); 
        }
            return "er";
    }
    public List<TaxtEntity>getTaxt_All(){
        return TaxtRepository.findAll();
    }

    public List<String>getTitle_All(){
        
        return TaxtRepository.All_getTitle();
    }

    public UserEntity get_username(String taxt){
        TaxtEntity Taxt = TaxtRepository.findById(taxt).orElse(null);
        return Taxt.get_username();
    }
    

   
}