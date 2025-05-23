package microsoft.ghcp.advanced.GHCPDemo.controllers;

import microsoft.ghcp.advanced.GHCPDemo.models.User;
import microsoft.ghcp.advanced.GHCPDemo.proxy.OpenAIProxy;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController()
@RequestMapping("/users")
public class UsersController {

    @Autowired
    private OpenAIProxy openAIProxy;

    private final ArrayList<User> users = new ArrayList<>(List.of(new User("john_doe", "john@mail.com")));

    @GetMapping()
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok(users);
    }

    @GetMapping("/{username}")
    public ResponseEntity<User> getUserById(@PathVariable(name="username") String username) {
        var user = new User(username, "mail@mail.com");

        var foundUser = users.stream()
                .filter(u -> u.username().equals(username))
                .findFirst();
        if(foundUser.isPresent()) {
            return ResponseEntity.ok(foundUser.get());
        } else {
            users.add(user);
            System.out.println("User added: " + user);
        }
        return ResponseEntity.ok(user);
    }

    @GetMapping("/generate")
    public ResponseEntity<User> generateUser() {
        String username = openAIProxy.getResponse("Generate a random username");
        return ResponseEntity.ok(new User(username, username + "@mail.com"));
    }

}
