// tag::baseClass[]
package tacos.controller;

import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
//end::baseClass[]
import org.springframework.web.bind.annotation.PostMapping;
//tag::baseClass[]
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import tacos.domain.Order;
import tacos.TacoCloudApplication;
import tacos.data.OrderRepository;

@Controller
@RequestMapping("/orders")
@SessionAttributes("order")
public class OrderController {

    private OrderRepository orderRepo;

    public OrderController(OrderRepository orderRepo) {
        this.orderRepo = orderRepo;
    }

//end::baseClass[]
//tag::orderForm[]
    @GetMapping("/current")
    public String orderForm(Model model) {
        model.addAttribute("order", new Order());
        return "orderForm";
    }
//end::orderForm[]

//tag::handlePostWithValidation[]
    @PostMapping
    public String processOrder(@Valid Order order, Errors errors,
            SessionStatus sessionStatus) {
        if (errors.hasErrors()) {
            return "orderForm";
        }

        TacoCloudApplication.log.info("Order submitted: " + order);
        orderRepo.save(order);
        sessionStatus.setComplete();

        return "redirect:/";
    }
//end::handlePostWithValidation[]

//tag::baseClass[]
}
//end::baseClass[]
