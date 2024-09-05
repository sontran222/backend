package com.DeviceManager.Device.Exception;

import com.DeviceManager.Device.dto.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalException{
    @ExceptionHandler(value = RuntimeException.class)
    ResponseEntity<?> runtimeExceptionHandler(RuntimeException e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }

//    @ExceptionHandler(value = MethodArgumentNotValidException.class)
//    ResponseEntity<?> methodArgumentNotValidExceptionHandler(MethodArgumentNotValidException e) {
//        return ResponseEntity.badRequest().body(e.getFieldError().getDefaultMessage());
//    }

    @ExceptionHandler(value = AppException.class)
    ResponseEntity<ApiResponse> handlingAppException(AppException e) {
        ApiResponse apiResponse = new ApiResponse();
        apiResponse.setMessage(e.getErrorCode().getMessage());
        apiResponse.setCode(e.getErrorCode().getCode());
        return ResponseEntity.badRequest().body(apiResponse);
    }

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    ResponseEntity<ApiResponse> handlingAppExceptionMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        String enumKey = e.getFieldError().getDefaultMessage();
        ErrorCode errorCode = ErrorCode.valueOf(enumKey);

        ApiResponse apiResponse = new ApiResponse();

        apiResponse.setCode(errorCode.getCode());
        apiResponse.setMessage(errorCode.getMessage());

        return ResponseEntity.badRequest().body(apiResponse);
    }
}
