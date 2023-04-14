package miu.edu.lab5_Demo.Service;

import miu.edu.lab5_Demo.Dto.request.LoginRequest;
import miu.edu.lab5_Demo.Dto.request.RefreshTokenRequest;
import miu.edu.lab5_Demo.Dto.response.LoginResponse;

public interface AuthService {

    LoginResponse login(LoginRequest loginRequest);
    LoginResponse refreshToken(RefreshTokenRequest refreshTokenRequest);
}
