package com.github.RandyDpoe45.client_server.config.startup;

import com.github.RandyDpoe45.client_server.persistence.enums.ClientStatusEnum;
import com.github.RandyDpoe45.client_server.persistence.jparepositories.ClientStatusJpaRepository;
import com.github.RandyDpoe45.client_server.persistence.model.ClientStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StartUpConfig {

    private final ClientStatusJpaRepository clientStatusJpaRepository;

    @EventListener(ContextRefreshedEvent.class)
    public void startUpConfig() {
        createClientStatuses();
    }

    private void createClientStatuses() {
        List<ClientStatus> currentClientStatuses = clientStatusJpaRepository.findAll();
        List<String> clientStatusNames = currentClientStatuses.stream().map(ClientStatus::getCode).toList();
        List<ClientStatusEnum> missingTypes = Arrays.stream(ClientStatusEnum.values())
                .filter(x -> !clientStatusNames.contains(x.getCode()))
                .toList();
        missingTypes.forEach(x -> clientStatusJpaRepository.save(new ClientStatus().setCode(x.getCode())));
    }

}
