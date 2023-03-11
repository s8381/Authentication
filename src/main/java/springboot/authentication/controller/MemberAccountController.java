package springboot.authentication.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import springboot.authentication.entity.MemberAccount;

@Controller
public class MemberAccountController {
    @GetMapping({"", "/login"})
    public String login(@ModelAttribute MemberAccount memberAccount){
        return "login";
    }
}
