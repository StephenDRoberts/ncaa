package model.fantasyData

data class RunningbackModel(
    val rank: Int,
    val playerId: String,
    val playerName: String,
    val team: String,
    val position: String,
    val week: Int,
    val opponent: String,
    val rushingAttempts: Int,
    val rushingYards: Int,
    val rushingYardsPerAttempt: Float,
    val rushingTouchdowns: Int,
    val receptions: Int,
    val receivingYards: Int,
    val receivingTouchdowns: Int,
    val fumbles: Int,
    val fumblesLost: Int,
    val fantasyPoint: Float
)
