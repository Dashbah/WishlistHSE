package dashbah.wishlistapp.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "gift")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GiftEntity {
    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "gift_uid")
    private String giftUId;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "price")
    private double price;

    @Column(name = "url")
    private String url;
}
