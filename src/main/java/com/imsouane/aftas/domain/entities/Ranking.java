package com.imsouane.aftas.domain.entities;

import com.imsouane.aftas.domain.entities.embeddable.RankId;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@RequiredArgsConstructor
@Builder
public class Ranking {
    @EmbeddedId
    private RankId id;
    @ManyToOne
    @JoinColumn(name = "member_id")
    @MapsId("memberId")
    private Member member;
    @ManyToOne
    @JoinColumn(name = "competition_code")
    @MapsId("competitionCode")
    private Competition competition;
    private Integer rank;
    private Integer score;

}
