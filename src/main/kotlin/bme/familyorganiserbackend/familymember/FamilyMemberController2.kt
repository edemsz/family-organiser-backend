package bme.familyorganiserbackend.familymember

import bme.familyorganiserbackend.abstracts.AbstractController
import bme.familyorganiserbackend.abstracts.AbstractGetMapper
import bme.familyorganiserbackend.abstracts.AbstractService
import bme.familyorganiserbackend.familymember.dto.CreateFamilyMember
import bme.familyorganiserbackend.familymember.dto.FamilyMemberGet
import bme.familyorganiserbackend.familymember.mapper.CreateFamilyMemberMapper
import bme.familyorganiserbackend.familymember.mapper.GetFamilyMemberMapper
import io.swagger.annotations.ApiOperation
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/family-member2")
class FamilyMemberController2: AbstractController
<FamilyMember, CreateFamilyMember, FamilyMemberGet >()
{


}