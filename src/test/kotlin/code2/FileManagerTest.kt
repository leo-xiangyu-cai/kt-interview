package code2

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class FileManagerTest {

    @Test
    fun `Given no file When getTotalSize Then return 0`() {
        // arrange
        val fileManager = FileManager()

        // act
        val result = fileManager.getTotalSize()

        // assert
        result shouldBe 0
    }

    @Test
    fun `Given a couple of files When getTotalSize Then return the total size`() {
        // arrange
        val fileManager = FileManager()
        fileManager.files.add(File("File1", 100, listOf("collection1")))
        fileManager.files.add(File("File2", 200, listOf("collection1")))
        fileManager.files.add(File("File3", 300, listOf("collection2")))
        fileManager.files.add(File("File4", 10, listOf("collection1")))

        // act
        val result = fileManager.getTotalSize()

        // assert
        result shouldBe 610
    }

    @Test
    fun `Given a couple of files When getTopCollections Then return the sorted top collections`() {
        // arrange
        val fileManager = FileManager()
        fileManager.files.add(File("File1", 100, listOf("collection1")))
        fileManager.files.add(File("File2", 220, listOf("collection1")))
        fileManager.files.add(File("File3", 300, listOf("collection2")))
        fileManager.files.add(File("File4", 10, listOf("collection3")))

        // act
        val result = fileManager.getTopCollections(3)

        // assert
        result shouldBe listOf("collection1", "collection2", "collection3")
    }

    @Test
    fun `Given a couple of files When getTopCollections which number less than collection count Then return the sorted top collections`() {
        // arrange
        val fileManager = FileManager()
        fileManager.files.add(File("File1", 100, listOf("collection1")))
        fileManager.files.add(File("File2", 220, listOf("collection1")))
        fileManager.files.add(File("File3", 300, listOf("collection2")))
        fileManager.files.add(File("File4", 10, listOf("collection3")))
        fileManager.files.add(File("File5", 300, listOf("collection4")))
        fileManager.files.add(File("File6", 10, listOf("collection5")))
        fileManager.files.add(File("File7", 300, listOf("collection2")))
        fileManager.files.add(File("File8", 10, listOf("collection3")))

        // act
        val result = fileManager.getTopCollections(3)

        // assert
        result shouldBe listOf("collection2", "collection1", "collection4")
    }

    @Test
    fun `Given a couple of files some with no collection When getTopCollections Then return the sorted top collections`() {
        // arrange
        val fileManager = FileManager()
        fileManager.files.add(File("File1", 100, listOf("collection1")))
        fileManager.files.add(File("File2", 220, listOf("")))
        fileManager.files.add(File("File3", 300, listOf("")))
        fileManager.files.add(File("File4", 10, listOf("collection3")))
        fileManager.files.add(File("File5", 301, listOf("collection4")))
        fileManager.files.add(File("File6", 10, listOf("collection5")))
        fileManager.files.add(File("File7", 300, listOf("collection2")))
        fileManager.files.add(File("File8", 10, listOf("collection3")))

        // act
        val result = fileManager.getTopCollections(3)

        // assert
        result shouldBe listOf("collection4", "collection2", "collection1")
    }
}