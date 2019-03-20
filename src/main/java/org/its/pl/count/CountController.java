package org.its.pl.count;

import org.its.bl.count.CountBL;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.inject.Inject;
import javax.inject.Named;

@Controller
@RequestMapping("/api/utente")
public class CountController {

    private CountBL businessLayer;

    @Inject
    public CountController(@Named("countBL")CountBL businessLayer){
        this.businessLayer = businessLayer;
    }

    //put
    @RequestMapping(
            path = "/countEnabled",
            method= RequestMethod.GET,
            produces="application/json")
    @ResponseBody
    public Count countEnabled() throws Exception{

        return new Count(businessLayer.countEnabled());

    }
}
