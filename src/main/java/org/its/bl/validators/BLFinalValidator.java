package org.its.bl.validators;

import org.its.bl.entity.UtenteBO;

import javax.inject.Named;

@Named("finalBlValidator")
public class BLFinalValidator implements BLValidator{
    @Override
    public boolean validate(UtenteBO utente) {
        return true;
    }
}
