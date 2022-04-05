package positionHandlers

import FileReader
import model.fantasyData.QuarterbackModel
import model.fantasyData.RunningbackModel
import org.apache.commons.csv.CSVParser
import java.lang.Float
import java.lang.Float.parseFloat
import java.lang.Integer.parseInt
import java.nio.file.Paths

class RunningbackHandler(
    private val reader: FileReader
) {

    fun processRbs(filepath: String): MutableList<RunningbackModel> {
        val csvParser = reader.parseCSV(Paths.get(filepath))
        return rbTransformer(csvParser)
    }

    fun rbTransformer(csvParser: CSVParser): MutableList<RunningbackModel> {
        val runningbacks = mutableListOf<RunningbackModel>()
        for (record in csvParser) {
            val rank = parseInt(record.get(0))
            val playerId = record.get(1)
            val playerName = record.get(2)
            val team = record.get(3)
            val position = record.get(4)
            val week = parseInt(record.get(5))
            val opponent = record.get(6)
            val rushingAttempts = parseInt(record.get(7))
            val rushingYards = parseInt(record.get(8))
            val rushingYardsPerAttempt = parseFloat(record.get(9))
            val rushingTouchdowns = parseInt(record.get(10))
            val receptions = parseInt(record.get(11))
            val receivingYards = parseInt(record.get(12))
            val receivingTouchdowns = parseInt(record.get(13))
            val fumbles = parseInt(record.get(14))
            val fumblesLost = parseInt(record.get(15))
            val fantasyPoints = parseFloat(record.get(16))

            val runningback = RunningbackModel(
                rank,
                playerId,
                playerName,
                team,
                position,
                week,
                opponent,
                rushingAttempts,
                rushingYards,
                rushingYardsPerAttempt,
                rushingTouchdowns,
                receptions,
                receivingYards,
                receivingTouchdowns,
                fumbles,
                fumblesLost,
                fantasyPoints
            )
            runningbacks.add(runningback)
        }
        return runningbacks
    }
}
