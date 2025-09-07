package hoangtugio.org.springaopdemo;

import org.springframework.stereotype.Service;

@Service
public class OrderService {
    public void saveOrder( int id) {
        System.out.println(">>> Business logic: Saving order...");
    }
}