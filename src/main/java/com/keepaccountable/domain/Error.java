package com.keepaccountable.domain;

import lombok.Data;
import org.jetbrains.annotations.NotNull;

@Data
public class Error {

    @NotNull
    private String error;
    @NotNull
    private String description;
}
