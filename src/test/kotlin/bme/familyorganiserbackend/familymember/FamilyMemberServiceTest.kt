package bme.familyorganiserbackend.familymember

import bme.familyorganiserbackend.FamilyOrganiserBackendApplication
import bme.familyorganiserbackend.family.Family
import bme.familyorganiserbackend.family.FamilyRepository
import bme.familyorganiserbackend.family.FamilyService
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.transaction.annotation.Transactional
import java.time.LocalDate

@SpringBootTest
@Transactional
open class FamilyMemberServiceTest @Autowired constructor
    (
    private val familyMemberRepository: FamilyMemberRepository,
    private val familyRepository: FamilyRepository,
    private val familyMemberService: FamilyMemberService,
    private val familyService: FamilyService
) {

    private val testDisabled= FamilyOrganiserBackendApplication.TEST_DISABLED
    private fun dataLoad() {
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

    @Test
    fun repoEntityEqualsServiceEntity() {
        if(testDisabled)
            return
        assertEquals(familyMemberService.getAll().size, familyMemberRepository.findAll().size)
        dataLoad()
        assertEquals(familyMemberService.getAll().size, familyMemberRepository.findAll().size)
        for (i in -3L..10L) {
            val memberFromRepo = familyMemberRepository.findById(i)
            val memberFromService = familyMemberService.getById(i)
            if (memberFromRepo.isEmpty)
                assertNull(memberFromService)
            else {
                assertEquals(memberFromRepo.get().id, memberFromService?.id)
                assertEquals(memberFromRepo.get().lastName, memberFromService?.lastName)
                assertEquals(memberFromRepo.get().uid, memberFromService?.uid)
            }
        }
    }

    @Test
    fun serviceInsertTest() {
        if(testDisabled)
            return
        assertEquals(familyMemberService.getAll().size, familyMemberRepository.findAll().size)
        val add = FamilyMember()
        val EMAIL = "test@gmail.com"
        val LAST_NAME = "ln"
        val FIRST_NAME = "Sir Name"
        val USERNAME = "user11"
        val BIRTHDATE = LocalDate.of(1980, 12, 4)
        add.email = EMAIL
        add.birthDate = BIRTHDATE
        add.lastName = LAST_NAME
        add.firstName = FIRST_NAME
        add.username = USERNAME
        familyMemberService.add(add)
        assertEquals(familyMemberService.getAll().size, familyMemberRepository.findAll().size)
        val memberFromRepo = familyMemberRepository.findById(familyMemberRepository.count()).get()
        assertEquals(memberFromRepo.email, EMAIL)
        assertEquals(memberFromRepo.birthDate, BIRTHDATE)
        assertEquals(memberFromRepo.firstName, FIRST_NAME)
        assertEquals(memberFromRepo.lastName, LAST_NAME)
        assertEquals(memberFromRepo.username, USERNAME)
        assertNotNull(memberFromRepo.uid)

    }

    @Test
    fun serviceUpdateTest() {
        if(testDisabled)
            return
        dataLoad()
        val initialMemberCount = familyMemberRepository.count()
        var family2 = familyRepository.getById(2)
        val initialUid = familyMemberRepository.findById(3).get().uid
        assertNotNull(initialUid)

        val update = FamilyMember("Phil", "Collins", "phil@collins.com", "-", LocalDate.of(1951, 1, 30), family2)
        val updatedMember = familyMemberService.updateById(3, update)
        assertNotEquals("user3", updatedMember.firstName)
        assertEquals("Phil", updatedMember.firstName)
        assertEquals("Collins", updatedMember.lastName)
        assertEquals("phil@collins.com", updatedMember.email)
        assertEquals("-", updatedMember.photo)
        assertEquals(LocalDate.of(1951, 1, 30), updatedMember.birthDate)
        assertEquals(2, updatedMember.family?.id)

        family2 = familyRepository.getById(2)
        val memberFromRepo = familyMemberRepository.findById(3)
        val memberCount = familyMemberRepository.count()
        assertEquals(memberCount, initialMemberCount)
        assertEquals(memberFromRepo.get().family?.id, 2)
        val uid = updatedMember.uid
        assertEquals(uid, initialUid)
        familyRepository.flush()
        familyMemberRepository.flush()
        val ids = family2.members?.map { it.id }
        assertTrue(ids?.contains(3)!!)
    }


}