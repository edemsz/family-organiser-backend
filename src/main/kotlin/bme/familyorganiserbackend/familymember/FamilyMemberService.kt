package bme.familyorganiserbackend.familymember

import bme.familyorganiserbackend.abstracts.AbstractService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service


@Service
class FamilyMemberService
@Autowired
constructor() : AbstractService<FamilyMember>() {
    override fun add(e: FamilyMember): FamilyMember {
        e.setUid()
        return super.add(e)
    }

    override fun updateById(id: Long, entity: FamilyMember): FamilyMember {
        entity.uid=dao.getById(id).uid
        return super.updateById(id, entity)
    }



}