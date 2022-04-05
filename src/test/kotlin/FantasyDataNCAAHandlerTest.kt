import org.junit.jupiter.api.Test
import positionHandlers.QuarterbackHandler
import positionHandlers.RunningbackHandler
import positionHandlers.ReceiverHandler

internal class FantasyDataNCAAHandlerTest(){

    val reader = FileReader()
    val qbHandler = QuarterbackHandler(reader)
    val rbHandler = RunningbackHandler(reader)
    val wrHandler = ReceiverHandler(reader)

    private val underTest = FantasyDataNCAAHandler(reader, qbHandler, rbHandler, wrHandler)

    @Test
    fun `should say hello`() {
        underTest.processRecords()
    }

}