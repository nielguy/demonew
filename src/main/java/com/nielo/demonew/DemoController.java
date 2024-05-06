package com.nielo.demonew;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/demo")
public class DemoController {

    @Autowired
    private DemoRepository demoRepository;

    @PostMapping
    public ResponseEntity<DemoModel> createDemoNew(@RequestBody DemoNew demoNew) {
        DemoNew demoNew1 = demoRepository.save(demoNew);
        DemoModel demoModel = new DemoModel(demoNew1.getUsername(), demoNew1.getPassword());
        return ResponseEntity.status(HttpStatus.CREATED).body(demoModel);
    }
}
