# Sample KMP Shared Components

このプロジェクトは、Kotlin Multiplatform (KMP) と Compose Multiplatform を使用して実装された UI
コンポーネントライブラリのサンプルです。
Android と iOS のそれぞれのネイティブアプリに部分的に組み込むことを目的としています。

## プロジェクトの目的

- KMP UI コンポーネントを独立したライブラリとして配布・利用する方式の検証
- ネイティブの状態管理（State）やナビゲーションと KMP UI の安全な接続
- Android (Jetpack Compose) と iOS (SwiftUI) での共通デザインシステムの適用

## 実装済みコンポーネント

コンポーネントは `shared/src/commonMain` 内でパッケージごとに整理されています。

- **Buttons**:
    - `PrimaryButton`: 標準的なボタン。独自のテーマカラーを適用。
    - `PulseLoadingButton`: ローディングアニメーション付きのボタン。
- **Cards**:
    - `ItemCard`: 汎用的なデータ表示カード。
    - `AnimatedExpandableCard`: タップで開閉アニメーションするカード。
- **List**:
    - `ScrollableCardList`: `LazyColumn` を使用した効率的なリスト表示。
- **Navigation**:
    - `AppTopAppBar`: ネイティブナビゲーションと連携可能なトップバー。
    - `AppNavigationBar`: タブ切り替え用のボトムナビゲーションバー。

## 配布と利用 (Distribution)

### Android (Local Maven)

Android アプリで利用するために、ローカルの Maven リポジトリにアーティファクトをパブリッシュします。

1. **パブリッシュの実行**:
   ```bash
   ./gradlew :shared:publishToMavenLocal
   ```
   > [!NOTE]
   > 環境変数 `ANDROID_PREFS_ROOT` と `ANDROID_USER_HOME` が競合してエラーが出る場合は、
   `unset ANDROID_PREFS_ROOT` を実行してからコマンドを試してください。

2. **Android アプリ側での利用**:
   `settings.gradle.kts` に `mavenLocal()` を追加し、`build.gradle.kts` で依存関係を指定します。
   ```kotlin
   implementation("com.example.samplekmpshared:shared:1.0.0")
   ```

### iOS (XCFramework)

Xcode プロジェクトで利用するために、XCFramework を生成します。

1. **XCFramework の生成**:
   ```bash
   ./gradlew :shared:assembleSharedReleaseXCFramework
   ```
   生成された XCFramework は以下のパスに出力されます。
   `shared/build/XCFrameworks/release/Shared.xcframework`

2. **iOS アプリ側での利用**:
   生成された `Shared.xcframework` を Xcode プロジェクトの "Frameworks, Libraries, and Embedded
   Content" にドラッグ&ドロップして追加してください。

## プラットフォーム統合

### Android

KMP の `@Composable` 関数を直接呼び出すことができます。

### iOS (SwiftUI)

`iosMain` に用意された `ComponentFactories` を介して、各コンポーネントを `UIViewController`
として取得し、SwiftUI で利用します。

## プロジェクト構成

```text
shared/
├── src/
│   ├── commonMain/kotlin/com/example/samplekmpshared/
│   │   ├── component/      # UI コンポーネント
│   │   ├── model/          # 共通データモデル
│   │   ├── theme/          # 独自テーマ
│   │   └── preview/        # プレビュー定義 (@ComponentPreview)
│   └── iosMain/kotlin/com/example/samplekmpshared/
│       └── integration/    # iOS 向け UIViewController Factory
```

## 実行方法

- **Android**: `./gradlew :androidApp:assembleDebug`
- **iOS**: `iosApp/` ディレクトリを Xcode で開き実行。
