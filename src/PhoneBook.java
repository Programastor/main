import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PhoneBook {

    private Map<String, List<String>> book = new HashMap<>();

    public void add(String surname, String phoneNumber) {

        book.putIfAbsent(surname, new ArrayList<>());
        book.get(surname).add(phoneNumber);
    }

    public List<String> get(String surname) {
        return book.getOrDefault(surname, Collections.emptyList());
    }
}