//textはtaxtと書いてください（最初の方に間違えて、手遅れになっているので）

package com.example.test;

//import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

//@Repository
public interface TaxtRepository extends JpaRepository<TaxtEntity, String> {
    // nativeQuery=true を外し、Entityクラス名（TaxtEntity）とフィールド名（taxt）で指定する
@Query("SELECT t.taxt FROM TaxtEntity t")
List<String> All_getTitle();
}

