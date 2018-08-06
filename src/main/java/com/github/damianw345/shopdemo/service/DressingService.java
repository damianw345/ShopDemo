package com.github.damianw345.shopdemo.service;

import com.github.damianw345.shopdemo.dao.Dressing;
import com.github.damianw345.shopdemo.dto.DressingDto;
import com.github.damianw345.shopdemo.repository.DressingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.ws.rs.NotFoundException;
import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class DressingService {

    private final DressingRepository dressingRepository;

    public List<Dressing> getDressings() {

        return dressingRepository.findAll();
    }

    @Transactional
    public Dressing addDressing(DressingDto dto) {

        return dressingRepository.save(new Dressing(null, dto.getDressingName()));
    }

    public Dressing getDressing(Long id) {
        return dressingRepository.findById(id)
                .orElseThrow(NotFoundException::new);
    }

    @Transactional
    public void deleteDressing(Long id) {
        dressingRepository.deleteById(id);
    }
}
