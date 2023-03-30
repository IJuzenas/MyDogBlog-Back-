package com.app.App.repositories;

import com.app.App.entities.Element;
import com.app.App.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ElementRepository extends JpaRepository<Element, Long> {
    @Query(value = "SELECT * FROM ELEMENTS", nativeQuery = true)
    List<Element> getAllElements();
}
