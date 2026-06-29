package com.hmr.shared.audit;

import lombok.NonNull;
import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.jwt.Jwt;


import java.util.Optional;

public class AuditorAwareImpl implements AuditorAware<String> {

    @Override
    @NonNull
    public Optional<String> getCurrentAuditor() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication == null || !authentication.isAuthenticated()) {
            return Optional.of("system");
        }

        if (authentication.getPrincipal() instanceof Jwt jwt) {
            String username = jwt.getClaimAsString("preferred_username");
            return Optional.ofNullable(username).or(() -> Optional.of("system"));
        }

        return Optional.of(authentication.getName());
    }
}
