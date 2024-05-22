package com.json.project.model;

import org.springframework.stereotype.Controller;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Controller
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Json {

	private int request_id;
	private int feeder_id;
	private int is_old_mtr_available;
	private String existing_mtr_msn;
	private String existing_mtr_make;
	private int existing_mtr_fn_kwh;
	private int existing_mtr_fn_kvah;
	private String external_ct_ratio;
	private String external_pt_ratio;
	private int existing_mtr_mf;
	private int existing_mtr_rmd;
	private String existing_mtr_status;
	private String existing_mtr_remark;
	private String new_mtr_installation_datetime;
	private String new_mtr_msn;
	private String new_mtr_make;
	private int new_mtr_mf;
	private int new_mtr_initial_rdg_kwh;
	private int new_mtr_initial_rdg_kvah;
	private String new_mtr_ct_ratio;
	private String new_mtr_pt_ratio;
	private int new_mtr_rmd;
	private String old_mtr_kwh_photo;
	private String old_mtr_kvah_photo;
	private String old_mtr_msn_photo;
	private String old_mtr_metering_unit_photo;
	private String old_mtr_seal1_photo;
	private String old_mtr_seal2_photo;
	private String new_mtr_kwh_photo;
	private String new_mtr_kvah_photo;
	private String new_mtr_msn_photo;
	private String new_mtr_seal1_number;
	private String new_mtr_seal2_number;
	private String new_mtr_seal1_photo;
	private String new_mtr_seal2_photo;
	
}
