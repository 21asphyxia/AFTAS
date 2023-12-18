package com.imsouane.aftas.web.rest;

import com.imsouane.aftas.dto.memberDTO.MemberCreationRequestDto;
import com.imsouane.aftas.dto.memberDTO.MemberResponseDto;
import com.imsouane.aftas.service.MemberService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/members")
public class MemberController {
    private final MemberService memberService;

    @PostMapping
    public ResponseEntity<MemberResponseDto> save(@RequestBody @Valid MemberCreationRequestDto member) {
        return ResponseEntity.ok(MemberResponseDto.fromMember(memberService.save(MemberCreationRequestDto.toMember(member))));
    }

    @GetMapping
    public ResponseEntity<Iterable<MemberResponseDto>> findAll() {
        return ResponseEntity.ok(MemberResponseDto.fromMembers(memberService.findAll()));
    }

    @GetMapping("/search")
    public ResponseEntity<List<MemberResponseDto>> search(@RequestParam String query) {
        return ResponseEntity.ok(MemberResponseDto.fromMembers(memberService.search(query)));
    }
}
