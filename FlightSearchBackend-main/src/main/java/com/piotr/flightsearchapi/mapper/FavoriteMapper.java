package com.piotr.flightsearchapi.mapper;

import com.piotr.flightsearchapi.domain.CreateFavoriteRequest;
import com.piotr.flightsearchapi.domain.dto.CreateFavoriteRequestDto;
import com.piotr.flightsearchapi.domain.dto.FavoriteDto;
import com.piotr.flightsearchapi.domain.entity.Favorite;


public interface FavoriteMapper {

    CreateFavoriteRequest fromDto(CreateFavoriteRequestDto dto);
    FavoriteDto toDto(Favorite favorite);
}
