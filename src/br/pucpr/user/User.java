package br.pucpr.user;

import br.pucpr.table.reflection.Column;

public record User(
    @Column(header = "ID") Long id,
    @Column(header = "Nome") String name,
    @Column(header = "E-mail") String email,
    @Column(header = "CPF") String cpf) {}
