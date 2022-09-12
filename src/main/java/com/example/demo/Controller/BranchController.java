package com.example.demo.Controller;

import com.example.demo.Entity.Branch;

import com.example.demo.Service.BranchService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api")//in data lên thành json
public class BranchController {
    private final BranchService branchService;
    @Autowired
    public BranchController(BranchService branchService) {
        this.branchService = branchService;
    }
    @GetMapping("/branch")
    public List<Branch> listBranch(){
        return branchService.listBranch();

    }
    @GetMapping("/branch/{maNganh}")
    public ResponseEntity<Branch> getByID(@PathVariable(value = "maNganh") String maNganh){
        try{
            Branch branch = branchService.getBranch(maNganh);
            return new ResponseEntity<Branch>(branch, HttpStatus.OK);
        }catch (NoSuchElementException e){
            return new ResponseEntity<Branch>(HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping("/branch/{maNganh}")
    public void saveBranch(@RequestBody Branch branch){
        branchService.saveBranch(branch);
    }
    @PutMapping("/branch/{maNganh}")
    public Branch updateBranch(@PathVariable String maNganh, @RequestBody Branch branch) {
        return branchService.updateBranch(maNganh, branch);
    }
    @DeleteMapping ( path = "/branch/{maNganh}" )
    public void deleteSubject ( @PathVariable ( "maNganh" ) String maNganh ) {
        branchService.deleteBranch(maNganh); ;
    }

}
