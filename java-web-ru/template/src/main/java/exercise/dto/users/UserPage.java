package exercise.dto.users;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

// BEGIN
@Getter
@Setter
@ToString
public final class UserPage {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;

    public UserPage(long id, String firstName, String lastName, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }
}
// END
