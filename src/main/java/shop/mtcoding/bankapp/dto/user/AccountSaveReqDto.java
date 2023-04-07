package shop.mtcoding.bankapp.dto.user;

import lombok.Getter;
import lombok.Setter;
import shop.mtcoding.bankapp.model.account.Account;

@Setter
@Getter
public class AccountSaveReqDto {
    private String number;
    private String password;


    public Account toModel(int principalId) {
        Account account = new Account();
        account.setNumber(number);
        account.setPassword(password);
        account.setUserId(principalId);
        account.setBalance(1000L);
        return account;
        }
        }
