package bme.familyorganiserbackend.family

import bme.familyorganiserbackend.abstracts.AbstractCreateMapper
import bme.familyorganiserbackend.basic.ResourceNotFoundException
import bme.familyorganiserbackend.familymember.FamilyMemberRepository
import org.mapstruct.AfterMapping
import org.mapstruct.Mapper
import org.mapstruct.MappingTarget
import org.springframework.beans.factory.annotation.Autowired

@Mapper(componentModel = "spring")
abstract class CreateFamilyMapper : AbstractCreateMapper<Family, CreateFamily>(){
    @Autowired
    private lateinit var familyMemberRepository: FamilyMemberRepository
    @AfterMapping
    fun establishRelation(@MappingTarget family: Family, dto: CreateFamily){
        if(dto.headId !=null) {
            setHead(family,dto)
        }

        if(dto.memberIds!=null && dto.memberIds!!.isNotEmpty()){
            setMembers(family,dto)
        }

    }

    private fun setMembers(family: Family, dto: CreateFamily) {
        for(memberId in dto.memberIds!!){
            if(memberId==null)
                continue
            if (!familyMemberRepository.existsById(memberId))
                throw ResourceNotFoundException()
            val member=familyMemberRepository.findById(memberId).get()
            if(family.members==null)
                family.members= mutableListOf(member)
            else family.members!!.add(member)
        }
    }

    private fun setHead(family: Family, dto: CreateFamily){
        if (!familyMemberRepository.existsById(dto.headId!!))
            throw ResourceNotFoundException()
        val member=familyMemberRepository.findById(dto.headId!!).get()
        family.head = member
    }

}