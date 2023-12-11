package com.imsouane.aftas.domain;

import com.imsouane.aftas.domain.enums.IdentityDocumentType;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@RequiredArgsConstructor
@Builder
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer num;
    private String name;
    private String familyName;
    private LocalDate accessionDate;
    private String nationality;
    @Enumerated(EnumType.STRING)
    private IdentityDocumentType identityDocumentType;
    private String identityNumber;
    @OneToMany(mappedBy = "member")
    @ToString.Exclude
    private List<Ranking> rankings;
    @OneToMany(mappedBy = "member")
    @ToString.Exclude
    private List<Hunt> hunts;

}
