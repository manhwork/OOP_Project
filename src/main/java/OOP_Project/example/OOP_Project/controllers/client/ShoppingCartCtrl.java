package OOP_Project.example.OOP_Project.controllers.client;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ShoppingCartCtrl {

    @GetMapping("/ShoppingCart")
    public String getShoppingCart() {
        return "client/ShoppingCart.html";
    }

}
