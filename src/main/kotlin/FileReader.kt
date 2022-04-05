import model.fantasyData.QuarterbackModel
import org.apache.commons.csv.CSVFormat
import org.apache.commons.csv.CSVParser
import java.lang.Float.parseFloat
import java.lang.Integer.parseInt
import java.lang.instrument.ClassFileTransformer
import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.Paths

class FileReader() {

    fun getAllFilesInDirectory(directory: String): List<Path> {
        return Files.walk(Paths.get(directory))
            .filter { filepath -> Files.isRegularFile(filepath) }
            .toList()
    }

    fun parseCSV(path: Path): CSVParser {

        val reader = Files.newBufferedReader(path)
        val format = CSVFormat.Builder.create()
            .setHeader()
            .setSkipHeaderRecord(true).build()
        return CSVParser(reader, format)

    }

    fun readFiles(directory: String) {
        val files = getAllFilesInDirectory(directory)

        for (file in files) {
            parseCSV(file)
        }
    }

//    fun readLine(line: String) {
////        val bufferedReader = BufferedReader(line)
//        CSVParser.parse(line, CSVFormat.EXCEL)
//
//
//
//    }


}