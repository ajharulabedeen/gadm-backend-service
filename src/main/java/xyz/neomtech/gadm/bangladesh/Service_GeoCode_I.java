/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xyz.neomtech.gadm.bangladesh;

import xyz.neomtech.gadm.bangladesh.models.DistrictsEngName;
import xyz.neomtech.gadm.bangladesh.models.DivisionsEngName;
import xyz.neomtech.gadm.bangladesh.models.UnionsEngName;
import xyz.neomtech.gadm.bangladesh.models.UpzillaEngName;

import java.util.List;

/**
 *
 * @author G7
 */
public interface Service_GeoCode_I {

    List<DistrictsEngName> getDistricts(String divID);

    List<DivisionsEngName> getDivisions();

    List<UnionsEngName> getUnions(String upzID);

    List<UpzillaEngName> getUpzillas(String distID);
    
}
