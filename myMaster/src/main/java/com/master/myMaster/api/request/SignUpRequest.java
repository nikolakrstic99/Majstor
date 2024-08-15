package com.master.myMaster.api.request;

public record SignUpRequest(String firstName, String lastName, String email, String password,
                            String phone, String location) {

}
