class FantasyDataNCAAHandler(
    private val reader: FileReader
) {

    fun printlns(){
        val filepath = "/Users/Stephen.Roberts2/Documents/NCAA/fantasy-data-ncaa-adapter/src/main/resources"

        reader.readFromCSV(filepath)
    }
}