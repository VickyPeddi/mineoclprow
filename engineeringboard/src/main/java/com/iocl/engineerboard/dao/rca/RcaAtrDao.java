package com.iocl.dhruva2api.dao.rca;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.ArrayList;

import com.iocl.dhruva2api.model.rca.RcaAtr;

public interface RcaAtrDao extends CrudRepository<RcaAtr, String> {

    @Query("from RcaAtr where ro_code =:roCode and ROOTCAUSE_SR =:rootCauseSr order by attribute_no")
    public ArrayList<RcaAtr> findByRoCodeAndSrNo(@Param("roCode") int roCode,@Param("rootCauseSr") int rootCauseSr);
}
