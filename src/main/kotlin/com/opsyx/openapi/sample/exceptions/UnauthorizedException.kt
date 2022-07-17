package com.opsyx.openapi.sample.exceptions

class UnauthorizedException(t: Throwable) : RuntimeException(t) {
}