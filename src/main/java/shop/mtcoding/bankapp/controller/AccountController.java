package shop.mtcoding.bankapp.controller;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import shop.mtcoding.bankapp.handler.CustomException;

@Controller
public class AccountController {

    @GetMapping("/depositForm")
    public String depositForm() {
        return "account/depositForm";
    }

    @GetMapping("/account/{id}")
    public String detailForm() {
        return "account/detail";
    }

    @GetMapping({ "/", "/account" })
    public String main() {
        throw new CustomException("인증되지 않았습니다", HttpStatus.UNAUTHORIZED);
        // return "account/main";
    }

    @GetMapping("saveForm")
    public String saveForm() {
        return "account/saveForm";
    }

    @GetMapping("transferForm")
    public String transferForm() {
        return "account/transferForm";
    }

    @GetMapping("withdrawForm")
    public String withdrawForm() {
        return "account/withdrawForm";
    }

}
