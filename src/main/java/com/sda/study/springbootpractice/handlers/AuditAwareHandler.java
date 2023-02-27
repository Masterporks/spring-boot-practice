package com.sda.study.springbootpractice.handlers;

import com.sda.study.springbootpractice.utils.Constance;
import org.springframework.data.domain.AuditorAware;

import java.util.Optional;

/**
 *
 * Custom handler to implement AuditAware
 */
public class AuditAwareHandler implements AuditorAware<String> {
    @Override
    public Optional<String> getCurrentAuditor() {
        return Optional.of(Constance.Audit.DEFAULT_AUDITOR);
    }
}
