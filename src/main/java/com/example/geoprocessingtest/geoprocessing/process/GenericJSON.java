package com.example.geoprocessingtest.geoprocessing.process;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.*;

public class GenericJSON {
    Map<String, Object> jsonContent = new LinkedHashMap<>();

    public GenericJSON(Map<String, Object> jsonContent) {
        this.jsonContent = jsonContent;
    }

    public GenericJSON() {
    }

    public GenericJSON(String source) {
        try {
            JSONObject jsonObject = new JSONObject(source);
            Iterator<String> keys = jsonObject.keys();
            while (keys.hasNext()) {
                String key = keys.next();
                if (jsonObject.get(key) instanceof JSONArray) {
                    jsonContent.put(key, JSONArrayToJsonContent((JSONArray) jsonObject.get(key)));
                } else if (jsonObject.get(key) instanceof JSONObject) {
                    jsonContent.put(key, JSONObjectToJsonContent((JSONObject) jsonObject.get(key)));
                } else {
                    jsonContent.put(key, jsonObject.get(key));
                }
            }
        } catch (JSONException err) {
            System.out.println("Error" + err.toString());
        }
    }

    private List<Object> JSONArrayToJsonContent(JSONArray jsonArray) {
        List<Object> l = new ArrayList<Object>();
        if(jsonArray!=null && jsonArray.length()>0){
            for (int i = 0; i < jsonArray.length(); i++) {
                Object jsonObject = jsonArray.get(i);
                if (jsonObject instanceof JSONArray) {
                    l.add(JSONArrayToJsonContent((JSONArray) jsonObject));
                } else if (jsonObject instanceof JSONObject) {
                    l.add(JSONObjectToJsonContent((JSONObject) jsonObject));
                } else {
                    l.add(jsonObject);
                }
            }
        }
        return l;
    }

    private Map<String, Object> JSONObjectToJsonContent(JSONObject jsonObject) {
        Map<String, Object> m = new LinkedHashMap<>();
        Iterator<String> keys = jsonObject.keys();
        while (keys.hasNext()) {
            String key = keys.next();
            if (jsonObject.get(key) instanceof JSONArray) {
                m.put(key, JSONArrayToJsonContent((JSONArray) jsonObject.get(key)));
            } else if (jsonObject.get(key) instanceof JSONObject) {
                m.put(key, JSONObjectToJsonContent((JSONObject) jsonObject.get(key)));
            } else {
                m.put(key, jsonObject.get(key));
            }
        }
        return m;
    }

    @JsonAnySetter
    public void setJsonContent(String key, Object value) {
        jsonContent.put(key, value);
    }

    @Override
    public String toString() {
        JSONObject jo = new JSONObject(jsonContent);
        return jo.toString();
    }

    public JSONObject toJSONObject() {
        JSONObject jo = new JSONObject(jsonContent);
        return jo;
    }

    @JsonAnyGetter
    public Map<String, Object> toMap() {
        return jsonContent;
    }
}
