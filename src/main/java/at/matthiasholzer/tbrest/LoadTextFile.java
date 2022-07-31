package at.matthiasholzer.tbrest;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;

public class LoadTextFile {

    public static ArrayList<Entry> getEntryList(){
        ArrayList<Entry> entryList = new ArrayList<>();
        try {
            Object o = new JSONParser().parse(new FileReader("src/main/resources/sample-data.txt"));
            JSONArray ja = (JSONArray) o;
            for(int i = 0; i < ja.size(); i++){
                JSONObject jo = (JSONObject) ja.get(i);
                entryList.add(
                        Entry.builder()
                                .id(Long.parseLong((String) jo.get("id")))
                                .project_person_id(Long.parseLong((String) jo.get("project_person_id")))
                                .project_kam_id(Long.parseLong((String) jo.get("project_kam_id")))
                                .position_id(Long.parseLong((String) jo.get("position_id")))
                                .project_id(Long.parseLong((String) jo.get("project_id")))
                                .project_number(Long.parseLong((String) jo.get("project_number")))
                                .due_date(Date.valueOf(((String) jo.get("due_date"))))
                                .last_status((String) jo.get("last_status"))
                        .build());
            }
        } catch (ParseException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return entryList;
    }
}
