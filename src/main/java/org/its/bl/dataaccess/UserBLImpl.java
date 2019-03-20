package org.its.bl.dataaccess;

import org.its.bl.BOConverterService;
import org.its.bl.UtenteMessage;
import org.its.bl.entity.UtenteBO;
import org.its.bl.validators.BLValidator;
import org.its.bus.Bus;
import org.its.dl.dataaccess.UserDL;
import org.its.dl.entity.UtenteDL;

import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;

@Named("userBl")
public class UserBLImpl implements UserBL {
    private final UserDL dataLayer;
    private Bus bus;
    private BLValidator validator;
    private BLValidator validateProfanities;
    private List<UtenteBO> listaUtenteBO = new ArrayList<UtenteBO>();
    private BOConverterService boConverterService = new BOConverterService();


    public UserBLImpl(
            @Named("userDl")UserDL dataLayer,
            @Named("blValidateName")BLValidator validator,
            @Named("bus") Bus bus){
        this.dataLayer = dataLayer;
        this.validator = validator;
        this.bus = bus;
        this.validateProfanities = validateProfanities;
    }

    @Override
    public List<UtenteBO> getAll() {
        listaUtenteBO = new ArrayList<UtenteBO>();
        for (UtenteDL utenteDL : dataLayer.getAll()) {
            UtenteBO utenteBo = boConverterService.convertToUtenteBO(utenteDL);
            listaUtenteBO.add(utenteBo);
        }
        return listaUtenteBO;
    }

    @Override
    public UtenteBO getById(String id)  {

        for (UtenteDL utenteDL : dataLayer.getAll()) {
            if ( utenteDL.getId() == Integer.parseInt(id)){
                UtenteBO result = boConverterService.convertToUtenteBO(utenteDL);
                return  result;
            }
        }
        return null;
    }

    @Override
    public UtenteBO add(UtenteBO utenteBO) {
        validateBl(utenteBO);
        utenteBO.setEnabled(false);
        UtenteDL utenteDL = boConverterService.convertToUtenteDL(utenteBO);

        UtenteBO responseUtenteBo = boConverterService.convertToUtenteBO(dataLayer.add(utenteDL));
        return responseUtenteBo;
    }


    @Override
    public boolean delete(String id) {
        String error;
        try {
            int parsedId = Integer.parseInt(id);
            UtenteBO user = this.getById(id);
            boolean result = dataLayer.delete(parsedId);
            if(result && user.isEnabled()) {
                UtenteMessage message = new UtenteMessage();
                message.setEnabled(false);
                bus.send(message);
            }
            return result;
        } catch (NumberFormatException f) {
          error =   "Non è un numero";
          return false;
        }
    }

    @Override
    public UtenteBO modificaUtente(UtenteBO utenteBO, String id) {
        validateBl(utenteBO);
        delete(id);
        return add(utenteBO);
    }

    @Override
    public void abilitaUtente(String id) throws Exception {
        UtenteBO utenteBO = this.getById(id);
        if(utenteBO == null){
            throw new Exception("Utente non esistente");
        }
        utenteBO.setEnabled(true);
        UtenteDL utenteDL = boConverterService.convertToUtenteDL(utenteBO);
        boolean isUpdated = dataLayer.update(utenteDL);
        if(isUpdated){
            UtenteMessage message = new UtenteMessage();
            message.setEnabled(true);
            bus.send(message);
        }
    }

    @Override
    public void disabilitaUtente(String id) throws Exception {
        UtenteBO utenteBO = this.getById(id);
        if(utenteBO == null){
            throw new Exception("Utente non esistente");
        }
        utenteBO.setEnabled(false);
        UtenteDL utenteDL = boConverterService.convertToUtenteDL(utenteBO);
        boolean isUpdated = dataLayer.update(utenteDL);
        if(isUpdated){
            UtenteMessage message = new UtenteMessage();
            message.setEnabled(false);
            bus.send(message);
        }
    }

    private boolean validateBl(UtenteBO utenteBO) {
        return validator.validate(utenteBO);
    }
}


