package at.matthiasholzer.tbrest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class TbController {
    ArrayList arrayList = LoadTextFile.getEntryList();

    @GetMapping
    public List<Entry> getAll(){
        return  arrayList;
    }
}
