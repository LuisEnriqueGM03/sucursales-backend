package com.empresa.sucursales_api.application.auth.port.in;

import com.empresa.sucursales_api.application.auth.dto.LoginRequest;
import com.empresa.sucursales_api.application.auth.dto.LoginResponse;
import com.empresa.sucursales_api.application.auth.dto.LogoutResponse;

public interface AuthUseCase {
    LoginResponse login(LoginRequest request);
    LogoutResponse logout(String correoInstitucional);
}
