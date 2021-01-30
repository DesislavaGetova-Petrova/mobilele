package softuni.mobilele.mobilele.model.entities;

import softuni.mobilele.mobilele.model.entities.enums.UserRoleEnum;

import javax.persistence.*;

@Entity
@Table(name="user_roles")
public class UserRoleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected long id;

    @Enumerated(EnumType.STRING)
    private UserRoleEnum role;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public UserRoleEnum getRole() {
        return role;
    }

    public void setRole(UserRoleEnum role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "UserRoleEntity{" +
                "id=" + id +
                ", role=" + role +
                '}';
    }
}
