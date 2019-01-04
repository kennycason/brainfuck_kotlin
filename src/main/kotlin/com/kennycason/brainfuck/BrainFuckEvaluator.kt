package com.kennycason.brainfuck

/**
 * Created by kenny on 7/6/17.
 */
class BrainFuckEvaluator {

    fun evaluate(code: String): Context {
        val context = Context()
        var parens = 0
        var i = 0
        while (i < code.length - 1) {
            when (code[i]) {
                '>' -> context.ip++
                '<' -> context.ip--
                '+' -> context.memory.inc(context.ip)
                '-' -> context.memory.dec(context.ip)
                '.' -> context.stdOut.append(context.memory.read(context.ip).toChar())
                '[' -> {
                    if (context.memory.read(context.ip) == 0) {
                        i++ // skip token
                        while (parens > 0 || code[i] != ']') {
                            when (code[i]) {
                                '[' -> parens++
                                ']' -> parens--
                            }
                            i++ // skip token
                        }
                    }
                }
                ']' -> {
                    if (context.memory.read(context.ip) != 0) {
                        i-- // go back
                        while (parens > 0 || code[i] != '[') {
                            when (code[i]) {
                                ']' -> parens++
                                '[' -> parens--
                            }
                            i-- // go back
                        }
                        i-- // go back
                    }
                }
            }
            i++
        }
        return context
    }

    data class Context(
            val memory: Memory = Memory(),
            var ip: Int = 0,
            val stdOut: StringBuilder = StringBuilder()
    )

    class Memory {
        private val memory: MutableList<Int> = mutableListOf()

        fun inc(address: Int) {
            if (memory.size <= address) {
                memory.add(address, 0)
            }
            memory[address]++
        }

        fun dec(address: Int) {
            if (memory.size <= address) {
                memory.add(address, 0)
            }
            memory[address]--
        }

        fun read(address: Int): Int {
            if (memory.size <= address) {
                return 0
            }
            return memory[address]
        }

        override fun toString(): String {
            return "Memory(memory=$memory)"
        }


    }

}