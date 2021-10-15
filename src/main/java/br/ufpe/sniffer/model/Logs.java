package br.ufpe.sniffer.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name = "logs")
@Data
@NoArgsConstructor
public class Logs {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String hora;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    @Size(min = 12, max = 12)
    private String mac;

}
