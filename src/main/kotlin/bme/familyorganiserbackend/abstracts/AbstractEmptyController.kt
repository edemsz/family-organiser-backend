package bme.familyorganiserbackend.abstracts

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RestController

@RestController
abstract class AbstractEmptyController<Entity: AbstractEntity> {
    @Autowired
    protected open lateinit var service: AbstractService<Entity>

}