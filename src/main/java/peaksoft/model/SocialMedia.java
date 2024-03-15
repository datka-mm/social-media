package peaksoft.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.ZonedDateTime;

@Entity
@Table(name = "social_medias")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SocialMedia {

    @Id
    @GeneratedValue(generator = "social_gen", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "social_gen", sequenceName = "social_seq", allocationSize = 1)
    private Long id;
    private String name;
    private String logo;
    private ZonedDateTime publishedDate;


    @PrePersist
    private void prePersist() {
        this.publishedDate = ZonedDateTime.now();
    }


}
