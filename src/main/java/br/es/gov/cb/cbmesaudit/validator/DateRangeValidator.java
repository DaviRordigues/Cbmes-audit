package br.es.gov.cb.cbmesaudit.validator;

import br.es.gov.cb.cbmesaudit.dtos.AuditFilterDTO;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class DateRangeValidator implements ConstraintValidator<ValidDateRange, AuditFilterDTO> {

    @Override
    public boolean isValid(AuditFilterDTO value, ConstraintValidatorContext context) {
        if (value.getStartDate() == null || value.getEndDate() == null) {
            return false;
        }
        return !value.getStartDate().isAfter(value.getEndDate());
    }
}
