package com.androidventures.UniMealServer.springboot.Controller;

import com.androidventures.UniMealServer.springboot.models.FamilyMember;
import com.androidventures.UniMealServer.springboot.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MembersController {
    @Autowired
    MemberService service;

    @GetMapping("/members")
    public List<FamilyMember> members(){
        return service.fetchALL();
    }

    @PostMapping("/addmember")
    public FamilyMember addmembers(@RequestBody FamilyMember member){

        return service.save(member);

    }


}
