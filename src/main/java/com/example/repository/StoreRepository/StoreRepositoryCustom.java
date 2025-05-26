package com.example.repository.StoreRepository;

import com.example.domain.Store;
import java.util.List;


public interface StoreRepositoryCustom {
    List<Store> dynamicQueryWithBooleanBuilder(String name, Float score);
}