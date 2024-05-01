package com.uhablog.form;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

/*ユーザーが画面で入力した値を保持するクラス
 * ユーザーからの入力値を保持するためのクラス
 * 画面では本のタイトルと値段の入力を受付つけます。
 */

@Data
public class BookForm {
	
	/**
	 * 本のタイトルを保持する
	 * チェック内容：空でないこと
	 */
	
	@NotBlank(message="タイトルを入力してください。")
	private String title;
	
	/**
	 * 本の値段を保持する
	 * チェック内容：Nullでないこと、プラスであること
	 */
	@NotNull(message="値段を入れてください。")
	@Positive(message="値段はプラスの値で入力してください。")
	private Integer price;

}
