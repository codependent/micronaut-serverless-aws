package com.codependent.aws

import io.micronaut.core.annotation.Introspected
import io.micronaut.function.aws.MicronautRequestHandler
import jakarta.inject.Inject
import org.slf4j.LoggerFactory
import software.amazon.awssdk.services.s3.S3Client


@Introspected
class FunctionHandler : MicronautRequestHandler<Map<String, Any>, Unit>() {

    private val logger = LoggerFactory.getLogger(javaClass)

    @Inject
    lateinit var s3Client: S3Client

    override fun execute(input: Map<String, Any>){
        logger.info("Got {}", input)
    }
}
