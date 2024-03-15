package peaksoft.service;

import peaksoft.dto.request.SignUpRequest;
import peaksoft.dto.response.SignUpResponse;

public interface UserService {
    SignUpResponse signUp(SignUpRequest signUpRequest);
}
