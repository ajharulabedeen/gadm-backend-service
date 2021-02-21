/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xyz.neomtech.gadm.bangladesh;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import xyz.neomtech.gadm.bangladesh.models.DistrictsEngName;
import xyz.neomtech.gadm.bangladesh.models.DivisionsEngName;
import xyz.neomtech.gadm.bangladesh.models.UnionsEngName;
import xyz.neomtech.gadm.bangladesh.models.UpzillaEngName;

import java.util.List;

/**
 * @author G7
 */
@RestController
@RequestMapping("/api/v3.6/bangladesh")
public class Controller_Bangladesh {

    @Autowired
    private Service_GeoCode_I service_GeoCode_I;

    @GetMapping(value = "divisions")
    public List<DivisionsEngName> getDivisions() {
        return service_GeoCode_I.getDivisions();
    }

    @PostMapping(value = "districts")
    public List<DistrictsEngName> getDistricts(@RequestParam String divID) {
        return service_GeoCode_I.getDistricts(divID);
    }

    @PostMapping(value = "upzillas")
    public List<UpzillaEngName> getDivisions(@RequestParam String distID) {
        return service_GeoCode_I.getUpzillas(distID);
    }

    @PostMapping(value = "unions")
    public List<UnionsEngName> getUnions(@RequestParam String upzID) {
        return service_GeoCode_I.getUnions(upzID);
    }

}
