import java.io.File

class FileReader() {

    fun getAllFilesInDirectory(directory: String): List<File> {
        return File(directory).walk()
            .filter { filepath -> filepath.isFile }
            .toList()
//            .forEach { file -> files.add(file) }

    }

    fun readFromCSV(file: File) {
        file.forEachLine { line -> println(line) }

    }
}