package com.example.test;


import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.stereotype.Repository;

/**
 * ユーザーテーブルを操作するためのRepository（リモコン）です。
 * このインターフェースを定義するだけで、データの保存・取得・削除が自動で行えるようになります。
 */
//@Repository
// JpaRepository<扱うEntityクラス, 主キー(ID)のデータ型> を指定します
public interface UserRepository extends JpaRepository<UserEntity, String> {
    
    // 基本的なデータベース操作（全件取得・ID検索・保存・削除）はすでにこの中に含まれています。
    // 必要に応じて、独自のSQLを発行するメソッドをここに追加することも可能です。
}
