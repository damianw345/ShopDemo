package com.github.damianw345.shopdemo.service;

import com.github.damianw345.shopdemo.dto.ResponseDto;
import com.github.damianw345.shopdemo.entity.Flavour;
import com.github.damianw345.shopdemo.dto.FlavourDto;
import com.github.damianw345.shopdemo.repository.FlavourRepository;
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
public class FlavourService {

    private final FlavourRepository flavourRepository;

    public List<ResponseDto> getFlavours() {
        return flavourRepository.findAll()
                .stream().map(flavour -> new ResponseDto(flavour.getFlavourId(), flavour.getFlavourName())).collect(Collectors.toList());
    }

    @Transactional
    public ResponseDto addFlavour(FlavourDto dto) {
        Flavour flavour = flavourRepository.save(new Flavour(null, dto.getFlavourName()));
        return new ResponseDto(flavour.getFlavourId(), flavour.getFlavourName());
    }

    public ResponseDto getFlavour(Long id) {
        Flavour flavour =  flavourRepository.findById(id).orElseThrow(NotFoundException::new);
        return new ResponseDto(flavour.getFlavourId(), flavour.getFlavourName());
    }

    @Transactional
    public void deleteFlavour(Long id) {
        flavourRepository.deleteById(id);
    }
}
