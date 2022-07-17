package com.opsyx.openapi.sample.util

import com.opsyx.openapi.sample.exceptions.InternalException
import io.vavr.control.Try
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import java.util.function.Function

open class ResponseEntityUtil {
    companion object {
        fun <T> fromTryOk(tryVariable: Try<T>): ResponseEntity<T>? {
            return ResponseEntity(tryVariable.getOrElseThrow(Function<Throwable, RuntimeException> { t: Throwable -> handleException(t) }), HttpStatus.OK)
        }

        private fun handleException(t: Throwable): RuntimeException? {
            return if (t is RuntimeException) {
                t
            } else InternalException(t)
        }
    }
}