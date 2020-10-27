package com.doruareabe.manko_webstore.service.generalInterfaces;

import java.util.List;

public interface GeneralCRUDInterface<T> {
    T findById(Long id);
    void deleteById(Long id);
    List<T> findAll();
    T save(T variable);
}
