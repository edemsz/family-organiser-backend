package bme.familyorganiserbackend.familymember

import bme.familyorganiserbackend.abstracts.AbstractRepository
import org.springframework.stereotype.Repository

@Repository
interface FamilyMemberRepository : AbstractRepository<FamilyMember>{
    fun findByUsername(username:String):FamilyMember?
    fun findByUid(uid:String):FamilyMember?
    fun existsByUsername(username:String):Boolean
    fun existsByUid(uid:String):Boolean

}