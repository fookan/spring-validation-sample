# springのバリデーションのサンプル

1. 独自キーはValidationMessages.propertiesに記載するが、message.proertiesにできるように変更。
それは、messageSourceでエラーメッセージを取得したいため。
独自キーとは、アノテーションのmessage属性にキーを指定した場合です。
例）@Min(value = 1, message="{独自キー}")
2.

