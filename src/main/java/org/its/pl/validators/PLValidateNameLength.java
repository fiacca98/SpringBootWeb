package org.its.pl.validators;

import org.its.pl.entity.Utente;

import javax.inject.Named;

@Named("plValidator")
public class PLValidateNameLength implements PLValidator {
    @Override
    public boolean validate(Utente utenteBO) {
        return utenteBO.getName().length() >= 3;
    }
}
