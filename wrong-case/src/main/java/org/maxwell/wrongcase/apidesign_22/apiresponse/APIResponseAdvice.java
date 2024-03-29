package org.maxwell.wrongcase.apidesign_22.apiresponse;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.MethodParameter;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import javax.servlet.http.HttpServletRequest;

//此段代码只是Demo，生产级应用还需要扩展很多细节
@RestControllerAdvice
@Slf4j
public class APIResponseAdvice implements ResponseBodyAdvice<Object> {

    //自动处理APIException，包装为APIResponse
    @ExceptionHandler(APIException.class)
    public APIResponse handleApiException(HttpServletRequest request, APIException ex) {
        log.error("process url {} failed", request.getRequestURL().toString(), ex);
        APIResponse apiResponse = new APIResponse();
        apiResponse.setSuccess(false);
        apiResponse.setCode(ex.getErrorCode());
        apiResponse.setMessage(ex.getErrorMessage());
        return apiResponse;
    }

    //仅当方法或类没有标记@NoAPIResponse才自动包装
    @Override
    public boolean supports(MethodParameter returnType, Class converterType) {
        return returnType.getParameterType() != APIResponse.class
                && AnnotationUtils.findAnnotation(returnType.getMethod(), NoAPIResponse.class) == null
                && AnnotationUtils.findAnnotation(returnType.getDeclaringClass(), NoAPIResponse.class) == null;
    }

    /**
     * 自动包装外层APIResposne响应 统一接口响应体
     *
     * @param body the body to be written
     * @param returnType the return type of the controller method
     * @param selectedContentType the content type selected through content negotiation
     * @param selectedConverterType the converter type selected to write to the response
     * @param request the current request
     * @param response the current response
     * @return
     */
    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        APIResponse apiResponse = new APIResponse();
        apiResponse.setSuccess(true);
        apiResponse.setMessage("OK");
        apiResponse.setCode(2000);
        apiResponse.setData(body);
        return apiResponse;
    }
}