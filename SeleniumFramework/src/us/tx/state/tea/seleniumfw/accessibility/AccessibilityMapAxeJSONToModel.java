package us.tx.state.tea.seleniumfw.accessibility;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import us.tx.state.tea.seleniumfw.accessibility.model.SeleniunFWAxeValidation;

public class AccessibilityMapAxeJSONToModel {
	
	static public List<SeleniunFWAxeValidation> getListofValidations(JSONArray validations) throws JsonParseException, JsonMappingException, JSONException, IOException
	{
		List<SeleniunFWAxeValidation> listOfValidations = new ArrayList<SeleniunFWAxeValidation>();
		
		for (int i = 0; i < validations.length(); i++) {
			JSONObject violation = validations.getJSONObject(i);

			ObjectMapper oMapper = new ObjectMapper();
			
			SeleniunFWAxeValidation mappedObj = oMapper.readValue(violation.toString(), SeleniunFWAxeValidation.class);
			
			listOfValidations.add(mappedObj);						
		}	
		
		return listOfValidations;
	}
	
}
