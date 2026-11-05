package seg3x02.calculator

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.get

@SpringBootTest
@AutoConfigureMockMvc
class CalculatorControllerTest {

    @Autowired
    lateinit var mockMvc: MockMvc

    @Test
    fun `addition donne 15`() {
        mockMvc.get("/calculator/add/10/5")
            .andExpect {
                status { isOk() }
                content { string("15.0") }
            }
    }

    @Test
    fun `soustraction donne 5`() {
        mockMvc.get("/calculator/subtract/10/5")
            .andExpect {
                status { isOk() }
                content { string("5.0") }
            }
    }

    @Test
    fun `multiplication donne 50`() {
        mockMvc.get("/calculator/multiply/10/5")
            .andExpect {
                status { isOk() }
                content { string("50.0") }
            }
    }

    @Test
    fun `division donne 2`() {
        mockMvc.get("/calculator/divide/10/5")
            .andExpect {
                status { isOk() }
                content { string("2.0") }
            }
    }

    @Test
    fun `division par zero retourne 400`() {
        mockMvc.get("/calculator/divide/10/0")
            .andExpect {
                status { isBadRequest() }
                jsonPath("$.erreur") { value("Division par zéro impossible.") }
            }
    }

    @Test
    fun `les nombres negatifs sont acceptes`() {
        mockMvc.get("/calculator/add/-10/5")
            .andExpect {
                status { isOk() }
                content { string("-5.0") }
            }
    }
}
