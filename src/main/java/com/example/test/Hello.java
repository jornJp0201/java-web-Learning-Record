package com.example.test;

//import java.lang.classfile.Attribute;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestBody;


/**
 * VS Code + Spring Boot 入門用コントローラー
 */
@Controller
public class Hello{
   
   //infomation i=new infomation();
  // String memoryUserName="0";//この変数はusenameをマイページに持ち込むために使う
   
    @GetMapping("/")
    public String index() {
        return "index";
    }

@GetMapping("/hello_test")
public String sayHello(){
        
        return "result";
}

/*@PostMapping("/register")
public String SetIn(
    @RequestParam("userName")String userName,
    @RequestParam("pas")String pas,
    Model model
                  
){
        i.InSet(pas,userName);
        i.nameSet(userName);
        model.addAttribute("userName", userName);
        return "date";
}*/

@GetMapping("/login")
public String login() {
    return "login";
}

/*@PostMapping("/login_chack")
public String login_chack(
    @RequestParam("userid")String userid,
    @RequestParam("pas")String pas,
    Model model  
) {
      String myname="jorn"; //本番では消す（いちいち登録がめんどくさいので書いてる）
      String mypas="0201";
      i.pasIDlist.put(myname,mypas);
      i.IDlist.put(mypas,myname);
      i.nameSet(myname);
      memoryUserName="0";
     try {
         
         if(pas.equals(i.Inget_pas(userid))){
        model.addAttribute("userName",i.Inget_userName(pas));
        memoryUserName=userid;
        return "main";
         }else{
          String miss_java="The password is wrong";
          model.addAttribute("miss",miss_java);
          return "login";
         }
     } catch (NullPointerException Null) {
      String miss_java="ID does not exist";
      model.addAttribute("miss",miss_java);
    return "login";
     } catch (Exception e) {
      String miss_java="An error";
      model.addAttribute("miss",miss_java);
      return "login";
     }
*/
  

@GetMapping("/add_text")
  public String Registr_Page(){
    return "add_text";
  }

 
  public String getMethodName(@RequestParam String param) {
      return new String();
  }
  
        
/*@PostMapping("/text")
   public String settext(

   @RequestParam("title") String title,
   @RequestParam("sent")String sent,//sent=本文
   Model model

   ){
   //HTML側の完成後にvoidをStringに変え、testメソッドを削除する。
    k.SetSEN(title, sent, memoryUserName);
    model.addAttribute("title",k.TitleList);
    model.addAttribute("title_Sentens",k.TotalList);
    model.addAttribute("username",memoryUserName);
    
    return "main";
   }
*/

}






//以下擬似的なDB（カプセル化は未実行）メソッドやクラス追加はこれより上の行に行うこと
/*interface SetClass{
    void nameSet(String name);
    void InSet(String useName,String pas);
    String Inget_pas(String pas);
    String Inget_userName(String pas);
    
}


class infomation implements SetClass {

     // HashMap<String,String>  LearningName=new HashMap<>();
      HashMap<String,String>pasIDlist =new HashMap<>();
      HashMap<String,String>IDlist =new HashMap<>();
      ArrayList<String>nameList=new ArrayList<>();
     
     @Override
      public void nameSet(String Name){
        nameList.add(Name);
      }
      @Override
      public void InSet(String pas,String userName){
        IDlist.put(pas,userName);
        pasIDlist.put(userName,pas);
      }

      @Override
      public String Inget_pas(String username){
        String pas=pasIDlist.get(username);
         return pas;
      }

      @Override
      public String Inget_userName(String pas){  
       String userName=IDlist.get(pas);
       return userName;

}



class Keep {

  HashMap<String,String>SENlist =new HashMap<>();//タイトルと文
  ArrayList<String>TitleList=new ArrayList<>();
  HashMap<String,String>TotalList =new HashMap<>();//usernameとSENLISTを入れる

  private void SetTotal(String username,String a){
      TotalList.put(username,a);
  }
  public void SetSEN(String a,String b,String username){
     TitleList.add(a);
     SENlist.put(a,b);
     SetTotal(a, b);
  }
}
  */