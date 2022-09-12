package com.example.demo.Controller;

import com.example.demo.Entity.Login;
import com.example.demo.Entity.Point;
import com.example.demo.Service.LoginService;
import com.example.demo.Service.PointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api")//in data lên thành json
public class LoginController {
    private final LoginService loginService;
    @Autowired
    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }
    @GetMapping("/login")
    public List<Login> listLogin(){
        return loginService.listLogin();

    }
    @GetMapping("/login/{id}")
    public ResponseEntity<Login> getByID(@PathVariable(value = "id") String id){
        try{
            Login login = loginService.getLogin(id);
            return new ResponseEntity<Login>(login, HttpStatus.OK);
        }catch (NoSuchElementException e){
            return new ResponseEntity<Login>(HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping("/login/{id}")
    public void saveLogin(@RequestBody Login login){
        loginService.saveLogin(login);
    }
    @PutMapping("/login/{id}")
    public Login updateLogin(@PathVariable String id, @RequestBody Login login) {
        return loginService.updateLogin(id, login);
    }
    @DeleteMapping ( path = "/login/{id}" )
    public void deleteLogin ( @PathVariable ( "id" ) String id ) {
        loginService.deleteLogin(id); ;
    }
}
