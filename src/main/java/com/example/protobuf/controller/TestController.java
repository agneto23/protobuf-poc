package com.example.protobuf.controller;
import com.boomsecret.protobuf.UserLogin;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {
    @PostMapping(value = "/demo/test", produces = "application/x-protobuf")
    @ResponseBody
    public UserLogin.UsersList getPersonProto(@RequestBody UserLogin.User request) {
        UserLogin.User.Builder user = UserLogin.User.newBuilder();
        user.setEmail(request.getEmail());
        UserLogin.UsersList.Builder builder = UserLogin.UsersList.newBuilder();
        builder.setUsers(0, user);
        return builder.build();
    }
}