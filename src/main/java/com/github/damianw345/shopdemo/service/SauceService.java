package com.github.damianw345.shopdemo.service;

import com.github.damianw345.shopdemo.dto.ResponseDto;
import com.github.damianw345.shopdemo.dto.SauceDto;
import com.github.damianw345.shopdemo.entity.Sauce;
import com.github.damianw345.shopdemo.repository.SauceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.ws.rs.NotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class SauceService {

    private final SauceRepository sauceRepository;

    public List<ResponseDto> getSauces() {
        return sauceRepository.findAll()
                .stream().map(sauce -> new ResponseDto(sauce.getSauceId(), sauce.getSauceName())).collect(Collectors.toList());
    }

    @Transactional
    public ResponseDto addSauce(SauceDto dto) {

        Sauce sauce = sauceRepository.save(new Sauce(null, dto.getSauceName()));
        return new ResponseDto(sauce.getSauceId(), sauce.getSauceName());
    }

    public ResponseDto getSauce(Long id) {
        Sauce sauce =  sauceRepository.findById(id)
                .orElseThrow(NotFoundException::new);
        return new ResponseDto(sauce.getSauceId(), sauce.getSauceName());
    }

    @Transactional
    public void deleteSauce(Long id) {
        sauceRepository.deleteById(id);
    }
}
