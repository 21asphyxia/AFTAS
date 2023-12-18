package com.imsouane.aftas.service.impl;

import com.imsouane.aftas.domain.entities.Competition;
import com.imsouane.aftas.domain.entities.Fish;
import com.imsouane.aftas.domain.entities.Hunt;
import com.imsouane.aftas.domain.entities.Member;
import com.imsouane.aftas.exception.HuntCreationException;
import com.imsouane.aftas.repository.HuntRepository;
import com.imsouane.aftas.service.CompetitionService;
import com.imsouane.aftas.service.FishService;
import com.imsouane.aftas.service.MemberService;
import com.imsouane.aftas.service.RankingService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class HuntServiceImplTest {

    @Mock
    private HuntRepository huntRepository;

    @Mock
    private FishService fishService;

    @Mock
    private CompetitionService competitionService;

    @Mock
    private MemberService memberService;

    @Mock
    private RankingService rankingService;

    @InjectMocks
    private HuntServiceImpl huntService;

    @Test
    public void save_shouldThrowException_whenCompetitionDateIsNotToday() {
        Hunt hunt = new Hunt();
        Fish fish = Fish.builder().id(1L).averageWeight(5.0).build();
        Member member = Member.builder().num(1).build();
        Competition competition = Competition.builder().code("code").date(LocalDate.now().plusDays(1)).build();
        competition.setDate(LocalDate.now().plusDays(1));
        hunt.setCompetition(competition);
        hunt.setFish(fish);
        hunt.setMember(member);

        when(fishService.findById(anyLong())).thenReturn(fish);
        when(competitionService.findByCode(anyString())).thenReturn(competition);

        when(competitionService.findByCode(anyString())).thenReturn(competition);

        assertThrows(HuntCreationException.class, () -> huntService.save(hunt, 3.0));
    }

    @Test
    public void save_shouldThrowException_whenWeightIsLessThanAverageWeight() {
        Hunt hunt = new Hunt();
        Fish fish = new Fish();
        fish.setAverageWeight(5.0);
        hunt.setFish(fish);

        when(fishService.findById(anyLong())).thenReturn(fish);

        assertThrows(HuntCreationException.class, () -> huntService.save(hunt, 3.0));
    }

    @Test
    public void findById_shouldReturnHunt_whenHuntExists() {
        Hunt hunt = new Hunt();

        when(huntRepository.findById(anyLong())).thenReturn(Optional.of(hunt));

        Hunt result = huntService.findById(1L);

        assertEquals(hunt, result);
    }

    @Test
    public void findById_shouldThrowException_whenHuntDoesNotExist() {
        when(huntRepository.findById(anyLong())).thenReturn(Optional.empty());

        assertThrows(HuntCreationException.class, () -> huntService.findById(1L));
    }
}