package com.json.project.service;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.util.Base64;

import javax.imageio.ImageIO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.json.project.model.Json;
import com.json.project.repo.JsonRepo;
import com.json.project.request.JsonRequest;
import com.json.project.response.JsonResponse;

@Service
public class JsonService {

	@Autowired 
	JsonRepo repo;
	
	public JsonResponse insertJson(JsonRequest jsonreq) throws IOException {
		
		// encoded string
		String base64String_Unit = jsonreq.getOld_mtr_metering_unit_photo();
		String base64String_Old_Seal1 = jsonreq.getOld_mtr_seal1_photo();
		String base64String_New_Seal1 = jsonreq.getNew_mtr_seal1_photo();
		String base64String_New_Seal2= jsonreq.getNew_mtr_seal2_photo();
		// decoded string
		byte[] imageDataUnit = Base64.getDecoder().decode(base64String_Unit);
		byte[] imageDataOldSeat1 = Base64.getDecoder().decode(base64String_Old_Seal1);
		byte[] imageDataNewSeat1 = Base64.getDecoder().decode(base64String_New_Seal1);
		byte[] imageDataNewSeat2 = Base64.getDecoder().decode(base64String_New_Seal2);
		ByteArrayInputStream bis1 = new ByteArrayInputStream(imageDataUnit);
		ByteArrayInputStream bis2 = new ByteArrayInputStream(imageDataOldSeat1);
		ByteArrayInputStream bis3 = new ByteArrayInputStream(imageDataNewSeat1);
		ByteArrayInputStream bis4 = new ByteArrayInputStream(imageDataNewSeat2);
		
		BufferedImage image1 = ImageIO.read(bis1);
		BufferedImage image2 = ImageIO.read(bis2);
		BufferedImage image3 = ImageIO.read(bis3);
		BufferedImage image4 = ImageIO.read(bis4);
		
		bis1.close();
		bis2.close();
		bis3.close();
		bis4.close();
		 
		String fileName1 = "unit.jpg";
		String fileName2 = "old_seat1.jpg";
		String fileName3 = "new_seat1.jpg";
		String fileName4 = "new_seat2.jpg";
		
 		String outputFilePath1 = "D://FrontEnd/"+fileName1;
 		String outputFilePath2 = "D://FrontEnd/"+fileName2;
 		String outputFilePath3 = "D://FrontEnd/"+fileName3;
 		String outputFilePath4 = "D://FrontEnd/"+fileName4;
		
 		File outputFile1 = new File(outputFilePath1);
        ImageIO.write(image1, "jpg", outputFile1);
        File outputFile2 = new File(outputFilePath2);
        ImageIO.write(image2, "jpg", outputFile2);
        File outputFile3 = new File(outputFilePath3);
        ImageIO.write(image3, "jpg", outputFile3);
        File outputFile4 = new File(outputFilePath4);
        ImageIO.write(image4, "jpg", outputFile4);
        
        Json json = new Json();
		json.setRequest_id(jsonreq.getRequest_id());
		json.setFeeder_id(jsonreq.getFeeder_id());
		json.setIs_old_mtr_available(jsonreq.getIs_old_mtr_available());
		json.setExisting_mtr_msn(jsonreq.getExisting_mtr_msn());
		json.setExisting_mtr_make(jsonreq.getExisting_mtr_make());
		json.setExisting_mtr_fn_kwh(jsonreq.getExisting_mtr_fn_kwh());
		json.setExisting_mtr_fn_kvah(jsonreq.getExisting_mtr_fn_kvah());
		json.setExternal_ct_ratio(jsonreq.getExternal_ct_ratio());
		json.setExternal_pt_ratio(jsonreq.getExternal_pt_ratio());
		json.setExisting_mtr_mf(jsonreq.getExisting_mtr_mf());
		json.setExisting_mtr_rmd(jsonreq.getExisting_mtr_rmd());
		json.setExisting_mtr_status(jsonreq.getExisting_mtr_status());
		json.setExisting_mtr_remark(jsonreq.getExisting_mtr_remark());
		json.setNew_mtr_installation_datetime(jsonreq.getNew_mtr_installation_datetime());
		json.setNew_mtr_msn(jsonreq.getNew_mtr_msn());
		json.setNew_mtr_make(jsonreq.getNew_mtr_make());
		json.setNew_mtr_mf(jsonreq.getNew_mtr_mf());
		json.setNew_mtr_initial_rdg_kwh(jsonreq.getNew_mtr_initial_rdg_kwh());
		json.setNew_mtr_initial_rdg_kvah(jsonreq.getNew_mtr_initial_rdg_kvah());
		json.setNew_mtr_ct_ratio(jsonreq.getNew_mtr_ct_ratio());
		json.setNew_mtr_pt_ratio(jsonreq.getNew_mtr_pt_ratio());
		json.setOld_mtr_kwh_photo(jsonreq.getOld_mtr_kwh_photo());
		json.setOld_mtr_kvah_photo(jsonreq.getOld_mtr_kvah_photo());
		json.setOld_mtr_msn_photo(jsonreq.getOld_mtr_msn_photo());
		json.setOld_mtr_metering_unit_photo(fileName1);
		json.setOld_mtr_seal1_photo(fileName2);
		json.setOld_mtr_seal2_photo(jsonreq.getOld_mtr_seal2_photo());
		json.setNew_mtr_kwh_photo(jsonreq.getNew_mtr_kwh_photo());
		json.setNew_mtr_kvah_photo(jsonreq.getNew_mtr_kvah_photo());
		json.setNew_mtr_msn_photo(jsonreq.getNew_mtr_msn_photo());
		json.setNew_mtr_seal1_number(jsonreq.getNew_mtr_seal1_number());
		json.setNew_mtr_seal2_number(jsonreq.getNew_mtr_seal2_number());
		json.setNew_mtr_seal1_photo(fileName3);
		json.setNew_mtr_seal2_photo(fileName4);
		return repo.saveJson(json);
	}
	
}
//package com.json.project;
//
//import java.awt.image.BufferedImage;
//import java.io.ByteArrayInputStream;
//import java.io.File;
//import java.io.IOException;
//import java.util.Base64;
//
//import javax.imageio.ImageIO;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//@Service
//public class JsonService {
//
//    @Autowired 
//    JsonRepo repo;
//
//    public JsonResponse insertJson(JsonRequest jsonreq) throws IOException {
//        String[] base64Strings = {
//            jsonreq.getOld_mtr_metering_unit_photo(),
//            jsonreq.getOld_mtr_seal1_photo(),
//            jsonreq.getNew_mtr_seal1_photo(),
//            jsonreq.getNew_mtr_seal2_photo()
//        };
//
//        String[] fileNames = {
//            "unit.jpg",
//            "old_seat1.jpg",
//            "new_seat1.jpg",
//            "new_seat2.jpg"
//        };
//
//        for (int i = 0; i < base64Strings.length; i++) {
//            byte[] imageData = Base64.getDecoder().decode(base64Strings[i]);
//            ByteArrayInputStream bis = new ByteArrayInputStream(imageData);
//            BufferedImage image = ImageIO.read(bis);
//            String outputFilePath = "D://FrontEnd/" + fileNames[i];
//            File outputFile = new File(outputFilePath);
//            ImageIO.write(image, "jpg", outputFile);
//            bis.close();
//        }
//
//        Json json = mapJson(jsonreq, fileNames);
//        return repo.saveJson(json);
//    }
//
//    private Json mapJson(JsonRequest jsonreq, String[] fileNames) {
//        Json json = new Json();
//        json.setRequest_id(jsonreq.getRequest_id());
//        json.setFeeder_id(jsonreq.getFeeder_id());
//        json.setIs_old_mtr_available(jsonreq.getIs_old_mtr_available());
//        // map other attributes...
//        json.setOld_mtr_metering_unit_photo(fileNames[0]);
//        json.setOld_mtr_seal1_photo(fileNames[1]);
//        json.setNew_mtr_seal1_photo(fileNames[2]);
//        json.setNew_mtr_seal2_photo(fileNames[3]);
//        return json;
//    }
//}

