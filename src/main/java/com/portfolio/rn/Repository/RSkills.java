
package com.portfolio.rn.Repository;


import com.portfolio.rn.Entity.Skills;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RSkills extends JpaRepository<Skills, Integer>{
    public Optional<Skills> findByNombreSk(String nombreSk);
    public boolean existsByNombreSk(String nombreSk);
}
