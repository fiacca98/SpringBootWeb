package org.etlabora.pl;

import org.etlabora.bl.UtenteBL;
import org.etlabora.bl.UtenteBO;
import org.etlabora.conversionutility.BOPLConversion;
import org.etlabora.dl.UtenteDLO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import javax.inject.Named;
import java.lang.annotation.Inherited;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/api/simple")
public class SimpleController {

    UtenteBL utenteBL;

    @Inject
    public SimpleController(@Named("utenteBL")UtenteBL utenteBL) {

        this.utenteBL = utenteBL;
    }

    @RequestMapping(path = "/utente/{id}",method = RequestMethod.GET,produces = "application/json")
    @ResponseBody
    public Utente getUtente(@PathVariable("id") String id){

        UtenteBO resultBO = utenteBL.getUser(Integer.valueOf(id));

        Utente result = BOPLConversion.fromUtenteBOToUtente(resultBO);

        return result;
    }

    @RequestMapping(path = "/utente/all",method = RequestMethod.GET,produces = "application/json")
    @ResponseBody
    public List<Utente> getAllUtenti(){

        List<UtenteBO> resultBO = utenteBL.getAll();

        List<Utente> resultList = new ArrayList<Utente>();
        for(UtenteBO user : resultBO)
        {
            Utente utente = BOPLConversion.fromUtenteBOToUtente(user);
            resultList.add(utente);
        }

        return resultList;
    }

    @RequestMapping(path = "/utente",method = RequestMethod.POST,produces = "text/html")
    @ResponseBody
    public String updateUtente(@RequestBody Utente utente){
        return "insert utente con id: " + utente.getId() + " e nome: " + utente.getName() ;
    }

    @RequestMapping(path = "/utente/{nome}",method = RequestMethod.PUT,produces = "application/json")
    @ResponseBody
    public Utente insertUtente(@PathVariable("nome") String nome){

    }

    @RequestMapping(path = "/utente/{id}",method = RequestMethod.DELETE,produces = "application/json")
    @ResponseBody
    public String deleteUtente(@PathVariable("id") String id){
        return "delete utente: " + id;
    }

}
