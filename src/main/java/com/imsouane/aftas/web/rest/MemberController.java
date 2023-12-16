package com.imsouane.aftas.web.rest;

import com.imsouane.aftas.dto.memberDTO.MemberResponseDto;
import com.imsouane.aftas.service.impl.MemberServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/members")
public class MemberController {
    private final MemberServiceImpl memberService;

    @GetMapping
    public ResponseEntity<Iterable<MemberResponseDto>> findAll(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "10") Integer size) {
        return ResponseEntity.ok(MemberResponseDto.fromMembers(memberService.findAll(PageRequest.of(page, size))));
    }

    @GetMapping("/search")
    public ResponseEntity<List<MemberResponseDto>> search(@RequestParam String query) {
        return ResponseEntity.ok(MemberResponseDto.fromMembers(memberService.search(query)));
    }
}
