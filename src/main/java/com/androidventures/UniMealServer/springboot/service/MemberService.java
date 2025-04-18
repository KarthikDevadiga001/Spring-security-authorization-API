package com.androidventures.UniMealServer.springboot.service;

import com.androidventures.UniMealServer.springboot.models.FamilyMember;
import com.androidventures.UniMealServer.springboot.repo.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService {
    @Autowired
    MemberRepository repo;
    public List<FamilyMember> fetchALL() {
        return repo.fetchAll();
    }
    public FamilyMember save(FamilyMember member ) {

        return repo.save(member);
    }
}
