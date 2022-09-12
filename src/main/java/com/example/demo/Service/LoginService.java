package com.example.demo.Service;

import com.example.demo.Entity.Login;
import com.example.demo.Entity.Point;
import com.example.demo.Entity.Student;
import com.example.demo.Repository.LoginRepository;
import com.example.demo.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoginService {
    private final LoginRepository loginRepository;
    @Autowired
    public LoginService(LoginRepository loginRepository) {
        this.loginRepository = loginRepository;
    }



    public List<Login> listLogin(){
        return loginRepository.findAll();//con co deleteall.... cho nay de tra data ve cho controller
    }



    //them sinh vien vao table
    public Login saveLogin(Login login){
        return loginRepository.save(login);
    }

    //lay student theo dang sinh vien
    public Login getLogin(String id){
        return loginRepository.findById(id).get();
    }

    public Login updateLogin(String id, Login login) {
        Login fromDB = loginRepository.findById(id).orElse(null);
        if (fromDB == null) {
            return null;
        }
        fromDB.setPassworld(login.getPassworld());

        return loginRepository.save(fromDB);
    }
    //xoa sinh vien theo id
    public void deleteLogin(String id){
        loginRepository.deleteById(id);
    }
}
