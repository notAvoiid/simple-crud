package com.mrzzom.simple2.controller;

import com.mrzzom.simple2.model.dto.v1.client.ClientRequestDTO;
import com.mrzzom.simple2.model.dto.v1.client.ClientResponseDTO;
import com.mrzzom.simple2.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/client")
@RequiredArgsConstructor
public class ClientController {

    private final ClientService service;

    @GetMapping("{id}")
    public ResponseEntity<ClientResponseDTO> findById(@PathVariable Long id){
        ClientResponseDTO dto = service.findById(id);
        return ResponseEntity.ok(dto);
    }

    @GetMapping
    public ResponseEntity<List<ClientResponseDTO>> findAll(){
        List<ClientResponseDTO> dtoList = service.findAll();
        return ResponseEntity.ok(dtoList);
    }

    @PostMapping
    public ResponseEntity<ClientResponseDTO> save(@RequestBody ClientRequestDTO requestDTO) {
        ClientResponseDTO dto = service.save(requestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(dto);
    }

    @PutMapping("{id}")
    public ResponseEntity<ClientResponseDTO> update(@RequestBody ClientRequestDTO request, @PathVariable Long id) {
        ClientResponseDTO response = service.update(request, id);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
