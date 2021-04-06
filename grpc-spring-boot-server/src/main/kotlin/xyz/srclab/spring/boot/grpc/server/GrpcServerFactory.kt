package xyz.srclab.spring.boot.grpc.server

import io.grpc.BindableService
import io.grpc.Server
import io.grpc.ServerInterceptor
import xyz.srclab.common.collect.MutableSetMap

/**
 * Factory to create gRPC server.
 */
interface GrpcServerFactory {

    fun create(
        serverProperties: GrpcServerProperties,
        serversProperties: GrpcServersProperties,
        serviceGroups: MutableSetMap<String, BindableService>,
        interceptorGroups: MutableSetMap<String, ServerInterceptor>,
    ): Server
}