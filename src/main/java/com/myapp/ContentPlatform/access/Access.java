package com.myapp.ContentPlatform.access;

import com.myapp.ContentPlatform.model.post.UserOwned;
import com.myapp.ContentPlatform.model.user.Role;
import com.myapp.ContentPlatform.model.user.User;
import com.myapp.ContentPlatform.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class Access {

    private final UserRepository userRepository;


    public boolean deleteCheckAccess(UserOwned userOwned, Authentication authentication) {
        User user = userRepository.findByEmail(authentication.getName()).get();
        return ((userOwned.getUser().equals(user)) || (user.getAuthorities().contains(Role.ADMIN))
                || (user.getAuthorities().contains(Role.MODERATOR)));
    }

    public boolean editCheckAccess(UserOwned userOwned, Authentication authentication) {
        User user = userRepository.findByEmail(authentication.getName()).get();
        return ((userOwned.getUser().equals(user)) || (user.getAuthorities().contains(Role.ADMIN))
                || (user.getAuthorities().contains(Role.MODERATOR)));
    }

    public boolean addUserAccess(Authentication authentication) {
        User user = userRepository.findByEmail(authentication.getName()).get();
        return user.getRole().equals(Role.ADMIN);
    }


    public boolean updateUserAccess(User updater, User updatable) {
        return updater.getRole().equals(Role.ADMIN) && !updatable.getRole().equals(Role.ADMIN);
    }

    public boolean deleteUserAccess(User existingUser, User deleter) {
        return (deleter.getRole().equals(Role.ADMIN)) && !existingUser.getRole().equals(Role.ADMIN);
    }

    public boolean setRole(User user) {
        return user.getRole().equals(Role.ADMIN);
    }
}
