package bme.familyorganiserbackend

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.event.ApplicationStartedEvent
import org.springframework.boot.runApplication
import org.springframework.context.event.EventListener
import springfox.documentation.swagger2.annotations.EnableSwagger2

@SpringBootApplication
@EnableSwagger2
open class FamilyOrganiserBackendApplication{
    companion object{
        const val TEST_DISABLED=false

    }

}
fun main(args: Array<String>) {
    runApplication<FamilyOrganiserBackendApplication>(*args)
}

