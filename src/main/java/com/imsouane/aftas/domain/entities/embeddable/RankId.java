package com.imsouane.aftas.domain.entities.embeddable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;

import java.io.Serializable;

@Embeddable
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@ToString
public class RankId implements Serializable {
    @Column(name = "member_id")
    private Long memberId;

    @Column(name = "competition_code")
    private String competitionCode;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RankId rankId)) return false;
        return memberId.equals(rankId.memberId) && competitionCode.equals(rankId.competitionCode);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((memberId == null) ? 0 : memberId.hashCode());
        result = prime * result + ((competitionCode == null) ? 0 : competitionCode.hashCode());
        return result;
    }
}
