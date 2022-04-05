package model.fantasyData

data class QuarterbackModel(
    val rank: Int,
    val playerId: String,
    val playerName: String,
    val teamName: String,
    val position: String,
    val week: Int,
    val opponent: String,
    val passingCompletions: Int,
    val passingAttempts: Int,
    val passingCompletionPercentage: Float,
    val passingYards: Int,
    val passingYardsPerAttempt: Float,
    val passingTouchdowns: Int,
    val passingInterceptions: Int,
    val passingRating: Float,
    val rushingAttempts: Int,
    val rushingYards: Int,
    val rushingYardsPerAttempt: Float,
    val rushingTouchdowns: Int,
    val fantasyPoints: Float
)
