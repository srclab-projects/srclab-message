package xyz.srclab.spring.boot.grpc.server

import org.springframework.core.annotation.AliasFor
import org.springframework.stereotype.Component

@Target(AnnotationTarget.CLASS)
@Retention(AnnotationRetention.RUNTIME)
@MustBeDocumented
@Component
annotation class GrpcService(

    /**
     * Group name of gRPC service, default is empty means [DEFAULT_GROUP_NAME].
     */
    @get:AliasFor("group")
    val value: Array<String> = [],

    /**
     * Group name of gRPC service, default is empty means [DEFAULT_GROUP_NAME].
     */
    @get:AliasFor("value")
    val group: Array<String> = [],
)
