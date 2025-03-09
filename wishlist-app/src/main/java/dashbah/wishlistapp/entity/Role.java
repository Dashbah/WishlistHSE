package dashbah.wishlistapp.entity;

import jakarta.persistence.*;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;

import java.util.Set;

@Entity
@Table(name = "role")
@Getter

public class Role implements GrantedAuthority {
    @Id
    private Long id;
    private String name;
    @Transient
    @ManyToMany(mappedBy = "roles")
    private Set<UserEntity> users;

    @Override
    public String getAuthority() {
        return name;
    }
}
