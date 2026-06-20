package com.piotr.flightsearchapi.service;

import com.piotr.flightsearchapi.domain.CreateFavoriteRequest;
import com.piotr.flightsearchapi.domain.entity.Favorite;

import java.util.List;

public interface FavoriteService {
    List<Favorite> getAllFavorites();
    List<Favorite> getFavoriteByUserId(Integer userId);
    Favorite createFavorite(Integer userId, CreateFavoriteRequest request);
    void deleteFavorite(Integer id);


}
