package org.its.pl.count;

import org.its.bl.count.CountBL;
import org.its.bl.count.MeetingCountBL;
import org.its.dl.count.MeetingCountDL;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.inject.Inject;
import javax.inject.Named;

@Controller
@RequestMapping("/api/appuntamento")
public class AppuntamentoCountController {

    private MeetingCountBL businessLayer;

    @Inject
    public AppuntamentoCountController(@Named("meetingCountBL") MeetingCountBL businessLayer){
        this.businessLayer = businessLayer;
    }
    @RequestMapping(
            path = "/countForUser/{{idUtente}}",
            method= RequestMethod.GET,
            produces="application/json")
    @ResponseBody
    public Count countForUser(@PathVariable("idUtente")String id) throws Exception{

        return new Count(businessLayer.countAppuntamenti(Integer.valueOf(id)));

    }
}
