package com.androidventures.UniMealServer.springboot.repo;

import com.androidventures.UniMealServer.springboot.models.FamilyMember;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class MemberRepository {

    List<FamilyMember> familymembers = new ArrayList<>(Arrays.asList(
            new FamilyMember(21, "kiran", 170, 73.5F, List.of("lactose intolerant", "red meat"), List.of("thyroid")),
            new FamilyMember(56, "kavita", 160, 63.5F, null, List.of("thyroid")),
            new FamilyMember(59, "kumar", 168, 78.5F, List.of("red meat"), null)
    ));


    public List<FamilyMember> fetchAll() {

        return familymembers;
    }

    public FamilyMember save(FamilyMember member) {

        familymembers.add(member);
        return member;
    }
}
