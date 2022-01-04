package com.lee.mht.system.exception;

import com.lee.mht.system.common.Constant;
import com.lee.mht.system.common.ResultObj;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author FucXing
 * @date 2022/01/04 13:31
 **/
@RestControllerAdvice
@Slf4j
public class RestExceptionHandler {

    @ExceptionHandler(UnauthorizedException.class)
    public ResultObj unauthorizedException(UnauthorizedException e){
        log.error("UnauthorizedException,{},{}",e.getLocalizedMessage(),e);
        return new ResultObj(Constant.PERMISSION_ERROR,Constant.NOT_PERMISSION);
    }

    @ExceptionHandler(AuthenticationException.class)
    public ResultObj authenticationException(AuthenticationException e){
        log.error("authenticationException,{},{}",e.getLocalizedMessage(),e);
        return new ResultObj(Constant.TOKEN_ERROR,Constant.ILLEAGEL_TOKEN);
    }
}