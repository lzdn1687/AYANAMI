package com.whoiszxl.exception;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.whoiszxl.common.ResponseCode;
import com.whoiszxl.common.ServerResponse;

/**
 * 全局异常处理
 * @author whoiszxl
 *
 */
//@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler{
	
	private static Logger log = LoggerFactory.getLogger("全局异常");

	@Override
	protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body, HttpHeaders headers,
			HttpStatus status, WebRequest request) {
		return super.handleExceptionInternal(ex, body, headers, status, request);
	}
	
	@ExceptionHandler(value = Exception.class)
    @ResponseBody
    public ServerResponse<String> jsonHandler(HttpServletRequest request, Exception e) throws Exception {
		log.error("错误地址：" + request.getRequestURI());
		log.error("错误信息：" + e);
        return ServerResponse.createByErrorCodeMessage(ResponseCode.SYSTEM_ERROR.getCode(), ResponseCode.SYSTEM_ERROR.getDesc());
    }
}
