<div style="text-align: center;">
<h1>Bloclchain with java</h1>
javaで作ったローカルなBlockchain
</div>

# Dependency

## Eclipse
    Version: Oxygen.2 Release (4.7.2)

## java 

    Version: 12.0.2

## gson

javaでjsonを扱うためのライブラリ

    Version: 2.8.2

# Setup

## プロジェクトのインポート

    Eclipseでプロジェクトを立ち上げて、ファイル -> インポート -> 一般 -> 既存のプロジェクトをワークスペースへ

    アーカイブ・ファイルの選択を選び、Blockchain_with_java.zipを選択し、完了

## 外部JAR gsonの追加

    下記からファイルをダウンロード、追加
    https://repo1.maven.org/maven2/com/google/code/gson/gson/2.8.2/

    プロジェクト名を右クリック -> プロパティ -> javaのビルドパス -> 外部JARの追加

    gson-2.8.2.jar

    gson-2.8.2-javadoc.jar

    gson-2.8.2-sources.jar

# Usage

    Bitcoin.java
        メインクラス
        ブロックチェーンを実際に動かす
        ブロックチェーンが有効かどうかの確認

    Block.java
        取引データ、ハッシュ、1つ前のブロックのハッシュ、タイムスタンプをもとにブロックを生成
        difficultyでマイニングの難易度を設定
        sha256でハッシュの生成、マイニングを行う

        マイニングはmainBlock関数でanswerをカウントアップしながらハッシュを変動させていき
        difficultyで設定された数だけ先頭に0がついたハッシュが見つかるまで行う

    Sha256Algorithm.java
        sha256暗号化アルゴリズム

# Authors
    sfuj1wara

# References
    [ブロックチェーンを作ってみました。](https://techblog.gmo-ap.jp/2018/12/26/%E3%83%96%E3%83%AD%E3%83%83%E3%82%AF%E3%83%81%E3%82%A7%E3%83%BC%E3%83%B3%E3%82%92%E4%BD%9C%E3%81%A3%E3%81%A6%E3%81%BF%E3%81%BE%E3%81%97%E3%81%9F%E3%80%82/)




