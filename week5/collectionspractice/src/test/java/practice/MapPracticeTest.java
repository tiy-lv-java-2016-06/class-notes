package practice;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * Created by jeff on 7/14/16.
 */
public class MapPracticeTest {

    MapPractice mapPractice;

    @Before
    public void setup(){
        mapPractice = new MapPractice();
    }

    public Map<String, String> createSimpleMap(){
        Map<String, String> students = new HashMap<>();

        students.put("Sally", "A");
        students.put("Fred", "C");
        students.put("Alice", "B");
        students.put("Jack", "B");

        return students;
    }

    public Map<String, User> createUserMap(){
        Map<String, User> users = new HashMap<>();
        users.put("Alice", new User("Alice", "alice@wonderland.gov"));
        users.put("Lucas", new User("Lucas", "lucas@iruinedstarwars.com"));
        users.put("Shaggy", new User("Shaggy", "shaggy@scoobyfans.com"));
        users.put("Doctor", new User("Doctor", "doctor@time.gov"));

        return users;
    }

    @Test
    public void whenCreateMapThenReturnMap(){
        Map<String, String> map = mapPractice.createMap();

        assertNotNull("Map Null", map);
        assertTrue(map.isEmpty());
    }

    @Test
    public void whenFillMapThenReturnCorrectMap(){
        Map<String, String> m = mapPractice.fillMap();

        assertNotNull(m);
        assertEquals(3, m.size());
    }

    @Test
    public void whenFindValueThenReturnValue(){
        Map<String, String> students = createSimpleMap();
        String student = students.keySet().iterator().next();
        String grade = students.get(student);

        String returnedGrade = mapPractice.findValue(students, student);
        assertNotNull(returnedGrade);
        assertEquals(grade, returnedGrade);
    }

    @Test
    public void whenHasValueThenReturnsTrue(){
        Map<String, String> students = createSimpleMap();
        String student = students.keySet().iterator().next();

        assertTrue(mapPractice.hasValue(students, student));
    }

    @Test
    public void whenHasValueThenReturnsFalse(){
        Map<String, String> students = createSimpleMap();

        assertFalse(mapPractice.hasValue(students, "FOOBAR"));
    }

    @Test
    public void whenGetUserThenReturnCorrectUser(){
        Map<String, User> users = createUserMap();
        String username = users.keySet().iterator().next();
        User expected = users.get(username);

        User user = mapPractice.getUser(users, username);
        assertNotNull(user);
        assertEquals(expected, user);
    }

    @Test
    public void whenAddUserThenAddsUser(){
        Map<String, User> users = createUserMap();
        String name = "Hiro";
        String email = "hiro@snowcrash.com";

        Map<String, User> newUsers = mapPractice.addUser(users, name, email);
        assertNotNull(newUsers);
        assertTrue(newUsers.containsKey(name));

        User hiro = newUsers.get(name);
        assertEquals(name, hiro.getName());
        assertEquals(email, hiro.getEmail());
    }

    @Test
    public void whenEditUserThenEditUser(){
        Map<String, User> users = createUserMap();
        String username = users.keySet().iterator().next();
        String newEmail = "test@test.com";

        Map<String, User> returned = mapPractice.editUser(users, username, newEmail);
        assertNotNull(returned);
        assertTrue(returned.containsKey(username));

        User user = returned.get(username);
        assertEquals(newEmail, user.getEmail());
    }
}
