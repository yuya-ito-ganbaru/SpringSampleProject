package com.uhablog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.uhablog.form.BookForm;
import com.uhablog.model.Book;
import com.uhablog.repository.BookRepository;

/*Serviceはcontrollerとrepositoryの橋渡し役のような役割です
 * serviceクラスはcontorollerとrepositoryの橋渡し的存在！
 * コントローラーでリクエストを受け取り、サービスクラスでデータベースとのやり取りや、処理を行います。
 */
@Service
@Transactional
//今回、サービスクラスの中にデータベースに登録されている本を全件取得するメソッドを作成します。
public class BookService {

	@Autowired
	//Autowiredで作成したBookRepositoryのインスタンスを保持します
	BookRepository repository;
	
	/**
	 * データベースから本の一覧を取得する
	 * @return
	 */
	//findAllメソッド
	public List<Book> findAll(){
		//BookRepositoryのインスタンスを使って、データベースからデータを取得して返却する。
		return repository.findAll();
	}
	
	/**
	 * データベースにデータを登録する
	 * @return
	 */
	public void insert(BookForm bookForm) {
		//入力値を受け取って、データを新規登録するメソッドを呼び出す。
		
		//データベースに登録する値を保持するインスタンス
		Book book = new Book();
		
		//画面から受け取った値をデータベースに保存するインスタンスに渡す
		book.setTitle(bookForm.getTitle());
		book.setPrice(bookForm.getPrice());
		
		//データベースに登録する
		repository.save(book);
	}
}
