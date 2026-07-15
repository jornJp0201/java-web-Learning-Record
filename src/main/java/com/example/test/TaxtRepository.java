//textはtaxtと書いてください（最初の方に間違えて、手遅れになっているので）

package com.example.test;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface TaxtRepository extends JpaRepository<TaxtEntity, String> {
    
@Query("SELECT t.taxt FROM TaxtEntity t")
List<String> All_getTitle();
}

