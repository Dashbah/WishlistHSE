package dashbah.wishlistapp.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;     // TODO: hash it in the future

    @Column(name = "role")
    private String role; // TODO: change to enum

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<GiftEntity> gifts = new ArrayList<>();

    public void addGift(GiftEntity gift) {
        gifts.add(gift);
    }

    public void removeGift(GiftEntity gift) {
        gifts.remove(gift);
    }
}
