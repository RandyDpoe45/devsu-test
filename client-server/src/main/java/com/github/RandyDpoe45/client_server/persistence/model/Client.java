package com.github.RandyDpoe45.client_server.persistence.model;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Entity
@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
public class Client extends Person{

    private String password;

    @ManyToOne(targetEntity = ClientStatus.class, fetch = FetchType.EAGER)
    private ClientStatus clientStatus;
}
