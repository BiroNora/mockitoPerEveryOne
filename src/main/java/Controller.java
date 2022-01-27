import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Controller {
    private Service service;

    public Controller(Service service) {
        this.service = service;
    }

    public List<User> getElderlyUsers() {
        return service.findUser()
            .stream()
            .filter(x -> x.getAge() > 70)
            .collect(Collectors.toList());
    }
}
