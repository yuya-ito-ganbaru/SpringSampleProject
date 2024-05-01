package com.uhablog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uhablog.model.Book;

/*repositoryは実際にデータベースとのやりとりをするためのインターフェースです。
 * JpaRepositoryを継承して、データベースを操作するインターフェースを作成する。
 * BookRepositoryではJpaRepositoryインターフェースを継承しています。
 * JpaRepositoryインターフェースを継承することで、以下のような基本的なデータの取得するメソッドを自動で作成してくれます。
 * ①データの取得
 * ②データの挿入
 * ③データの更新
 * ④データの削除
 */

//今回は作成したBookクラスを操作するためのRepositoryを作成するため、
//JpaRepository<Book,Integer>としています。
//IntegerはBookクラスのIdの型を指定しています。
public interface BookRepository  extends JpaRepository<Book, Integer> {
//データベースにデータを新規登録するためのクラス
}
