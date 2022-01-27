import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ControllerTest {

    @Test
    public void testAnythingMockito234() {
        Service service = mock(Service.class);
        when(service.cicuska(anyInt())).thenThrow(new RuntimeException());
        //Service service = mock(Service.class);
        assertThrows(RuntimeException.class, () -> service.cicuska(27));
    }

    @Test
    public void testAnythingMockito23() {
        Service service = mock(Service.class);
        when(service.cicuska(anyInt())).thenReturn(22).thenReturn(201).thenReturn(20022);
        assertEquals(22, service.cicuska(27));
        assertEquals(201, service.cicuska(27));
        /*assertEquals(20022, service.cicuska(27));
        assertEquals(20022, service.cicuska(27));
        assertEquals(20022, service.cicuska(27));
        assertEquals(20022, service.cicuska(27));*/
    }

    @Test
    public void testAnythingMockito2() {
        Service service = mock(Service.class);
        when(service.cicuska(anyInt())).thenReturn(22);
        when(service.cicuska(27)).thenReturn(201);
        assertEquals(22, service.cicuska(200));
        assertEquals(201, service.cicuska(27));
    }

    @Test
    public void testAnythingMockito() {
        Service service = mock(Service.class);
        when(service.findUser()).thenReturn(Arrays.asList(
            new User("John", 56),
            new User("Wick", 77)));
        Controller controller = new Controller(service);
        List<User> elderlyUsers = controller.getElderlyUsers();
        assertEquals(1, elderlyUsers.size());
        verify(service).findUser();
    }

    @Test
    public void testAnything() {
        Service service = new Service(){
            @Override
            public List<User> findUser() {
                return Arrays.asList(new User("John", 56),
                    new User("Wick", 77));
            }
        };
        Controller controller = new Controller(service);
        List<User> elderlyUsers = controller.getElderlyUsers();
        assertEquals(1, elderlyUsers.size());
    }

}