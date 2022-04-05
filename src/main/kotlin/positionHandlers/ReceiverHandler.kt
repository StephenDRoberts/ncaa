package positionHandlers

import FileReader
import model.fantasyData.ReceiverModel
import org.apache.commons.csv.CSVParser
import java.lang.Float.parseFloat
import java.lang.Integer.parseInt
import java.nio.file.Paths

class ReceiverHandler(
    private val reader: FileReader
) {

    fun processReceivers(filepath: String): MutableList<ReceiverModel> {
        val csvParser = reader.parseCSV(Paths.get(filepath))
        return receiverTransformer(csvParser)
    }

    fun receiverTransformer(csvParser: CSVParser): MutableList<ReceiverModel> {
        val receivers = mutableListOf<ReceiverModel>()
        for (record in csvParser) {
            val rank = parseInt(record.get(0))
            val playerId = record.get(1)
            val playerName = record.get(2)
            val team = record.get(3)
            val position = record.get(4)
            val week = parseInt(record.get(5))
            val opponent = record.get(6)
            val receptions = parseInt(record.get(7))
            val receivingYards = parseInt(record.get(8))
            val receivingTouchdowns = parseInt(record.get(9))
            val receivingLong = parseInt(record.get(10))
            val receivingYardsPerReception = parseFloat(record.get(11))
            val rushingAttempts = parseInt(record.get(12))
            val rushingYards = parseInt(record.get(13))
            val rushingYardsPerAttempt = parseFloat(record.get(14))
            val rushingTouchdowns = parseInt(record.get(15))
            val fumbles = parseInt(record.get(16))
            val fumblesLost = parseInt(record.get(17))
            val fantasyPoints = parseFloat(record.get(18))

            val receiver = ReceiverModel(
                rank,
                playerId,
                playerName,
                team,
                position,
                week,
                opponent,
                receptions,
                receivingYards,
                receivingTouchdowns,
                receivingLong,
                receivingYardsPerReception,
                rushingAttempts,
                rushingYards,
                rushingYardsPerAttempt,
                rushingTouchdowns,
                fumbles,
                fumblesLost,
                fantasyPoints
            )
            receivers.add(receiver)
        }
        return receivers
    }
}