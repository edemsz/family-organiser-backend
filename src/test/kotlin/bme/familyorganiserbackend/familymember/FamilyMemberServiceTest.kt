package bme.familyorganiserbackend.familymember

import bme.familyorganiserbackend.family.Family
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.transaction.annotation.Transactional
import java.time.LocalDate

@SpringBootTest
@Transactional
open class FamilyMemberServiceTest @Autowired constructor
    (private val familyMemberRepository: FamilyMemberRepository,
     private val familyRepository: FamilyRepository ) {

    private val familyMemberService = FamilyMemberService(familyMemberRepository)

    private fun dataLoad(){
        val family1= Family("family 1")
        familyRepository.save(family1)
        val fm1=FamilyMember("user1","user","user@user.hu",null, LocalDate.of(1994,2,12),family1)
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

    }
    @Test
    fun repoEntityEqualsServiceEntity() {
        assertEquals(familyMemberService.getMembers().size,familyMemberRepository.findAll().size)
        dataLoad()
        assertEquals(familyMemberService.getMembers().size,familyMemberRepository.findAll().size)
        for (i in -3L..10L){
            val memberFromRepo=familyMemberRepository.findById(i)
            val memberFromService=familyMemberService.getMemberById(i)
            if(memberFromRepo.isEmpty)
                assertNull(memberFromService)
            else{
                assertEquals(memberFromRepo.get().id,memberFromService?.id)
                assertEquals(memberFromRepo.get().lastName,memberFromService?.lastName)
                assertEquals(memberFromRepo.get().uid,memberFromService?.uid)
            }
        }
    }
    @Test
    fun serviceInsertTest(){
        assertEquals(familyMemberService.getMembers().size,familyMemberRepository.findAll().size)
        val add=FamilyMember()
        val EMAIL="test@gmail.com"
        val LAST_NAME="ln"
        val SURNAME="Sir Name"
        val USERNAME="user11"
        val BIRTHDATE=LocalDate.of(1980,12,4)
        add.email=EMAIL
        add.birthDate=BIRTHDATE
        add.lastName=LAST_NAME
        add.surname=SURNAME
        add.username=USERNAME
        familyMemberService.addMember(add)
        assertEquals(familyMemberService.getMembers().size,familyMemberRepository.findAll().size)
        val memberFromRepo=familyMemberRepository.findById(familyMemberRepository.count()).get()
        assertEquals(memberFromRepo.email,EMAIL)
        assertEquals(memberFromRepo.birthDate,BIRTHDATE)
        assertEquals(memberFromRepo.surname,SURNAME)
        assertEquals(memberFromRepo.lastName,LAST_NAME)
        assertEquals(memberFromRepo.username,USERNAME)
        assertNotNull(memberFromRepo.uid)
    }
    @Test
    fun serviceUpdateTest(){
        dataLoad()
        val family2=familyRepository.getById(2)
        val update=FamilyMember("Phil","Collins","phil@collins.com","-",LocalDate.of(1951,1,30),family2)
        val updatedMember=familyMemberService.updateMember(3,update)
        assertNotEquals("user3",updatedMember.surname)
        assertEquals("Phil",updatedMember.surname)
        assertEquals("Collins",updatedMember.lastName)
        assertEquals("phil@collins.com",updatedMember.email)
        assertEquals("-",updatedMember.photo)
        assertEquals(LocalDate.of(1951,1,30),updatedMember.birthDate)
        assertEquals(2,updatedMember.family?.id)
        val idk=family2.members?.map{it.id}
        assertTrue(idk?.contains(updatedMember.id)!!)
    }




}