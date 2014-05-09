# 「はじめてのClojure」ソースコード

* first-project ... 4章で作成したLeiningenプロジェクト
* simple-web ... 5章で作成したウェブアプリケーションプロジェクト
* mongo ... 6章で作成したMongoDBサンプル
* postcode ... 7章で作成したテストプロジェクト
* luminus-sample ... 8章で作成したLuminusのサンプル
* shorter ... URL短縮サービス

## URL短縮サービス

src/shorter/models/には各章ごとのlinks.cljが存在しますので、利用したいファイルを、links.cljという名前で上書きして使ってください。

* links.clj ... 5章で作成するSTMバージョン
* links_db.clj ... 8章で作成するMongoDBへの保存するバージョン
* links_db_shortid.clj ... links_db.cljではMongoDBのIDをそのまま利用していたが、1から始まる連番をIDとするバージョン
