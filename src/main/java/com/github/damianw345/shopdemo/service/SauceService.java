package com.github.damianw345.shopdemo.service;

import com.github.damianw345.shopdemo.dao.Sauce;
import com.github.damianw345.shopdemo.dto.SauceDto;
import com.github.damianw345.shopdemo.repository.SauceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.ws.rs.NotFoundException;
import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class SauceService {

    private final SauceRepository sauceRepository;

    public List<Sauce> getSauces() {
        return sauceRepository.findAll();
    }

    @Transactional
    public Sauce addSauce(SauceDto dto) {

        return sauceRepository.save(new Sauce(null, dto.getSauceName()));
    }

    public Sauce getSauce(Long id) {
        return sauceRepository.findById(id)
                .orElseThrow(NotFoundException::new);
    }

    @Transactional
    public void deleteSauce(Long id) {
        sauceRepository.deleteById(id);
    }
}
