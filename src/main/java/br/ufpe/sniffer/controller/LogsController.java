package br.ufpe.sniffer.controller;

import br.ufpe.sniffer.model.Logs;
import br.ufpe.sniffer.model.Macs;
import br.ufpe.sniffer.repository.LogsRepository;
import br.ufpe.sniffer.repository.MacsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@RequestMapping(value = "/logs")
public class LogsController {
    @Autowired
    private LogsRepository logsRepository;
    @Autowired
    private MacsRepository macsRepository;

    @PostMapping("/{mac}")
    public Logs createLog(@PathVariable(value = "mac")String macAddr){
        long id = macsRepository.findByMacAddress(macAddr);
        Macs mac = macsRepository.findById(id).orElseThrow();

        Logs log = new Logs();
        String pattern = "dd/MM/yyyy HH:mm:ss";
        log.setHora(DateTimeFormatter.ofPattern(pattern).format(ZonedDateTime.now(ZoneId.of("America/Recife"))));
        log.setMac(mac.getMac());
        log.setNome(mac.getNome());

        return logsRepository.save(log);
    }

    @GetMapping
    public List<Logs> getLogs(){
        return logsRepository.findAll();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Logs> deleteLog(@PathVariable(value = "id") Long logId) {
        Logs log = logsRepository.findById(logId).orElseThrow();

        logsRepository.delete(log);
        return ResponseEntity.ok().body(log);
    }
}
