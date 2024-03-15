package peaksoft.dto.response;

import lombok.Builder;
import peaksoft.enums.Role;

@Builder
public record SignUpResponse(
        String email,
        String token,
        Role role
) {
}
