package com.imsouane.aftas.dto.memberDTO;

import com.imsouane.aftas.domain.entities.Member;
import lombok.Builder;

import java.time.LocalDate;
import java.util.List;

@Builder
public record MemberResponseDto(
        Integer num,
        String full_name,
        LocalDate accession_date,
        String nationality,
        String identity_document_type,
        String identity_number
) {
    public static MemberResponseDto fromMember(Member member) {
        return MemberResponseDto.builder()
                .num(member.getNum())
                .full_name(member.getName() + " " + member.getFamilyName())
                .accession_date(member.getAccessionDate())
                .nationality(member.getNationality())
                .identity_document_type(String.valueOf(member.getIdentityDocumentType()))
                .identity_number(member.getIdentityNumber())
                .build();
    }

    public static List<MemberResponseDto> fromMembers(List<Member> members) {
        return members.stream().map(MemberResponseDto::fromMember).toList();
    }
}
