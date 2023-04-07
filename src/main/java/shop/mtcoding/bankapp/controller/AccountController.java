package shop.mtcoding.bankapp.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import shop.mtcoding.bankapp.dto.user.AccountSaveReqDto;
import shop.mtcoding.bankapp.handler.CustomException;
import shop.mtcoding.bankapp.model.user.User;
import shop.mtcoding.bankapp.service.AccountService;

@Controller
public class AccountController {

@Autowired
private HttpSession session;

@Autowired
private AccountService accountService;

@PostMapping("/account") //Form태그에 action을 통해 /account쓰는 것 확인 가능
//postMapping은 폼태그의 매서드를 보고 하는것
    public String save(AccountSaveReqDto accountSaveReqDto) { //dto로 값을 받을수있음
        User principal = (User)session.getAttribute("principal");
        
        if (principal == null) {
            throw new CustomException("로그인을 먼저 해주세요", HttpStatus.UNAUTHORIZED);
            }

        if (accountSaveReqDto.getNumber() == null || accountSaveReqDto.getNumber().isEmpty()) {
            throw new CustomException("number를 입력해주세요", HttpStatus.BAD_REQUEST);
        }
        if (accountSaveReqDto.getPassword() == null || accountSaveReqDto.getPassword().isEmpty()) {
            throw new CustomException("password를 입력해주세요", HttpStatus.BAD_REQUEST);
        } 

        accountService.계좌생성(accountSaveReqDto, principal.getId());

        return "redirect:/";
    }


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
        // throw new CustomException("인증되지 않았습니다", HttpStatus.UNAUTHORIZED);
        return "account/main";
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
