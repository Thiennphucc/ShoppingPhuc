package com.shopPhuc.ShoppingOnline.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class dtoRegister {
    @Size(min = 5, max = 30, message = "UserName phải nằm trong khoản 5-30 ký tự")
    @NotBlank(message = "Không được để trống")
    private String username;
    @Size(min = 5, max = 30, message = "Password phải nằm trong khoản 5-30 ký tự")
    @NotBlank(message = "Không được để trống")
    private String password;
    @Size(min = 15, max = 200, message = "Email phải nằm trong khoản 5-30 ký tự")
    @NotBlank(message = "Không được để trống")
    @Email(message = "Không đúng định dạng")
    private String email;
}
