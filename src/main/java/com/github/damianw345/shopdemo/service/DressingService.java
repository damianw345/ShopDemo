package com.github.damianw345.shopdemo.service;

import com.github.damianw345.shopdemo.dto.DressingDto;
import com.github.damianw345.shopdemo.dto.ResponseDto;
import com.github.damianw345.shopdemo.entity.Dressing;
import com.github.damianw345.shopdemo.repository.DressingRepository;
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
public class DressingService {

    private final DressingRepository dressingRepository;

    public List<ResponseDto> getDressings() {

        return dressingRepository.findAll()
                .stream().map(dressing -> new ResponseDto(dressing.getDressingId(), dressing.getDressingName())).collect(Collectors.toList());

    }

    @Transactional
    public ResponseDto addDressing(DressingDto dto) {

        Dressing dressing = dressingRepository.save(new Dressing(null, dto.getDressingName()));
        return new ResponseDto(dressing.getDressingId(), dressing.getDressingName());
    }

    public ResponseDto getDressing(Long id) {
        Dressing dressing = dressingRepository.findById(id)
                .orElseThrow(NotFoundException::new);
        return new ResponseDto(dressing.getDressingId(), dressing.getDressingName());
    }

    @Transactional
    public void deleteDressing(Long id) {
        dressingRepository.deleteById(id);
    }
}
