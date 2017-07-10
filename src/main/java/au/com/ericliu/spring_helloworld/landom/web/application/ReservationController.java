package au.com.ericliu.spring_helloworld.landom.web.application;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by ericliu on 10/7/17.
 */


@Controller
@RequestMapping(value = "/reservations")
public class ReservationController {

    @RequestMapping(method = RequestMethod.GET)
    public String getReservations() {
        return "reservations";
    }

}
