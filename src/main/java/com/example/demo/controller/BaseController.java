package com.example.demo.controller;

import com.example.demo.entity.ApiResponse;
import com.example.demo.entity.ArgumentInvalidResult;
import org.apache.ibatis.javassist.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;

import java.util.ArrayList;
import java.util.List;

public class BaseController {

    // 分页大小
    protected static final String pageSize = "10";

    /**
     * 成功返回
     * @param data
     * @return
     */
    protected ApiResponse<Object> apiSuccess(Object data) {
        return new ApiResponse<>(0, "", data);
    }

    /**
     * 失败返回
     * @param code
     * @param message
     * @return
     */
    protected ApiResponse<Object> apiFail(int code, String message) {
        return new ApiResponse<>(code, message, null);
    }


    /**
     * 失败返回
     * @param message
     * @return
     */
    public ApiResponse<Object> apiFail(String message) {
        return new ApiResponse<>(ApiResponse.COMMON_BIZ_ERROR, message);
    }

    /**
     * 失败返回验证错误
     * @param errors
     * @return
     */
    protected ApiResponse<Object> apiValidateError(ArgumentInvalidResult errors) {
        List<ArgumentInvalidResult> invalidArguments = new ArrayList<>();
        ApiResponse<Object> resp = new ApiResponse<Object>(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.name());
        invalidArguments.add(errors);
        resp.setErrors(invalidArguments);

        return resp;
    }

    protected void validate(BindingResult br) throws BindException {
        if (br.hasErrors()) {
            throw new BindException(br);
        }
    }

    protected void  notFound(Object model, String errMsg) throws NotFoundException {
        if (model == null) {
            throw new NotFoundException(errMsg);
        }
    }

}
