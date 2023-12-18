package com.imsouane.aftas.dto.memberDTO;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.imsouane.aftas.domain.entities.Member;
import com.imsouane.aftas.domain.enums.IdentityDocumentType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;

import java.time.LocalDate;
@Builder
public record MemberCreationRequestDto(
        @NotNull(message = "Member number is mandatory")
        Integer num,
        @NotBlank(message = "Member name is mandatory")
        String name,
        @NotBlank(message = "Member family name is mandatory")
        String familyName,
        @NotBlank(message = "Member nationality is mandatory")
        String nationality,
        @NotBlank(message = "Member identity document type is mandatory")
        String identityDocumentType,
        @NotBlank(message = "Member identity number is mandatory")
        String identityNumber
) {
    public static Member toMember(MemberCreationRequestDto memberCreationRequestDto){
        return Member.builder()
                .num(memberCreationRequestDto.num())
                .name(memberCreationRequestDto.name())
                .familyName(memberCreationRequestDto.familyName())
                .nationality(memberCreationRequestDto.nationality())
                .identityDocumentType(IdentityDocumentType.valueOf(memberCreationRequestDto.identityDocumentType()))
                .identityNumber(memberCreationRequestDto.identityNumber())
                .build();
    }
}
