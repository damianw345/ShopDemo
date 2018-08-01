package com.github.damianw345.shopdemo.service;

import com.github.damianw345.shopdemo.dao.Sauce;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class SauceService {

    public List<Sauce> getSauces() {
        return null;
    }

    public Sauce addSauce(Sauce dto) {
        return null;
    }

    public Sauce getSauce(Long id) {
        return null;
    }

    public void deleteSauce(Long id) {

    }
}
