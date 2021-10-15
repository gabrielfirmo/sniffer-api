package br.ufpe.sniffer.controller;

import br.ufpe.sniffer.model.Macs;
import br.ufpe.sniffer.repository.MacsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/macs")
public class MacsController {

    @Autowired
    private MacsRepository macsRepository;

    @GetMapping
    public List<Macs> getAllMacs(){
        return macsRepository.findAll();
    }

    @PostMapping
    public Macs createMac(@Valid @RequestBody Macs mac){
        return macsRepository.save(mac);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Macs> getMacById(@PathVariable(value = "id") Long macId) {
        Macs mac = macsRepository.findById(macId).orElseThrow();

        macsRepository.delete(mac);
        return ResponseEntity.ok().body(mac);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Macs> deleteMac(@PathVariable(value = "id") Long macId) {
        Macs mac = macsRepository.findById(macId).orElseThrow();

        macsRepository.delete(mac);
        return ResponseEntity.ok().body(mac);
    }

}
