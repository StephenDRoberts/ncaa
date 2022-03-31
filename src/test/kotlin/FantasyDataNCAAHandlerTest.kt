import org.junit.jupiter.api.Test


internal class FantasyDataNCAAHandlerTest(){

    val reader = FileReader()
    private val underTest = FantasyDataNCAAHandler(reader)

    @Test
    fun `should say hello`() {
        underTest.printlns()
    }

}