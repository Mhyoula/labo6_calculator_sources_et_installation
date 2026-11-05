package seg3x02.calculator

import io.swagger.v3.oas.annotations.OpenAPIDefinition
import io.swagger.v3.oas.annotations.info.Info
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@OpenAPIDefinition(
    info = Info(
        title = "REST Calculator API",
        version = "1.0",
        description = "API REST pour les opérations arithmétiques du laboratoire 6 (SEG3502)."
    )
)
@SpringBootApplication
class RestCalculatorApplication

fun main(args: Array<String>) {
    runApplication<RestCalculatorApplication>(*args)
}
