package com.piotr.flightsearchapi.mapper.impl;

import com.piotr.flightsearchapi.domain.CreateFavoriteRequest;
import com.piotr.flightsearchapi.domain.dto.CreateFavoriteRequestDto;
import com.piotr.flightsearchapi.domain.dto.FavoriteDto;
import com.piotr.flightsearchapi.domain.entity.Favorite;
import com.piotr.flightsearchapi.mapper.FavoriteMapper;
import org.springframework.stereotype.Component;

@Component
public class FavoriteMapperImpl implements FavoriteMapper {
    @Override
    public CreateFavoriteRequest fromDto(CreateFavoriteRequestDto dto) {
        return new CreateFavoriteRequest(
                dto.FlightId()
        );
    }

    @Override
    public FavoriteDto toDto(Favorite favorite) {
        return new FavoriteDto(
                favorite.getId(),
                favorite.getUserId(),
                favorite.getFlightId()
        );
    }
}
