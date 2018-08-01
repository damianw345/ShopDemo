package com.github.damianw345.shopdemo.service;

import com.github.damianw345.shopdemo.dto.IceCreamDto;
import com.github.damianw345.shopdemo.mapper.IceCreamMapper;
import com.github.damianw345.shopdemo.repository.IceCreamRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.ws.rs.BadRequestException;
import javax.ws.rs.NotFoundException;
import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class IceCreamService {


    private final IceCreamRepository iceCreamRepository;
    private final IceCreamMapper iceCreamMapper;

    public List<IceCreamDto> getAllIceCreams() {

        return Optional.ofNullable(iceCreamRepository.findAll())
                .map(iceCreamMapper::toDtoList)
                .orElseThrow(NotFoundException::new);
    }

    @Transactional
    public IceCreamDto addIceCream(IceCreamDto dto) {

        return Optional.ofNullable(dto)
                .map(iceCreamMapper::toEntity)
                .map(iceCreamRepository::save)
                .map(iceCreamMapper::toDto)
                .orElseThrow(BadRequestException::new);
    }

    public IceCreamDto getIceCream(Long id) {

        return Optional.ofNullable(iceCreamRepository.getOne(id))
                .map(iceCreamMapper::toDto)
                .orElseThrow(NotFoundException::new);
    }

    @Transactional
    public IceCreamDto updateIceCream(IceCreamDto dto, Long id) {

        return Optional.ofNullable(iceCreamRepository.getOne(id))
                .map(iceCream -> iceCreamMapper.updateEntity(iceCream, dto))
                .map(iceCreamRepository::save)
                .map(iceCreamMapper::toDto)
                .orElseThrow(NotFoundException::new);
    }

    @Transactional
    public void deleteIceCream(Long id) {
        iceCreamRepository.deleteById(id);
    }
}
