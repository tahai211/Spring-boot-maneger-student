package com.example.demo.Service;

import com.example.demo.Entity.Branch;
import com.example.demo.Entity.Subjects;
import com.example.demo.Repository.BranchRepository;
import com.example.demo.Repository.SubjectsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BranchService {
    private final BranchRepository branchRepository;
    @Autowired
    public BranchService(BranchRepository branchRepository) {
        this.branchRepository = branchRepository;
    }
    public List<Branch> listBranch(){
        return branchRepository.findAll();
    }
    //them  vao table
    public Branch saveBranch(Branch branch){
        return branchRepository.save(branch);
    }

    //lay
    public Branch getBranch(String maNganh){
        return branchRepository.findById(maNganh).get();
    }
    public Branch updateBranch(String maNganh, Branch branch) {
        Branch fromDB = branchRepository.findById(maNganh).orElse(null);
        if (fromDB == null) {
            return null;
        }
        fromDB.setTenNganh(branch.getTenNganh());

        return branchRepository.save(fromDB);
    }

    //xoa  theo maNganh
    public void deleteBranch(String maNganh){
        branchRepository.deleteById(maNganh);
    }
}
