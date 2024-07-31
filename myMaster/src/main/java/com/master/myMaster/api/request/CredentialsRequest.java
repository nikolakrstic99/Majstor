package com.master.myMaster.api.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

public record CredentialsRequest(String email, String password) {
}
