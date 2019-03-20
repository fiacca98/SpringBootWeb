package org.its.pl;

import org.its.bl.dataaccess.MeetingBL;
import org.its.bl.dataaccess.UserBL;
import org.its.bl.entity.AppuntamentoBL;
import org.its.dl.count.CountDL;
import org.its.dl.count.MeetingCountDL;
import org.its.dl.dataaccess.MeetingDL;
import org.its.pl.entity.Appuntamento;
import org.its.pl.validators.PLValidator;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/api/appuntamento")
public class AppuntamentoController {
    private final MeetingBL businessLayer;
    private PLConverterService plConverterService = new PLConverterService() ;
    private MeetingCountDL countDL;

    @Inject
    public AppuntamentoController(
            @Named("meetingBL")MeetingBL businessLayer,
            @Named("meetingCountDL") MeetingCountDL meetingCountDL){

        this.businessLayer = businessLayer;
        this.countDL = countDL;
    }

    @RequestMapping(
            path = "/{id}",
            method = RequestMethod.GET,
            produces = "application/json")

    @ResponseBody
    public List<Appuntamento> getById(@PathVariable("id") String id) throws Exception {

        String currentId = id;
        List<AppuntamentoBL> appuntamentiBL = businessLayer.getByIdUtente(Integer.valueOf(id));
        List<Appuntamento> appuntamenti = new ArrayList<Appuntamento>();
        for (AppuntamentoBL appuntamentoBL : appuntamentiBL){
            Appuntamento appuntamento = plConverterService.convertToAppuntamento(appuntamentoBL);
            appuntamenti.add(appuntamento);
        }

        if (appuntamenti.size()==0) throw new Exception("Utente senza appuntamentis");
        return appuntamenti;
    }

    //post
    @RequestMapping(
            path = "/add",
            method= RequestMethod.POST,
            produces="application/json",
            consumes = "application/json")
    @ResponseBody
    public Appuntamento postAppuntamento(@RequestBody Appuntamento request) throws Exception{

        AppuntamentoBL appuntamentoBL = plConverterService.convertToAppuntamentoBL(request);

            AppuntamentoBL responsePostAppuntamentoBL= businessLayer.add(appuntamentoBL);
            Appuntamento response = plConverterService.convertToAppuntamento(responsePostAppuntamentoBL);
            return response;
    }

    //deleteById
    @RequestMapping(
            path = "/delete/{id}",
            method = RequestMethod.GET,
            produces = "application/json")

    @ResponseBody
    public String deleteById(@PathVariable("id") String id) throws Exception {
        if (businessLayer.removeByIdAppuntamento(Integer.valueOf(id)) == true) return "Appuntamento eliminato" ;
        else  throw new Exception("Impossibile eliminare l'appuntamento");
    }
    //put
    @RequestMapping(
            path = "/{id}",
            method= RequestMethod.PUT,
            produces="application/json",
            consumes = "application/json")
    @ResponseBody
    public Appuntamento modificaAppuntamento(@RequestBody Appuntamento request, @PathVariable("id") String id) throws Exception{
        AppuntamentoBL appuntamentoBL = plConverterService.convertToAppuntamentoBL(request);


            boolean responsePostUtenteBO = businessLayer.updateByIdAppuntamento(Integer.valueOf(id), appuntamentoBL);
        Appuntamento response = null;
            if (responsePostUtenteBO)
                response = request;
            return response;

    }
}
