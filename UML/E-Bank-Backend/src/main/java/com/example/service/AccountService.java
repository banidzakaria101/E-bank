package com.example.service;

import com.example.model.Account;
import com.example.model.Card;
import com.example.model.User;
import com.example.repository.AccountRepository;
import com.example.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepo;

    @Autowired
    private UserRepository userRepo;

    public Account addAccount(Long userId, Account account) {
        Optional<User> userOptional = userRepo.findById(userId);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            account.setHolderFirstName(user.getFirstName());
            account.setHolderLastName(user.getLastName());
            account.setHolderPhoneNumber(user.getPhoneNumber());
            account.setAccountNumber(generateAccountNumber());
            account.setUser(user);
            account.setCreatedAt(LocalDateTime.now());

            Card card = createCardForAccount(account);
            account.getCards().add(card);
            user.getAccounts().add(account);
            userRepo.save(user);

            return accountRepo.save(account);
        } else {
            throw new RuntimeException("User not found");
        }
    }

    private String generateAccountNumber() {
        Random rand = new Random();
        StringBuilder number = new StringBuilder();

        for (int i = 0; i < 16; i++) {
            int n = rand.nextInt(10);  // Generates a number between 0 and 9
            number.append(n);
        }

        StringBuilder formattedCard = new StringBuilder();
        for (int i = 0; i < 16; i++) {
            if (i % 4 == 0 && i != 0) {
                formattedCard.append(" ");
            }
            formattedCard.append(number.charAt(i));
        }

        return formattedCard.toString();
    }

    private Card createCardForAccount(Account account){
        Card card  = new Card();
        card.setCardNumber(account.getAccountNumber());
        card.setCardHolderName(account.getHolderFirstName() + " " + account.getHolderLastName());
        card.setExpiryDate(LocalDate.now().plusYears(8));
        card.setAccount(account);

        return card;
    }

    public List<Account> getAccountsByUserId(Long userId){
        return accountRepo.findAllByuserId(userId);
    }


    public void deleteAccount(Long accountId) {
            accountRepo.deleteById(accountId);
    }


}
