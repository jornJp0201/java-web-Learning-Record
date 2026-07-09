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

//import org.springframework.web.bind.annotation.RequestParam;

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
        // ✨ 3. 万が一、ログインしていない、またはセッションが切れていた場合は安全にログイン画面へ突き返す（ガード処理）
        if (username_maked == null) {
            return "redirect:/login";
        }
        // ✨ 4. 画面から届いたテキストデータに、いまログインしているユーザーの情報を合体させます！
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


@Service // 新しく作るクラスにこれを付ける
class TaxtService {

    // 先ほど作ったRepositoryをここに用意する
    private final TaxtRepository TaxtRepository;

   // @Autowired
    public TaxtService(TaxtRepository taxtRepository) {
        this.TaxtRepository = taxtRepository;
    }

    // ★ここにRepositoryを呼び出す処理（ビジネスロジック）を書く！
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