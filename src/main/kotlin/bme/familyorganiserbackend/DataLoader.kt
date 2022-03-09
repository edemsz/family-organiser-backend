package bme.familyorganiserbackend

import bme.familyorganiserbackend.family.Family
import bme.familyorganiserbackend.familymember.FamilyMember
import bme.familyorganiserbackend.familymember.FamilyMemberRepository
import bme.familyorganiserbackend.familymember.FamilyRepository
import bme.familyorganiserbackend.familymember.PlainFamilyMemberMapper
import org.mapstruct.factory.Mappers
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.stereotype.Component
import java.time.LocalDate
import java.util.*

@Component
class DataLoader @Autowired constructor
    (private var familyMemberRepository: FamilyMemberRepository,
    private var familyRepository: FamilyRepository
    ) :ApplicationRunner
{

    override fun run(args: ApplicationArguments?) {
        val family1= Family("family 1")
        familyRepository.save(family1)
        val fm1=FamilyMember("user1","user","user@user.hu",null,LocalDate.of(1994,2,12),family1)
        val fm2=FamilyMember("user2","user","user2@user.hu",null, LocalDate.of(1996,4,2),family1)
        val fm3=FamilyMember("user3","user","user3@user.hu",null, LocalDate.of(1999,11,22),family1)
        familyRepository.save(family1)

        val family2= Family("family 2")
        familyRepository.save(family2)
        val fm4=FamilyMember("user4","user","user4@user.hu",null,null,family2)

        familyMemberRepository.save(fm1)
        familyMemberRepository.save(fm2)
        familyMemberRepository.save(fm3)
        familyMemberRepository.save(fm4)
        family1.head=fm1
        familyRepository.save(family1)

        val mapper:PlainFamilyMemberMapper= PlainFamilyMemberMapper.INSTANCE

        val fm1DTO=mapper.EntityToPlain(fm1)
        println(fm1DTO?.id)
        println(fm1DTO?.lastName)
        println(fm1DTO?.surname)
        println(fm1DTO?.uid)
        println(fm1DTO?.username)
        println(fm1DTO?.email)
    }

}