package test.xyz.srclab.grpc.spring.boot.server;

import io.grpc.Metadata;
import io.grpc.ServerCall;
import io.grpc.Status;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import xyz.srclab.grpc.spring.boot.context.GrpcContext;
import xyz.srclab.grpc.spring.boot.server.GrpcServerInterceptor;
import xyz.srclab.grpc.spring.boot.server.interceptors.SimpleServerInterceptor;

@GrpcServerInterceptor(servicePatterns = "*3", order = 1)
public class TestSimpleInterceptor1 implements SimpleServerInterceptor {

    private static final Logger logger = LoggerFactory.getLogger(TestSimpleInterceptor1.class);

    @Override
    public <ReqT, RespT> void intercept(
        ServerCall<ReqT, RespT> call,
        Metadata headers,
        GrpcContext context) {
        logger.info(">>>>Simple>>>>intercept1: {} | {}",
            context.getString(TestConstants.CONTEXT_KEY_1),
            context.getString(TestConstants.CONTEXT_KEY_2)
        );
        //Assert.assertEquals(context.getString(TestConstants.CONTEXT_KEY_1), null);
        //Assert.assertEquals(context.getString(TestConstants.CONTEXT_KEY_2), null);
    }

    @Override
    public <ReqT, RespT> void onReady(
        ServerCall<ReqT, RespT> call,
        Metadata headers,
        GrpcContext context) {
        logger.info(">>>>Simple>>>>onReady1: {} | {}",
            context.getString(TestConstants.CONTEXT_KEY_1),
            context.getString(TestConstants.CONTEXT_KEY_2)
        );
        //Assert.assertEquals(context.getString(TestConstants.CONTEXT_KEY_1), TestConstants.CONTEXT_VALUE_1);
        //Assert.assertEquals(context.getString(TestConstants.CONTEXT_KEY_2), null);
    }

    @Override
    public <ReqT, RespT> void onMessage(
        ReqT message,
        ServerCall<ReqT, RespT> call,
        Metadata headers,
        GrpcContext context) {
        context.set(TestConstants.CONTEXT_KEY_2, TestConstants.CONTEXT_VALUE_2);
        logger.info(">>>>Simple>>>>onMessage1: {} | {}",
            context.getString(TestConstants.CONTEXT_KEY_1),
            context.getString(TestConstants.CONTEXT_KEY_2)
        );
        //Assert.assertEquals(context.getString(TestConstants.CONTEXT_KEY_1), TestConstants.CONTEXT_VALUE_1);
        //Assert.assertEquals(context.getString(TestConstants.CONTEXT_KEY_2), TestConstants.CONTEXT_VALUE_2);
    }

    @Override
    public <ReqT, RespT> void onHalfClose(
        ServerCall<ReqT, RespT> call,
        Metadata headers,
        GrpcContext context) {
        logger.info(">>>>Simple>>>>onHalfClose1: {} | {}",
            context.getString(TestConstants.CONTEXT_KEY_1),
            context.getString(TestConstants.CONTEXT_KEY_2)
        );
        //Assert.assertEquals(context.getString(TestConstants.CONTEXT_KEY_1), TestConstants.CONTEXT_VALUE_1);
        //Assert.assertEquals(context.getString(TestConstants.CONTEXT_KEY_2), TestConstants.CONTEXT_VALUE_2);
    }

    @Override
    public <ReqT, RespT> void sendHeaders(
        Metadata sentHeaders,
        ServerCall<ReqT, RespT> call,
        Metadata headers,
        GrpcContext context) {
        logger.info("sendHeaders1: {}", sentHeaders);
        logger.info(">>>>Simple>>>>sendHeaders1: {} | {}",
            context.getString(TestConstants.CONTEXT_KEY_1),
            context.getString(TestConstants.CONTEXT_KEY_2)
        );
        //Assert.assertEquals(context.getString(TestConstants.CONTEXT_KEY_1), TestConstants.CONTEXT_VALUE_1);
        //Assert.assertEquals(context.getString(TestConstants.CONTEXT_KEY_2), TestConstants.CONTEXT_VALUE_2);
    }

    @Override
    public <ReqT, RespT> void sendMessage(
        RespT sentMessage,
        ServerCall<ReqT, RespT> call,
        Metadata headers,
        GrpcContext context) {
        logger.info(">>>>Simple>>>>sendMessage1: {} | {}",
            context.getString(TestConstants.CONTEXT_KEY_1),
            context.getString(TestConstants.CONTEXT_KEY_2)
        );
        //Assert.assertEquals(context.getString(TestConstants.CONTEXT_KEY_1), TestConstants.CONTEXT_VALUE_1);
        //Assert.assertEquals(context.getString(TestConstants.CONTEXT_KEY_2), TestConstants.CONTEXT_VALUE_2);
    }

    @Override
    public <ReqT, RespT> void close(
        Status status,
        Metadata trailers,
        ServerCall<ReqT, RespT> call,
        Metadata headers,
        GrpcContext context) {
        logger.info(">>>>Simple>>>>close1: {} | {}",
            context.getString(TestConstants.CONTEXT_KEY_1),
            context.getString(TestConstants.CONTEXT_KEY_2)
        );
        //Assert.assertEquals(context.getString(TestConstants.CONTEXT_KEY_1), TestConstants.CONTEXT_VALUE_1);
        //Assert.assertEquals(context.getString(TestConstants.CONTEXT_KEY_2), TestConstants.CONTEXT_VALUE_2);
    }

    @Override
    public <ReqT, RespT> void onCancel(
        ServerCall<ReqT, RespT> call,
        Metadata headers,
        GrpcContext context) {
        logger.info(">>>>Simple>>>>onCancel1: {} | {}",
            context.getString(TestConstants.CONTEXT_KEY_1),
            context.getString(TestConstants.CONTEXT_KEY_2)
        );
        //Assert.assertEquals(context.getString(TestConstants.CONTEXT_KEY_1), TestConstants.CONTEXT_VALUE_1);
        //Assert.assertEquals(context.getString(TestConstants.CONTEXT_KEY_2), TestConstants.CONTEXT_VALUE_2);
    }

    @Override
    public <ReqT, RespT> void onComplete(
        ServerCall<ReqT, RespT> call,
        Metadata headers,
        GrpcContext context) {
        logger.info(">>>>Simple>>>>onComplete1: {} | {}",
            context.getString(TestConstants.CONTEXT_KEY_1),
            context.getString(TestConstants.CONTEXT_KEY_2)
        );
        //Assert.assertEquals(context.getString(TestConstants.CONTEXT_KEY_1), TestConstants.CONTEXT_VALUE_1);
        //Assert.assertEquals(context.getString(TestConstants.CONTEXT_KEY_2), TestConstants.CONTEXT_VALUE_2);
    }

    @Override
    public <ReqT, RespT> void onException(
        Throwable cause,
        ServerCall<ReqT, RespT> call,
        Metadata headers,
        GrpcContext context) {
        logger.info(">>>>Simple>>>>onException1: {} | {}",
            context.getString(TestConstants.CONTEXT_KEY_1),
            context.getString(TestConstants.CONTEXT_KEY_2),
            cause
        );
        //Assert.assertEquals(context.getString(TestConstants.CONTEXT_KEY_1), TestConstants.CONTEXT_VALUE_1);
        //Assert.assertEquals(context.getString(TestConstants.CONTEXT_KEY_2), TestConstants.CONTEXT_VALUE_2);
        call.close(Status.INTERNAL, headers);
    }
}
