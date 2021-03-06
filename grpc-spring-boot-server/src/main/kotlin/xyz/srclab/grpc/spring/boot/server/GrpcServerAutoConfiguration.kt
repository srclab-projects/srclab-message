package xyz.srclab.grpc.spring.boot.server

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
open class GrpcServerAutoConfiguration {

    @ConfigurationProperties(prefix = "grpc.server")
    @ConditionalOnMissingBean
    @Bean("xyz.srclab.spring.boot.grpc.server.GrpcServersProperties")
    open fun grpcServersProperties(): GrpcServersProperties {
        return GrpcServersProperties()
    }

    @ConditionalOnMissingBean
    @Bean("xyz.srclab.spring.boot.grpc.server.GrpcServersFactory")
    open fun grpcServersFactory(): GrpcServersFactory {
        return DefaultGrpcServersFactory()
    }

    @ConditionalOnMissingBean
    @Bean("xyz.srclab.spring.boot.grpc.server.GrpcServerFactory")
    open fun grpcServerFactory(): GrpcServerFactory {
        return DefaultGrpcServerFactory()
    }

    @ConditionalOnMissingBean
    @Bean("xyz.srclab.spring.boot.grpc.server.GrpcServerLifecycle")
    open fun grpcServerLifecycle(): GrpcServerLifecycle {
        return GrpcServerLifecycle()
    }

    @ConditionalOnMissingBean
    @Bean("xyz.srclab.spring.boot.grpc.server.DefaultGrpcServerConfigureHelper")
    open fun defaultGrpcServerConfigureHelper(): DefaultGrpcServerConfigureHelper {
        return DefaultGrpcServerConfigureHelper()
    }
}