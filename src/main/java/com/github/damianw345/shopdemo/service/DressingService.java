package com.github.damianw345.shopdemo.service;

import com.github.damianw345.shopdemo.dao.Dressing;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class DressingService {

    public List<Dressing> getDressings() {
        return null;
    }

    public Dressing addDressing(Dressing dto) {
        return null;
    }

    public Dressing getDressing(Long id) {
        return null;
    }

    public void deleteDressing(Long id) {

    }
}
