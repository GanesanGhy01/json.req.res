package com.json.project.repo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.json.project.model.Json;
import com.json.project.response.JsonResponse;

@Repository
public class JsonRepo {

	
	@Autowired
	private JdbcTemplate template;
	public JdbcTemplate getTemplate() {
		return template;
	}
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}
	public JsonResponse saveJson(Json json) {
		String sql = "insert into json values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		int row = template.update(sql, 
				json.getRequest_id(),
				json.getFeeder_id(),
				json.getIs_old_mtr_available(),
				json.getExisting_mtr_msn(),
				json.getExisting_mtr_make(),
				json.getExisting_mtr_fn_kwh(),
				json.getExisting_mtr_fn_kvah(),
				json.getExternal_ct_ratio(),
				json.getExternal_pt_ratio(),
				json.getExisting_mtr_mf(),
				json.getExisting_mtr_rmd(),
				json.getExisting_mtr_status(),
				json.getExisting_mtr_remark(),
				json.getNew_mtr_installation_datetime(),
				json.getNew_mtr_msn(),
				json.getNew_mtr_make(),
				json.getNew_mtr_mf(),
				json.getNew_mtr_initial_rdg_kwh(),
				json.getNew_mtr_initial_rdg_kvah(),
				json.getNew_mtr_ct_ratio(),
				json.getNew_mtr_pt_ratio(),
				json.getNew_mtr_rmd(),
				json.getOld_mtr_kwh_photo(),
				json.getOld_mtr_kvah_photo(),
				json.getOld_mtr_msn_photo(),
				json.getOld_mtr_metering_unit_photo(),
				json.getOld_mtr_seal1_photo(),
				json.getOld_mtr_seal2_photo(),
				json.getNew_mtr_kwh_photo(),
				json.getNew_mtr_kvah_photo(),
				json.getNew_mtr_msn_photo(),
				json.getNew_mtr_seal1_number(),
				json.getNew_mtr_seal2_number(),
				json.getNew_mtr_seal1_photo(),
				json.getNew_mtr_seal2_photo()
				);
		
		if(row > 0) {
			JsonResponse res = new JsonResponse();
			res.setRequest_id(json.getRequest_id());
			res.setStatus("SUCCESS");
			res.setDescription("OK");
			
			res.getRequest_id();
			res.getStatus();
			res.getDescription();
			
			return res;
		}
		return null;
	}
}
