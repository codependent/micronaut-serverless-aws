package com.codependent.aws

import io.micronaut.core.annotation.Introspected
import io.micronaut.function.aws.MicronautRequestHandler

@Introspected
class FunctionHandler : MicronautRequestHandler<Map<String,String>, Map<String,String>>() {

    override fun execute(input: Map<String,String>): Map<String,String> {
        return input.map { Pair(it.key.uppercase(), it.value.uppercase()) }.toMap()
    }
}
