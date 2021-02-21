/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xyz.neomtech.gadm.bangladesh;

import org.springframework.stereotype.Component;
import xyz.neomtech.gadm.bangladesh.models.DistrictsEngName;
import xyz.neomtech.gadm.bangladesh.models.DivisionsEngName;
import xyz.neomtech.gadm.bangladesh.models.UnionsEngName;
import xyz.neomtech.gadm.bangladesh.models.UpzillaEngName;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 *
 * @author G7
 */
@Component
public class Dao_GeoCode_Impl implements Dao_GeoCode_I {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<DivisionsEngName> getDivisions() {
        String sql = "SELECT divisions.id, divisions.name FROM divisions";
        return entityManager.createNativeQuery(sql, DivisionsEngName.class).getResultList();
    }

    @Override
    public List<DistrictsEngName> getDistricts(String divID) {
        String sql = "SELECT districts.id, districts.name FROM districts WHERE districts.division_id=" + divID;
        return entityManager.createNativeQuery(sql, DistrictsEngName.class).getResultList();
    }

    @Override
    public List<UpzillaEngName> getUpzillas(String distID) {
        String sql = "SELECT upazilas.id, upazilas.name FROM upazilas WHERE upazilas.district_id=" + distID;
        return entityManager.createNativeQuery(sql, UpzillaEngName.class).getResultList();
    }

    @Override
    public List<UnionsEngName> getUnions(String upzID) {
        String sql = "SELECT unions.id, unions.name FROM unions WHERE unions.upazilla_id=" + upzID;
        return entityManager.createNativeQuery(sql, UnionsEngName.class).getResultList();
    }

}
