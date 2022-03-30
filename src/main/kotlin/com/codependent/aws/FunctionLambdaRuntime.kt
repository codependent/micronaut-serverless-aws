package com.codependent.aws

import com.amazonaws.services.lambda.runtime.RequestHandler
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent
import io.micronaut.function.aws.runtime.AbstractMicronautLambdaRuntime
import java.net.MalformedURLException

class FunctionLambdaRuntime : AbstractMicronautLambdaRuntime<APIGatewayProxyRequestEvent, APIGatewayProxyResponseEvent, Map<String, String>, Map<String, String>>() {

    override fun createRequestHandler(vararg args: String): RequestHandler<Map<String, String>, Map<String, String>> {
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
