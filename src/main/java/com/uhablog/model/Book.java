package com.uhablog.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;


/*modelクラスは、データベースのデータをJavaのクラスとして扱うために必要です。
 * modelクラスはテーブルのデータを保持する役割をもつ
 * modelパッケージ（modelフォルダ）にBook.javaを作成します。
 * BookクラスはPostgreSQLに作成したbooksinfoテーブルのデータを保持する役割を持っています。
 */

//@Dataで各フィールドのsetter,getterを自動で生成
@Data
@Entity
//@Tableは対応するテーブルを設定
@Table(name = "booksinfo")
public class Book {

	@Id
	//@GeneratedValueでidが自動で生成される値であることを明示
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	//@Columnでテーブルのどのカラムと対応しているか設定
    @Column(name="id")
    // 本のidを保持するフィールド
    private Integer id;
	
	@Column
	//　本のタイトルを保持するフィールド
	private String title;
	
	@Column
	//　本の値段を保持するフィールド
	private Integer price;
}
