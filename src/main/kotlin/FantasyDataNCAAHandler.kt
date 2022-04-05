import model.fantasyData.QuarterbackModel
import model.fantasyData.ReceiverModel
import model.fantasyData.RunningbackModel
import positionHandlers.QuarterbackHandler
import positionHandlers.RunningbackHandler
import positionHandlers.ReceiverHandler
import java.nio.file.Paths

class FantasyDataNCAAHandler(
    private val reader: FileReader,
    private val qbHandler: QuarterbackHandler,
    private val rbHandler: RunningbackHandler,
    private val receiversHandler: ReceiverHandler

) {

    fun processRecords(){
        val masterList = mutableListOf<List<Any>>()

        val qbFiles = listOf(
            "/Users/Stephen.Roberts2/Documents/NCAA/fantasy-data-ncaa-adapter/src/main/resources/QB/001_FD_QB_2021_Wk01.csv",
            "/Users/Stephen.Roberts2/Documents/NCAA/fantasy-data-ncaa-adapter/src/main/resources/QB/002_FD_QB_2021_Wk02.csv",
            "/Users/Stephen.Roberts2/Documents/NCAA/fantasy-data-ncaa-adapter/src/main/resources/QB/003_FD_QB_2021_Wk03.csv",
            )
        val rbFiles = listOf("/Users/Stephen.Roberts2/Documents/NCAA/fantasy-data-ncaa-adapter/src/main/resources/RB/001_FD_RB_2021_Wk01.csv")
        val receiverFiles = listOf(
            "/Users/Stephen.Roberts2/Documents/NCAA/fantasy-data-ncaa-adapter/src/main/resources/WR/001_FD_WR_2021_Wk01.csv",
            "/Users/Stephen.Roberts2/Documents/NCAA/fantasy-data-ncaa-adapter/src/main/resources/TE/001_FD_TE_2021_Wk01.csv",
        )

        val quarterbacks = handleQbs(qbFiles)
        masterList.add(quarterbacks)

        val runningbacks = handleRbs(rbFiles)
        masterList.add(runningbacks)

        val receivers = handleReceivers(receiverFiles)
        masterList.add(receivers)

        println(masterList.flatten().size)
    }

    fun handleQbs(filepaths: List<String>): List<QuarterbackModel>{
        val quarterbacks = mutableListOf<MutableList<QuarterbackModel>>()
        for(filepath in filepaths) {
            quarterbacks.add(qbHandler.processQbs(filepath))
        }
        return quarterbacks.flatten()
    }

    fun handleRbs(filepaths: List<String>): List<RunningbackModel>{
        val runningbacks = mutableListOf<MutableList<RunningbackModel>>()
        for(filepath in filepaths) {
            runningbacks.add(rbHandler.processRbs(filepath))
        }
        return runningbacks.flatten()
    }

    fun handleReceivers(filepaths: List<String>): List<ReceiverModel> {
        val receivers = mutableListOf<MutableList<ReceiverModel>>()
        for(filepath in filepaths) {
            receivers.add(receiversHandler.processReceivers(filepath))
        }
        return receivers.flatten()
    }


    fun getTeamMappings(){
        val filepath = "/Users/Stephen.Roberts2/Documents/NCAA/fantasy-data-ncaa-adapter/src/main/resources/mappings"

        return reader.readFiles(filepath)
    }

}