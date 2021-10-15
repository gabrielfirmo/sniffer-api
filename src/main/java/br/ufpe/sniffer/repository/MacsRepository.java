package br.ufpe.sniffer.repository;

import br.ufpe.sniffer.model.Macs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface MacsRepository extends JpaRepository<Macs, Long> {
    @Query("SELECT id FROM Macs WHERE mac = TRIM(LOWER(:macAddr))")
    public long findByMacAddress(@Param("macAddr")String macAddr);
}
