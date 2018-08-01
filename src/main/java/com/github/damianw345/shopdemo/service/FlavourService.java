package com.github.damianw345.shopdemo.service;

import com.github.damianw345.shopdemo.dao.Flavour;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class FlavourService {

    public List<Flavour> getFlavours() {
        return null;
    }

    public Flavour addFlavour(Flavour dto) {
        return null;
    }

    public Flavour getFlavour(Long id) {
        return null;
    }

    public void deleteFlavour(Long id) {

    }
}
