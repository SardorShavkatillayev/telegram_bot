package org.example.user;

import org.example.bot.UpdateHandler;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.time.LocalDateTime;
import java.util.Optional;

public class UserService {
    UserRepository userRepository = UserRepository.getInstance();

    public User findByIdOrElseCreated(Update update, String chatId) {

        User user = new User();
        Optional<User> optionsUser = userRepository.findById(chatId);
        user = optionsUser.orElseGet(() -> User.builder()
                .id(chatId)
                .created(LocalDateTime.now())
                .update(LocalDateTime.now())
                .firstname(update.getMessage().getChat().getFirstName())
                .lastaname(update.getMessage().getChat().getLastName())
                .userState(UserState.NEW)
                .userRole(UserRole.CUSTOMER)
                .username(update.getMessage().getChat().getUserName())
                .build());
        if(optionsUser.isEmpty()){
            userRepository.add(user);
        }
        return user;
    }
}
