package bme.familyorganiserbackend

import bme.familyorganiserbackend.entities.Family
import bme.familyorganiserbackend.entities.FamilyMember
import bme.familyorganiserbackend.services.FamilyService
import bme.familyorganiserbackend.services.FamilyMemberService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.stereotype.Component
import java.time.LocalDate

@Component
open class DataLoader @Autowired constructor
    (
    private var familyMemberService: FamilyMemberService,
    private var familyService: FamilyService
) : ApplicationRunner {

    override fun run(args: ApplicationArguments?) {

        var family1 = Family("family 1")
        familyService.add(family1)
        val fm1 = FamilyMember("user1", "user", "user@user.hu", null, LocalDate.of(1994, 2, 12), null)
        val fm2 = FamilyMember("user2", "user", "user2@user.hu", null, LocalDate.of(1996, 4, 2), null)
        val fm3 = FamilyMember("user3", "user", "user3@user.hu", null, LocalDate.of(1999, 11, 22), null)
        familyMemberService.add(fm1)
        familyMemberService.add(fm2)
        familyMemberService.add(fm3)
        familyService.addMemberToFamily(1,1)
        familyService.addMemberToFamily(1,2)
        familyService.addMemberToFamily(1,3)

        family1= familyService.getById(1)!!
        family1.head=familyMemberService.getById(2)!!
        familyService.updateById(1,family1)



    }

}