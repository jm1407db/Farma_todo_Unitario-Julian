import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThrows;

import org.junit.Test;

import model.Person;

public class PersonTest {
    @Test
    public void TestConstructorPersonExitosos(){
        Person person = new Person("pepe", 'C', "213124");
        assertNotNull(person);
        assertEquals("pepe", person.getName());
        assertEquals('C', person.getDoc_type());
        assertEquals("213124", person.getDoc_num());
    }
    @Test
    public void TestConstructorPersonInvalidoNombre(){
        Exception exception= assertThrows(IllegalArgumentException.class, ()->{
            Person person = new Person(null, 'C', "213124");
        });     
    }
    @Test
    public void TestConstructorPersonInvalidoDoctype(){
        Exception exception= assertThrows(IllegalArgumentException.class, ()->{
            Person person = new Person("pepe", '\u0000', "213124");
        });  
    }
    @Test
    public void TestConstructorPersonInvalidoDocNum(){
        Exception exception= assertThrows(IllegalArgumentException.class, ()->{
            Person person = new Person("pepe", '\u0000', null);
        });
    }
}
