package com.piotr.flightsearchapi.controller;

import com.piotr.flightsearchapi.domain.CreateFavoriteRequest;
import com.piotr.flightsearchapi.domain.dto.CreateFavoriteRequestDto;
import com.piotr.flightsearchapi.domain.dto.FavoriteDto;
import com.piotr.flightsearchapi.domain.entity.Favorite;
import com.piotr.flightsearchapi.mapper.FavoriteMapper;
import com.piotr.flightsearchapi.service.FavoriteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FavoriteController {

    private final FavoriteService favoriteService;
    private final FavoriteMapper favoriteMapper;

    public FavoriteController(FavoriteService favoriteService, FavoriteMapper favoriteMapper) {
        this.favoriteService = favoriteService;
        this.favoriteMapper = favoriteMapper;
    }

    @GetMapping("/api/v1/auth/{userId}/favorites")
    public ResponseEntity<List<FavoriteDto>> listFavorites(
            @PathVariable Integer userId
    ) {
        List<Favorite> favorites = favoriteService.getFavoriteByUserId(userId);
        List<FavoriteDto> favoriteDtos = favorites.stream().map(favoriteMapper::toDto).toList();
        return ResponseEntity.ok(favoriteDtos);
    }

    @PostMapping("/api/v1/auth/{userId}/favorites")
    public ResponseEntity<?> addFavorite(
            @PathVariable Integer userId,
            @RequestBody CreateFavoriteRequestDto createFavoriteRequestDto
    ) {
        CreateFavoriteRequest createFavoriteRequest = favoriteMapper.fromDto(createFavoriteRequestDto);
        Favorite favorite = favoriteService.createFavorite(userId, createFavoriteRequest);
        FavoriteDto favoriteDto = favoriteMapper.toDto(favorite);
        return ResponseEntity.ok(favoriteDto);

    }

    @DeleteMapping("/api/v1/auth/{userId}/favorites/{favoriteId}")
    public ResponseEntity<?> deleteFavorite(
            @PathVariable Integer favoriteId
    ) {
        favoriteService.deleteFavorite(favoriteId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}
