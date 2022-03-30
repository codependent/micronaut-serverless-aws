package com.codependent.aws

import com.amazonaws.services.lambda.runtime.RequestHandler
import io.micronaut.function.aws.runtime.AbstractMicronautLambdaRuntime
import java.net.MalformedURLException

class FunctionLambdaRuntime : AbstractMicronautLambdaRuntime<Map<String, Any>, Void, Map<String, Any>, Unit>() {

    override fun createRequestHandler(vararg args: String): RequestHandler<Map<String, Any>, Unit> {
        return FunctionHandler()
    }

    companion object {
        @JvmStatic
        fun main(vararg args: String) {
            try {
                FunctionLambdaRuntime().run(*args)
            } catch (e: MalformedURLException) {
                e.printStackTrace()
            }
        }
    }

}
