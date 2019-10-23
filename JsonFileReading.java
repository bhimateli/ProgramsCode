/*
 * @author bteli
 * */

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonFileReading {
	static JSONParser jsonParser = new JSONParser();
	/*
	 * reading json object from saved json
	 */
	@SuppressWarnings("unchecked")
	public static void readJsonFileObject() {
		
		FileReader fr = null;
		try {
			fr = new FileReader("C:\\D\\emp.json");
			// Read JSON file
			Object obj = jsonParser.parse(fr);

			// JSONArray employeeList = (JSONArray) obj;
			JSONObject jb = (JSONObject) obj;
			
			
			//pass json object and get back json object with replace values
			jb = replaceJsonValues(jb);
			
			System.out.println("Object of json file" + jb);
		} catch (FileNotFoundException e) {
			e.printStackTrace();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/*
	 * reading json array from saved json file
	 */
	public static void readJsonFileArray() {
		JSONParser jsonParser = new JSONParser();
		FileReader fr = null;
		try {
			fr = new FileReader("C:\\D\\empArray.json");
			// Read JSON file
			Object obj = jsonParser.parse(fr);

			JSONArray employeeList = (JSONArray) obj;
			// JSONObject jb = (JSONObject) obj;

			System.out.println("Array of json file " + employeeList);
		} catch (FileNotFoundException e) {
			e.printStackTrace();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/*
	 * replace the values from the json
	 */
	public static JSONObject replaceJsonValues(JSONObject jb) throws ParseException {
		// Convert to string
		  String jsonValue = jb.toString();
		  System.out.println("Object of to String Before Replace " + jsonValue);
		  // replace values
		  jsonValue = jsonValue.replace("Lokesh","Logesh");  // these values u can pass from any file.
		  System.out.println("After replace " + jsonValue);
		  
		  // Convert to string to json object
		  jb = (JSONObject)	  jsonParser.parse(jsonValue);
		  return jb;
	}

	public static void main(String[] args) {
		// JSON parser object to parse read file

		readJsonFileArray();
		readJsonFileObject();
	}
}

