package org.its.bl.dataaccess;

import org.its.bl.AppuntamentoMessage;
import org.its.bl.BOConverterService;
import org.its.bl.UtenteMessage;
import org.its.bl.entity.AppuntamentoBL;
import org.its.bus.Bus;
import org.its.dl.dataaccess.MeetingDL;
import org.its.dl.dataaccess.UserDL;
import org.its.dl.entity.AppuntamentoDL;

import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;

@Named("meetingBL")
public class MeetingBLImpl implements MeetingBL {

    private final MeetingDL dataLayer;
    private Bus bus;
    private BOConverterService boConverterService = new BOConverterService();

    public MeetingBLImpl(
            @Named("meetingDL")MeetingDL dataLayer,
            @Named("bus") Bus bus){
        this.dataLayer = dataLayer;
        this.bus = bus;
    }

    @Override
    public List<AppuntamentoBL> getAll() {
        List<AppuntamentoBL> appuntamentiBL = new ArrayList<AppuntamentoBL>();
        for (AppuntamentoDL appuntamentoDL : dataLayer.getAll()) {
            AppuntamentoBL appuntamentoBL = boConverterService.convertToAppuntamentoBL(appuntamentoDL);
            appuntamentiBL.add(appuntamentoBL);
        }
        return appuntamentiBL;
    }

    @Override
    public List<AppuntamentoBL> getByIdUtente(int idUtente) {
        List<AppuntamentoBL> appuntamentiBL = new ArrayList<AppuntamentoBL>();
        for (AppuntamentoDL appuntamentoDL : dataLayer.getByIdUtente(idUtente)) {
            AppuntamentoBL appuntamentoBL = boConverterService.convertToAppuntamentoBL(appuntamentoDL);
            appuntamentiBL.add(appuntamentoBL);
        }
        return appuntamentiBL;
    }

    @Override
    public AppuntamentoBL add(AppuntamentoBL appuntamentoBL) {

        bus.send(new AppuntamentoMessage(true, appuntamentoBL.getIdUtente()));
        return boConverterService.convertToAppuntamentoBL(
                dataLayer.add(boConverterService.convertToAppuntamentoDL(appuntamentoBL))
        );
    }

    @Override
    public boolean removeByIdAppuntamento(int idAppuntamento) {
        boolean result = dataLayer.removeByIdAppuntamento(idAppuntamento);
        if (result)
            bus.send(new AppuntamentoMessage(false, idAppuntamento));
        return result;
    }

    @Override
    public boolean updateByIdAppuntamento(int idAppuntamento, AppuntamentoBL appuntamentoBL) {
        return dataLayer.updateByIdAppuntamento(idAppuntamento, boConverterService.convertToAppuntamentoDL(appuntamentoBL));
    }
}
