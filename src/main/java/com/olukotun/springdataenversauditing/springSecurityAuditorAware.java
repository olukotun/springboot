package com.olukotun.springdataenversauditing;

import org.springframework.data.domain.AuditorAware;

import java.util.Date;
import java.util.Optional;

public class springSecurityAuditorAware implements AuditorAware<Auditable> {
    @Override
    public Optional<Auditable> getCurrentAuditor() {
        Auditable auditable = new Auditable() {
            @Override
            public String getUpdatedBy() {
                return super.getUpdatedBy();
            }


            @Override
            public Date getDateUpdated() {
                return super.getDateUpdated();
            }
        };

        return null;


    }
}
