package bme.familyorganiserbackend

import bme.familyorganiserbackend.entities.Family
import bme.familyorganiserbackend.entities.FamilyMember
import bme.familyorganiserbackend.repositories.FamilyRepository
import bme.familyorganiserbackend.services.FamilyMemberService
import bme.familyorganiserbackend.services.FamilyService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.stereotype.Component
import java.time.LocalDate
import kotlin.random.Random.Default.nextInt

@Component
open class DataLoader @Autowired constructor
    (
    private var familyMemberService: FamilyMemberService,
    private var familyService: FamilyService,
    private val familyRepository: FamilyRepository
) : ApplicationRunner {
    private fun manyFamilies(){
        val n=1000
        for ( i in 1..n) {
            val STRING_LENGTH = 10
            val charPool: List<Char> = ('a'..'z') + ('A'..'Z') + ('0'..'9')
            val randomString = (1..STRING_LENGTH)
                .map { nextInt(0, charPool.size) }
                .map(charPool::get)
                .joinToString("")
            val family = Family(randomString)
            familyService.add(family)
        }


    }

    override fun run(args: ApplicationArguments?) {
        manyFamilies()
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