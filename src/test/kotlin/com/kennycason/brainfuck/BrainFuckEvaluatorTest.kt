package com.kennycason.brainfuck

import org.junit.Assert.assertEquals
import org.junit.Test
import java.nio.file.Files

/**
 * Created by kenny on 7/6/17.
 */
class BrainFuckEvaluatorTest {
    private val evaluator = BrainFuckEvaluator()

    @Test
    fun test() {
        val context = evaluator.evaluate(load("helloworld.bf"))
        assertEquals("Hello World!\n", context.stdOut.toString())
    }

    private fun load(resource: String): String {
        val inputStream = this.javaClass.getResourceAsStream("/com/kennycason/brainfuck/$resource")
        return inputStream.bufferedReader().use { it.readText() }
    }

}