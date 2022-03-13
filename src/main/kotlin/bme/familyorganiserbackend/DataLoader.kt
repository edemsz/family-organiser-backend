package bme.familyorganiserbackend

import bme.familyorganiserbackend.family.Family
import bme.familyorganiserbackend.familymember.FamilyMember
import bme.familyorganiserbackend.familymember.FamilyMemberRepository
import bme.familyorganiserbackend.family.FamilyRepository
import bme.familyorganiserbackend.family.FamilyService
import bme.familyorganiserbackend.familymember.FamilyMemberService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional
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
        val fm1 = FamilyMember("user1", "user", "user@user.hu", null, LocalDate.of(1994, 2, 12), family1)
        val fm2 = FamilyMember("user2", "user", "user2@user.hu", null, LocalDate.of(1996, 4, 2), family1)
        val fm3 = FamilyMember("user3", "user", "user3@user.hu", null, LocalDate.of(1999, 11, 22), family1)
        familyMemberService.add(fm1)
        familyMemberService.add(fm2)
        familyMemberService.add(fm3)
        /*family1= familyService.getById(1)!!
        family1.head=fm2*/
        //familyService.updateById(1,family1)


        /*val mapper:PlainFamilyMemberMapper= PlainFamilyMemberMapper.INSTANCE

        val fm1DTO=mapper.entityToPlain(fm1)
        println(fm1DTO?.id)
        println(fm1DTO?.lastName)
        println(fm1DTO?.surname)
        println(fm1DTO?.uid)
        println(fm1DTO?.username)
        println(fm1DTO?.email)*/
    }

}