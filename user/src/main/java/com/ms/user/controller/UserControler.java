package com.ms.user.controller;

import com.ms.user.models.UserModel;
import com.ms.user.record.UserRecordDTO;
import com.ms.user.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserControler {

    final UserService userService;

    public UserControler(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("users/")
    public ResponseEntity<UserModel> saveUSer(@RequestBody @Valid UserRecordDTO userRecordDTO){
        var userModel= new UserModel();
        BeanUtils.copyProperties(userRecordDTO,userModel);
        return  ResponseEntity.status(HttpStatus.CREATED).body(this.userService.save(userModel));
    }
}
