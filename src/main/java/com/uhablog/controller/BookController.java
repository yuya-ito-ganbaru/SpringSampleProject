package com.uhablog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.uhablog.form.BookForm;
import com.uhablog.model.Book;
import com.uhablog.service.BookService;

/*contorollerではユーザーからリクエストを受け取り、リクエストの内容に従ってサービスクラスを呼び出します。
 * サービスクラスから結果を受け取り、その結果をレスポンスとしてユーザーに返却します。
 * 
 */

//@Contorollerでコントローラーであることを宣言
@Controller
public class BookController {
	
	//@AutowiredでBookServiceのインスタンスを保持
	@Autowired
	BookService service;
	
	/**
	 * book-listを表示
	 * @param model
	 * @return book-list画面
	 */
	//GetMappingで「/book-List」にリクエストが来たときにbookListメソッドが実行
	@GetMapping("/book-list")
	//bookListメソッドではサービスクラスを使って、データベースからデータを取得し、modelに結果を格納します。
	public String bookList(Model model) {
		/*メソッドの説明
		 * 「http://localhost:8080/book-list」にアクセスがあったときのメソッド
		 * 本の情報をデータベースから取得して、画面に表示する
		 */
		// serviceを使って、本の一覧をDBから取得する
		List<Book> bookList = service.findAll();
		// modelに本の一覧を設定して、画面に渡す
		model.addAttribute("bookList", bookList);
		// bookList.htmlの表示
		//bookList.htmlを画面に表示します。
		return "bookList";
	}
	
	/**
	 * 新規登録画面を表示
	 * @param model
	 * @return 新規登録画面
	 */
	@GetMapping("/book-create")
    public String createBook(Model model) {
		/*メソッドの説明
		 * 「http://localhost:8080/book-create」にGetメソッドでリクエストがあったときのメソッド
		 * 本の新規登録画面を画面に表示する
		 */
        model.addAttribute("bookForm", new BookForm());

        return "add";
	}

	/**
	 * データベースに本を登録する
	 * @param bookForm
	 * @param model
	 * @return
	 */
	@PostMapping("/book-create")
	public String saveBook(@ModelAttribute @Validated BookForm bookForm, BindingResult result , Model model) {
		//BindingResultを受け取って、バリデーション結果を受け取る！
		/*メソッドの説明
		 * 「http://localhost:8080/book-create」にPostメソッドでリクエストがあったときのメソッド
		 * 画面で入力された情報をデータベースに登録する。
		 * 登録完了後は、一覧画面にリダイレクトする。
		 */
		
		//バリデーションエラーの場合
		if(result.hasErrors()) {
			//新規登録画面に遷移
			return "add";
		}
		
		//本を登録する
		service.insert(bookForm);
		
		//本の一覧表示画面にリダイレクト
		return "redirect:/book-list";
	}
	
	
	
}
