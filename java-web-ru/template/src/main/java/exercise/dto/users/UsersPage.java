package exercise.dto.users;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

// BEGIN
@AllArgsConstructor
@Getter
public class UsersPage {
    private List<UserPage> usersPage;
    private String header;
}
// END
