package bme.familyorganiserbackend

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import springfox.documentation.swagger2.annotations.EnableSwagger2

@SpringBootApplication
@EnableSwagger2
open class FamilyOrganiserBackendApplication{
    companion object{
        const val TEST_DISABLED=true

    }

}
fun main(args: Array<String>) {
    runApplication<FamilyOrganiserBackendApplication>(*args)
}

