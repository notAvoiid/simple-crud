package com.mrzzom.simple2.service;

import com.mrzzom.simple2.exceptions.EntityNotFoundException;
import com.mrzzom.simple2.model.client.Client;
import com.mrzzom.simple2.model.dto.v1.client.ClientRequestDTO;
import com.mrzzom.simple2.model.dto.v1.client.ClientResponseDTO;
import com.mrzzom.simple2.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class ClientService {

    private final ClientRepository repository;
    private final ModelMapper mapper;

    @Transactional(readOnly = true)
    public List<ClientResponseDTO> findAll(){
        return repository.findAll()
                .stream()
                .map(this::entityToDto)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public ClientResponseDTO findById(Long id) {
        return repository.findById(id)
                .map(this::entityToDto)
                .orElseThrow(
                () -> new EntityNotFoundException(String.format("ID=%s not found!", id))
        );
    }

    @Transactional
    public ClientResponseDTO save(ClientRequestDTO request) {
        log.info("Creating a client!");
        Client client = new Client(request);
        ClientResponseDTO dto = mapper.map(repository.save(client), ClientResponseDTO.class);
        return dto;
    }

    @Transactional
    public ClientResponseDTO update(ClientRequestDTO request, Long id) {
        Client client = repository.findById(id)
                .orElseThrow(
                () -> new EntityNotFoundException(String.format("ID=%S not found!", id))
        );

        client.setFirstName(request.getFirstName());
        client.setEmail(request.getEmail());
        client.setPhoneNumber(request.getPhoneNumber());
        client.setProducts(request.getProducts());

        ClientResponseDTO response = mapper.map(repository.save(client), ClientResponseDTO.class);
        return response;
    }

    @Transactional
    public void delete(Long id){
        Client client = repository.findById(id).orElseThrow(
                () -> new EntityNotFoundException(String.format("ID=%s not found!", id))
        );
        repository.delete(client);
    }

    private ClientResponseDTO entityToDto(Client client) {
        return mapper.map(client, ClientResponseDTO.class);
    }

}
