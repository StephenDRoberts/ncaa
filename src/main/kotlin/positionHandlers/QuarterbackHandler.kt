package positionHandlers

import FileReader
import model.fantasyData.QuarterbackModel
import org.apache.commons.csv.CSVParser
import java.lang.Float
import java.nio.file.Paths

class QuarterbackHandler(
    private val reader: FileReader
) {

    fun processQbs(filepath: String): MutableList<QuarterbackModel> {
            val csvParser = reader.parseCSV(Paths.get(filepath))
            return qbTransformer(csvParser)
    }


    fun qbTransformer(csvParser: CSVParser): MutableList<QuarterbackModel> {
        val quarterbacks = mutableListOf<QuarterbackModel>()
        for (record in csvParser) {
            val rank = Integer.parseInt(record.get(0))
            val playerId = record.get(1)
            val playerName = record.get(2)
            val team = record.get(3)
            val position = record.get(4)
            val week = Integer.parseInt(record.get(5))
            val opponent = record.get(6)
            val passingCompletions = Integer.parseInt(record.get(7))
            val passingAttempts = Integer.parseInt(record.get(8))
            val passingCompletionPercentage = Float.parseFloat(record.get(9))
            val passingYards = Integer.parseInt(record.get(10))
            val passingYardsPerAttempt = Float.parseFloat(record.get(11))
            val passingTouchdowns = Integer.parseInt(record.get(12))
            val passingInterceptions = Integer.parseInt(record.get(13))
            val passingRating = Float.parseFloat(record.get(14))
            val rushingAttempts = Integer.parseInt(record.get(15))
            val rushingYards = Integer.parseInt(record.get(16))
            val rushingYardsPerAttempt = Float.parseFloat(record.get(17))
            val rushingTouchdowns = Integer.parseInt(record.get(18))
            val fantasyPoints = Float.parseFloat(record.get(19))

            val quarterback = QuarterbackModel(
                rank,
                playerId,
                playerName,
                team,
                position,
                week,
                opponent,
                passingCompletions,
                passingAttempts,
                passingCompletionPercentage,
                passingYards,
                passingYardsPerAttempt,
                passingTouchdowns,
                passingInterceptions,
                passingRating,
                rushingAttempts,
                rushingYards,
                rushingYardsPerAttempt,
                rushingTouchdowns,
                fantasyPoints,
            )

            quarterbacks.add(quarterback)
        }
        return quarterbacks
    }
}