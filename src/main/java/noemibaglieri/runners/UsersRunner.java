package noemibaglieri.runners;

import noemibaglieri.entities.User;
import noemibaglieri.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class UsersRunner implements CommandLineRunner {
        @Autowired
        private UsersService usersService;

        @Override
        public void run(String... args) throws Exception {
            try {
                usersService.saveUser(new User("agaribaldi", "Anna Garibaldi", "agaribaldi@example.com"));
                usersService.saveUser(new User("fbianchi", "Francesca Bianchi", "fbianchi@example.com"));
                usersService.saveUser(new User("dpellegrini", "Davide Pellegrini", "dpellegrini@example.com"));
                usersService.saveUser(new User("vgallo", "Valentina Gallo", "vgallo@example.com"));
                usersService.saveUser(new User("esantoro", "Elena Santoro", "esantoro@example.com"));
            } catch (Exception e) {
                System.out.println("[UserRunner] " + e.getMessage());
            }
        }
    }

