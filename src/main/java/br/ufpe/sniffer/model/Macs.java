package br.ufpe.sniffer.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name = "macs")
@Data
@NoArgsConstructor
public class Macs {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false,unique = true)
    @Size(min = 12, max = 12)
    private String mac;


}
