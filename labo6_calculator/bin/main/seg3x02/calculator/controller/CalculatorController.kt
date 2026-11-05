package seg3x02.calculator.controller

import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/calculator")
@Tag(name = "Calculator", description = "Addition, soustraction, multiplication et division")
class CalculatorController {

    @Operation(summary = "Additionner deux nombres")
    @GetMapping("/add/{nombre1}/{nombre2}")
    fun add(
        @PathVariable("nombre1") nombre1: Double,
        @PathVariable("nombre2") nombre2: Double
    ): Double = nombre1 + nombre2

    @Operation(summary = "Soustraire deux nombres")
    @GetMapping("/subtract/{nombre1}/{nombre2}")
    fun subtract(
        @PathVariable("nombre1") nombre1: Double,
        @PathVariable("nombre2") nombre2: Double
    ): Double = nombre1 - nombre2

    @Operation(summary = "Multiplier deux nombres")
    @GetMapping("/multiply/{nombre1}/{nombre2}")
    fun multiply(
        @PathVariable("nombre1") nombre1: Double,
        @PathVariable("nombre2") nombre2: Double
    ): Double = nombre1 * nombre2

    @Operation(summary = "Diviser deux nombres")
    @GetMapping("/divide/{nombre1}/{nombre2}")
    fun divide(
        @PathVariable("nombre1") nombre1: Double,
        @PathVariable("nombre2") nombre2: Double
    ): Double {
        require(nombre2 != 0.0) { "Division par zéro impossible." }
        return nombre1 / nombre2
    }
}
