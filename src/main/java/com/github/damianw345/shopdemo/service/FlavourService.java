package com.github.damianw345.shopdemo.service;

import com.github.damianw345.shopdemo.dao.Flavour;
import com.github.damianw345.shopdemo.dto.FlavourDto;
import com.github.damianw345.shopdemo.repository.FlavourRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.ws.rs.NotFoundException;
import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class FlavourService {

    private final FlavourRepository flavourRepository;

    public List<Flavour> getFlavours() {
        return flavourRepository.findAll();
    }

    public Flavour addFlavour(FlavourDto dto) {
        return flavourRepository.save(new Flavour(null, dto.getFlavourName()));
    }

    public Flavour getFlavour(Long id) {
        return flavourRepository.findById(id).orElseThrow(NotFoundException::new);
    }

    public void deleteFlavour(Long id) {
        flavourRepository.deleteById(id);
    }
}
