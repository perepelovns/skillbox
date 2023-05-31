package com.example.hw1756

import kotlinx.coroutines.cancelAndJoin
import kotlinx.coroutines.delay
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch
import kotlinx.coroutines.withTimeout
import java.math.BigInteger

object Fibonacci {
    suspend fun take(n: Int, timeoutMillis: Long): BigInteger = withTimeout(timeoutMillis) {
        var prev = BigInteger.ZERO
        var current = BigInteger.ONE

        val indicatorJob = launch {
            while (isActive) {
                delay(500)
                print(".")
            }
        }

        val calculationJob = launch {
            repeat(n) {
                val next = prev + current
                prev = current
                current = next

                delay(100) // Задержка для увеличения времени выполнения
            }
        }

        calculationJob.join()
        indicatorJob.cancelAndJoin()
        prev
    }
}