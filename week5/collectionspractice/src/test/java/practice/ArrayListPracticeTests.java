package practice;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by jeff on 7/14/16.
 */
public class ArrayListPracticeTests {

    private ArrayListPractice practice;

    @Before
    public void setup(){
        practice = new ArrayListPractice();
    }

    public List<User> createUserList(){
        List<User> users = new ArrayList<>();
        users.add(new User("Alice", "alice@wonderland.gov"));
        users.add(new User("Lucas", "lucas@iruinedstarwars.com"));
        users.add(new User("Shaggy", "shaggy@scoobyfans.com"));
        users.add(new User("Doctor", "doctor@time.gov"));
        return users;
    }

    @Test
    public void whenCreateOneThenReturnArraylist(){
        List<String> emptyAL = practice.createOne();

        assertNotNull("Empty List null", emptyAL);
        assertTrue("Empty list not empty", emptyAL.isEmpty());
    }

    @Test
    public void whenCreateOneWithEntryArrayListwithOneElement(){
        List<String> list = practice.createOneWithEntry("Hello");

        assertEquals("Not correct elements", list.size(), 1);
        assertTrue("Element Missing", list.contains("Hello"));
    }

    @Test
    public void whenCreateUserListThenReturnsListOfThree(){
        List<User> l = practice.createUserList();

        assertNotNull("List is null", l);
        assertEquals("Wrong number of elements", 3, l.size());
    }

    @Test
    public void whenRemoveItemByNameThenItemRemoved(){
        List<String> items = new ArrayList<>();
        items.add("Ender");
        items.add("Bean");
        items.add("Petra");
        items.add("Jane");
        items.add("Valentine");

        List<String> newItems = practice.removeItem(items, "Petra");
        assertNotNull("Items list null", newItems);
        assertEquals("Wrong Item count", 4, newItems.size());
        assertFalse("Item not removed", newItems.contains("Petra"));
    }

    @Test
    public void whenRemoveItemByName(){
        List<User> users = createUserList();

        //Grab first User
        User user = users.get(0);

        List<User> newUsers = practice.removeItemByName(users, user.getName());
        assertNotNull("New Users is null", newUsers);
        assertFalse("User is still present", newUsers.contains(user));
    }

    @Test
    public void whenUpdateEmailAddressThenUpdateCorrectObject(){
        List<User> users = createUserList();

        User user = users.get(1);
        int size = users.size();

        List<User> newUsers = practice.updateEmailAddress(users, user.getName(), "test@test.com");
        assertNotNull(newUsers);
        assertEquals("List different size", size, users.size());
        assertEquals("Email not changed", "test@test.com", user.getEmail());
    }

}
